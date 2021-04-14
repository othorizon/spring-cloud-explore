
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

## docker 部署

`docker-compose -f docker-compose.yml up -d --build`

销毁清理
`docker-compose -f docker-compose.yml down --rmi all`
