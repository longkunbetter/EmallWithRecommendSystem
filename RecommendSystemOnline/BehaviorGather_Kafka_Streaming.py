# coding=utf8
from pyspark import SparkContext
from pyspark.sql.context import HiveContext
from pyspark.streaming import StreamingContext
from pyspark.streaming.kafka import KafkaUtils
from pyspark.sql.types import Row
from pyspark.sql.types import StructField
from pyspark.sql.types import StructType
from pyspark.sql.types import StringType
from pyspark.sql.context import SQLContext

# spark应用名
appName = 'Behavior-Kafka-Hive-Streaming'

# zookeeper地址
zkHost = '192.168.10.130:2181'
# 写入行为信息的topic
topic = 'userBehavior'

# 需要处理的行为类型
behaviorsSet = {'click', 'buy', 'addCart'}

if __name__ == '__main__':
    sparkContext = SparkContext(appName = appName)
    streamingContext = StreamingContext(sparkContext, 15)
    # spark sql 支持
    sqlContext = SQLContext(sparkContext)
    # 添加hive支持
    hiveContext = HiveContext(sparkContext)
    # 创建kafka连接
    kafkaStream = KafkaUtils.createStream(streamingContext, zkHost, "kafka-streaming-hive", {topic: 1})

    # 如果是点击或添加购物车操作更新用户推荐列表
    def updateUserRecommendList(msg):
        if (msg[2] == "click" or msg[2] == 'addCart'):
            print 'click---->' + msg[3]
        return msg

    # 定义存储行为的表模式
    schemaString = "time uid type content"
    fields = list(map(lambda fieldName: StructField(fieldName, StringType(), nullable=True), \
                      schemaString.split(" ")))
    schema = StructType(fields)
    # 将rdd存储到hive
    def saveRdd2Hive(rdd):
        # 处理空rdd
        if rdd.isEmpty():
            return

        rowRdd = rdd.map(lambda eachRow : Row(eachRow[0], eachRow[1], eachRow[2], eachRow[3]))
        dataFrame = sqlContext.createDataFrame(rowRdd, schema)
        dataFrame.registerTempTable("tempTable")
        dataFrame.show()
        hiveContext.sql("INSERT INTO userbehaviors SELECT * FROM tempTable")

    # 正式处理逻辑主体
    # 1.根据制表符分割
    # 2.筛选出需要处理的信息(目前仅记录5种行为)
    # 2.根据传来的行为类别分别做处理
    kafkaStream.map(lambda msg: msg[1].strip().split('\t')) \
               .filter(lambda msg: msg[2] in behaviorsSet) \
               .map(updateUserRecommendList) \
               .foreachRDD(saveRdd2Hive)

    # 启动streaming
    streamingContext.start()
    streamingContext.awaitTermination()
