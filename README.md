# spring-cloud-demo

实现了Eureka,Hystrix,Feign,Zuul,config,bus

配置   
spring.cloud.config.server.git.username=   
spring.cloud.config.server.git.password=   

在host配置    
127.0.0.1 eurekaserver1  
127.0.0.1 eurekaserver2    

启动顺序    
eureka-server1,eureka-server2,config-server,eureka-provider,eureka-consumer
   
访问http://localhost:3333/hello