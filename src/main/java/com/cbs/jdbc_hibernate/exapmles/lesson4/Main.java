package com.cbs.jdbc_hibernate.exapmles.lesson4;

import com.cbs.jdbc_hibernate.exapmles.lesson4.entity.Product;
import com.cbs.jdbc_hibernate.exapmles.lesson4.service.ProductService;

import java.util.List;

public class Main {
    private static final ProductService productService = new ProductService();

    public static void main(String[] args) {
        List<Product> all = productService.getAll();
        Product product = productService.getById("S10_1678");
        System.out.println(product);
        product.setProductName("UPDATED3");

        productService.update(product);

        product = productService.getById("S10_1678");
        System.out.println(product);


//        System.out.println("before: " + product);
//        product.setProductName("mobile phone");
//        productService.update(product);
//        product = productService.getById("S10_949");
//        System.out.println("after: " + product);
    }
}
