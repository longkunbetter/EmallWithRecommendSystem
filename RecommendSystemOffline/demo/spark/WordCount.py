from pyspark import SparkContext
from pyspark.sql.types import StructType

if __name__ == "__main__":
    sc = SparkContext("local", "demo")
    textFile = sc.textFile("c:/demo.txt")
    count = textFile.flatMap(lambda line : line.strip().split(" ")). \
            map(lambda word : (word, 1)). \
            reduceByKey(lambda v1, v2 : v1 + v2). \
            sortByKey(ascending=False)
    count.saveAsTextFile("c:/out")
    myStr = "hello haha"
    StructType(myStr.strip().split(" ").)

