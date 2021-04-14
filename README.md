
Service     Port
--------------------
eureka-server      8000
config-server      8010
customer           8110
product            8120
order              8130


注意事项：
-----
1、eureka.instance.prefer-ip-address=true 以IP的方式注册
2、eureka.instance.instance-id=${spring.cloud.client.ipAddress}:${server.port} 以IP的方式展示

## spring cloud 继承apollo

https://github.com/ctripcorp/apollo/wiki/Java%E5%AE%A2%E6%88%B7%E7%AB%AF%E4%BD%BF%E7%94%A8%E6%8C%87%E5%8D%97
https://blog.csdn.net/hu_zhiting/article/details/89707448

## docker 部署

`docker-compose -f docker-compose.yml up -d --build`
`docker-compose -f docker-compose.yml up -d --build [serviceName]`

销毁清理
`docker-compose -f docker-compose.yml down --rmi all`

### 演示请求

restTemple请求也可以使用serviceName:  
http://localhost:8130/restTemplateRequest?url=http://PRODUCT-SERVICE

通过apollo读取配置:  
http://localhost:8130/apolloValue

### apollo的docker部署

https://github.com/ctripcorp/apollo/wiki/Apollo-Quick-Start-Docker%E9%83%A8%E7%BD%B2