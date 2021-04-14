package top.kou.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author rizon
 * @date 2021/4/14
 */
@RestController
public class RestTemplateController {

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
