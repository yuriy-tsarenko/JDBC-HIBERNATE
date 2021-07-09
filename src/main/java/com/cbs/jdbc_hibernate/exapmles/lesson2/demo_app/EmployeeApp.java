package com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app;

import com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.entity.CustomerEntity;
import com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.entity.ProductEntity;
import com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.service.CustomerService;
import com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.service.CustomerServiceImpl;
import com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.service.ProductService;
import com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.service.ProductServiceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class EmployeeApp {

    private static final CustomerService customerService = new CustomerServiceImpl();
    private static final ProductService productService = new ProductServiceImpl();

    public static void main(String[] args) {
        // работаем с customers
        CustomerEntity customerEntityById = customerService.getCustomerById(148);
        System.out.println(customerEntityById);

        customerService.updateCustomer(Map.of("customerName", "Kate"), 148);

        customerEntityById = customerService.getCustomerById(148);
        System.out.println(customerEntityById);

        List<CustomerEntity> allCustomerEntities = customerService.getAllCustomers();
        allCustomerEntities.forEach(System.out::println);

        // работаем с products
        ProductEntity productById = productService.getProductById("S12_4675");
        System.out.println(productById);

        int updateProduct = productService.updateProduct(Map.of("productName", "1969 Dodge Charger R/T"), "S12_4675");
        System.out.printf("amount of updated rows is: %d\n", updateProduct);

        ProductEntity productByIdUpdated = productService.getProductById("S12_4675");
        System.out.println(productByIdUpdated);

        List<ProductEntity> allProducts = productService.getAllProducts();
        allProducts.forEach(System.out::println);

        ProductEntity entity = new ProductEntity();
        entity.setProductCode("S00001");
        entity.setBuyPrice(new BigDecimal("75.78"));
        entity.setIndex(new BigDecimal("45.78"));
        entity.setProductName("shelby Cobra 427 S/C");
        entity.setQuantityInStock(7933);

        productService.createProduct(entity);

        ProductEntity productByIdCreated = productService.getProductById("S00001");
        System.out.println(productByIdCreated);
    }
}
