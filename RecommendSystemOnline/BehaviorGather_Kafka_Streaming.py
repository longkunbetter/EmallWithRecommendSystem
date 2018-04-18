#coding=utf8
from pyspark import SparkContext
from pyspark.streaming import StreamingContext
from pyspark.streaming.kafka import KafkaUtils

# spark应用名
appName = 'Behavior-Kafka-Hive-Streaming'

# zookeeper地址
zkHost = '192.168.10.130:2181'
# 写入行为信息的topic
topic = 'userBehavior'

# 需要处理的行为类型
behaviorsSet = {'click', 'buy', 'addCart', 'browserCategory', 'search'}

# 根据行为类型处理每一条行为信息
def parseBehaviorMsg(rdd):
    hiveClient = 'x'

if __name__ == '__main__':
    sparkContext = SparkContext(appName = appName)
    streamingContext = StreamingContext(sparkContext, 15)
    # 创建kafka连接
    kafkaStream = KafkaUtils.createStream(streamingContext, zkHost, "kafka-streaming-hive", {topic: 1})

    # 正式处理逻辑主体
    # 1.根据制表符分割
    # 2.筛选出需要处理的信息(目前仅记录5种行为)
    # 2.根据传来的行为类别分别做处理
    kafkaStream.map(lambda msg : msg.strip().split('\t')) \
               .filter(lambda msg : msg[2] in behaviorsSet) \
               .foreachRDD(lambda rdd : parseBehaviorMsg(rdd))

    streamingContext.start()
    streamingContext.awaitTermination()
