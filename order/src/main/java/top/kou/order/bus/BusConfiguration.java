package top.kou.order.bus;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * Created by Rizon on 2018/3/6.
 */
@Configuration
@RemoteApplicationEventScan({"top.kou.order.bus"})
public class BusConfiguration {

    @Bean
    @ConditionalOnProperty(
            value = {"spring.cloud.bus.test.listener"},
            matchIfMissing = true
    )
    public BusListener initListener() {
        return new BusListener();
    }

    @Bean("ListenerValue")
    public ListenerValue initListenerValue() {
        return new ListenerValue();
    }

    public static class ListenerValue {
        public Map<String, String> value;
    }
}
