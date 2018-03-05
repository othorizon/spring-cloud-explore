package top.kou.order.service.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.kou.biz.common.Response;
import top.kou.biz.product.Product;
import top.kou.order.service.remote.hystrix.RemoteProductServiceHystrix;

import java.util.Set;

@FeignClient(name = "Product-Service", fallback = RemoteProductServiceHystrix.class)
public interface RemoteProductService {

    @RequestMapping("/product/lookup")
    Response<Set<Product>> lookup(@RequestParam("id") Integer id, @RequestParam("name") String name);

    @RequestMapping("/getNeoHello")
    String hello();
}
