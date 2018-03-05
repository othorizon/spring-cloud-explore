package top.kou.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kou.order.service.remote.RemoteMvcService;
import top.kou.order.service.remote.RemoteProductService;

/**
 * Created by Rizon on 2018/3/2.
 */
@RestController
public class RemoteController {

    @Autowired
    private RemoteMvcService mvcService;
    @Autowired
    private RemoteProductService productService;

    @RequestMapping("/mvchello")
    public String mvcHello() {
        return mvcService.hello();
    }
    @RequestMapping("product/hello")
    public String productHello() {
        return productService.hello();
    }
}
