FROM java:8

ARG jarName
# cmd命令无法是被arg参数的值
ENV JAR_NAME ${jarName}
WORKDIR /data
ADD ${jarName}/target/${jarName}.jar ./${jarName}.jar
ADD skywalking/agent ./agent
CMD java -javaagent:./agent/skywalking-agent.jar -jar ${JAR_NAME}.jar