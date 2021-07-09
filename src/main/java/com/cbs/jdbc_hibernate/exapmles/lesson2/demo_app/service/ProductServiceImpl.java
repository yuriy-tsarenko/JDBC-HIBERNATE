package com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.service;

import com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.entity.ProductEntity;
import com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.repository.ProductRepository;
import com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.repository.ProductRepositoryImpl;

import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public ProductEntity getProductById(String productCode) {
        return productRepository.getProduct(productCode);
    }

    @Override
    public int updateProduct(Map<String, Object> args, String productCode) {
        return productRepository.updateProduct(args, productCode);
    }

    @Override
    public void createProduct(ProductEntity productEntity) {
        productRepository.createProduct(productEntity);
    }
}
