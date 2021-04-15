package top.kou.apollodemo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

/**
 * @author rizon
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApolloDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApolloDemoApplication.class, args);
    }
}
