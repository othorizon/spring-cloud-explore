package top.kou.product.bus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.cloud.bus.event.RemoteApplicationEvent;

import java.util.Map;

/**
 * Created by Rizon on 2018/3/6.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonIgnoreProperties({"source"})
@JsonTypeName("testListener1")
public class BusMessageEvent extends RemoteApplicationEvent {

    private final Map<String, String> values;

    private BusMessageEvent() {
        this.values = null;
    }

    public BusMessageEvent(Object source, String originService, String destinationService, Map<String, String> values) {
        super(source, originService, destinationService);
        this.values = values;
    }

    public Map<String, String> getValues(){
        return values;
    }

}
