package top.kou.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.kou.product.bus.BusConfiguration;
import top.kou.product.bus.BusMessageEvent;

import java.util.Map;

@RestController
public class TestBusController {
    @Autowired
    private ApplicationContext context;

    @Autowired
    @Qualifier("ListenerValue")
    private BusConfiguration.ListenerValue listenerValue;

    @RequestMapping("sendBus")
    public Map<String, String> testBus(@RequestParam(required = false) Map<String, String> params,
                                       @RequestParam(required = false) String destination) {
        String instanceId = context.getId();
        context.publishEvent(new BusMessageEvent(this, instanceId, destination, params));
        return listenerValue.value;
    }

    @RequestMapping("getBus")
    public Map<String, String> getBus() {
        return listenerValue.value;
    }
}
