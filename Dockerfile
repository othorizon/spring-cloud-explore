FROM java:8

ARG jarName
ENV JAR_NAME ${jarName}
WORKDIR /data
ADD ${jarName}/target/${jarName}.jar /data/${jarName}.jar
CMD java -jar /data/${JAR_NAME}.jar