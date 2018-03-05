package top.kou.order.service.remote.hystrix;

import org.springframework.stereotype.Service;
import top.kou.biz.common.Response;
import top.kou.biz.product.Product;
import top.kou.order.service.remote.RemoteMvcService;
import top.kou.order.service.remote.RemoteProductService;

import java.util.Collections;
import java.util.Set;

@Service
public class RemoteMVCServiceHystrix implements RemoteMvcService {
    @Override
    public String hello() {
        return "its RemoteMVCServiceHystrix";
    }
}
