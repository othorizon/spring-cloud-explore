package top.kou.product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kou.biz.common.Response;
import top.kou.biz.product.Product;
import top.kou.product.model.ProductCreateBo;
import top.kou.product.model.ProductQueryBo;
import top.kou.product.service.ProductService;

import javax.validation.Valid;
import java.util.Set;

@RestController
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("this is product service");
    }

    @RequestMapping("/product/create")
    public Response<Product> create(@Valid ProductCreateBo createBo) {
        logger.info("Received Product Create Request: {}", createBo.toString());
        Product product = productService.save(createBo);
        logger.info("Response Product Create: {}", product);
        return new Response<>(product);
    }

    @RequestMapping("/product/lookup")
    public Response<Set<Product>> lookup(@Valid ProductQueryBo queryBo) {
        logger.info("Received Product Query Request: {}", queryBo);
        Set<Product> products = productService.lookup(queryBo);
        logger.info("Response Product Query: {}", products);
        return new Response<>(products);
    }
}
