package top.kou.order.controller;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rizon
 * @date 2021/4/14
 */
@RestController
@EnableApolloConfig
public class ApolloController {
    @Value("${apolloValue}")
    private String apolloValue;

    @GetMapping("apolloValue")
    public String apolloValue() {
        return apolloValue;
    }
}
