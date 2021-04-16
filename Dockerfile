FROM java:8

ARG jarName
# cmd命令无法是被arg参数的值
ENV JAR_NAME ${jarName}
WORKDIR /data
ADD ${jarName}/target/${jarName}.jar ./${jarName}.jar
CMD java -jar ${JAR_NAME}.jar