package top.kou.product.bus;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;


public class BusListener implements ApplicationListener<BusMessageEvent> {
    private final static Logger LOGGER = LoggerFactory.getLogger(BusListener.class);

    public BusListener() {
        LOGGER.info("register BusListener");
    }
    @Autowired
    @Qualifier("ListenerValue")
    private BusConfiguration.ListenerValue listenerValue;

    @Override
    public void onApplicationEvent(BusMessageEvent messageEvent) {
        listenerValue.value = messageEvent.getValues();
        LOGGER.info("get message,params:" + new Gson().toJson(listenerValue));
    }
}
