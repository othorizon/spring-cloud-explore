# skywalking 全链路追踪

https://github.com/apache/skywalking/

## 配置

https://blog.csdn.net/lt326030434/article/details/107121511/
https://skywalking.apache.org/docs/main/latest/en/setup/service-agent/java-agent/readme/#table-of-agent-configuration-properties

### 启动日志追踪

https://skywalking.apache.org/docs/main/v8.5.0/en/setup/service-agent/java-agent/readme/#advanced-features-1
log4j2 例子：
https://skywalking.apache.org/docs/main/v8.5.0/en/setup/service-agent/java-agent/application-toolkit-log4j-2.x/
使用 gRPC reporter 可以收集日志



## demo

`docker-compose up -d sk-ui`
`docker-compose up -d --build sk-app-1 sk-app-2`