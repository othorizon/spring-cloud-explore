package top.kou.simpledemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.skywalking.apm.toolkit.trace.Tag;
import org.apache.skywalking.apm.toolkit.trace.Tags;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rizon
 * @date 2021/4/16
 */
@RestController
public class SimpleController {
    private static final Logger log = LoggerFactory.getLogger(SimpleController.class);

    @GetMapping("")
    public ResponseEntity<String> hello() throws JsonProcessingException {
        final long currentTimeMillis = System.currentTimeMillis();
        log.info("this is simple demo:{}", new ObjectMapper().writeValueAsString(new HashMap<String, Object>(1) {{
            put("timestamp", currentTimeMillis);
        }}));
        Map<String, Object> result = callSomeMethod(currentTimeMillis);
        return ResponseEntity.ok("this is simple demo:" +
                new ObjectMapper().writeValueAsString(result));
    }

    /**
     * {@code @Trace} 启用自定义链路追踪 可以追踪方法的调用
     * {@code @Tags} 增加自定义tag信息
     * https://my.oschina.net/u/2344188/blog/4335247
     * https://blog.csdn.net/a17816876003/article/details/113702511
     */
    @Trace
    @Tags({@Tag(key = "csm_p0", value = "arg[0]")})
    private Map<String, Object> callSomeMethod(Long param) {
        return noTrace(param);
    }

    private Map<String, Object> noTrace(Long param) {
        return new HashMap<String, Object>(1) {{
            put("timestamp", param);
        }};
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
