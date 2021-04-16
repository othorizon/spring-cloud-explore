package top.kou.simpledemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author rizon
 * @date 2021/4/16
 */
@RestController
public class SimpleController {
    private static final Logger log = LoggerFactory.getLogger(SimpleController.class);
    @GetMapping("")
    public ResponseEntity<String> hello() {
        log.info("this is simple demo");
        return ResponseEntity.ok("this is simple demo");
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("restTemplateRequest")
    public ResponseEntity<?> restTemplateRequest(@RequestParam String url) {
        log.info("restTemplateRequest:{}", url);
        return restTemplate.getForEntity(url, String.class);
    }
}
