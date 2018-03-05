package top.kou.order.service.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import top.kou.order.service.remote.hystrix.RemoteMVCServiceHystrix;

/**
 * Created by Rizon on 2018/3/2.
 */
@FeignClient(name = "MVC-SERVICE",fallback = RemoteMVCServiceHystrix.class)
public interface RemoteMvcService {
    @RequestMapping(value = "/hello")
    String hello();
}
