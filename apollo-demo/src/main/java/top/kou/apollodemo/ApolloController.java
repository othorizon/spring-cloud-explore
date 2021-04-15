package top.kou.apollodemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author rizon
 */
@RestController
public class ApolloController {

    @Autowired
    private Environment environment;

    @GetMapping("")
    public ResponseEntity<String> hello(String key) {
        return ResponseEntity.ok("this is " + environment.getProperty("spring.application.name") + "," + environment.getProperty("eureka.instance.instance-id")
                + ";   \n  " + (key != null ? (key + ":" + environment.getProperty(key)) : ""));
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("restTemplateRequest")
    public ResponseEntity<?> restTemplateRequest(@RequestParam String url) {
        //可以通过serviceName直接请求服务 eg. http://PRODUCT-SERVICE/
        return restTemplate.getForEntity(url, String.class);
    }
}
