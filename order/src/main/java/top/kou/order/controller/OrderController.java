package top.kou.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kou.biz.common.Response;
import top.kou.biz.order.Order;
import top.kou.order.model.OrderCreateBo;
import top.kou.order.model.OrderQueryBo;
import top.kou.order.service.OrderService;

import javax.validation.Valid;
import java.util.Set;

@RestController
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("this is order service");
    }

    @RequestMapping("/order/submit")
    public Response<Order> submit(@Valid @RequestBody OrderCreateBo createBo) {
        logger.info("Received Order Submit Request: {}", createBo);
        Order order = orderService.save(createBo);
        logger.info("Response Order Submitted: {}", order);
        return new Response<>(order);
    }

    @RequestMapping("/order/lookup")
    public Response<Set<Order>> lookup(@Valid OrderQueryBo queryBo) {
        logger.info("Received Order Query: {}", queryBo);
        Set<Order> orders = orderService.lookup(queryBo);
        logger.info("Response Order Query: {}", orders);
        return new Response<>(orders);
    }
}
