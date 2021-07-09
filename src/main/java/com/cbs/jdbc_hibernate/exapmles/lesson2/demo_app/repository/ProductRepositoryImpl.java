package com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.repository;

import com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.db_connector.DataBaseConnector;
import com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.entity.ProductEntity;
import com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.util.PrimaryKey;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import static com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.util.Constants.CHAR;

public class ProductRepositoryImpl implements ProductRepository {

    private static final Logger log = Logger.getLogger(ProductRepositoryImpl.class);

    @Override
    public void createProduct(ProductEntity productEntity) {
        try {
            DataBaseConnector.createConnection()
                    .execute("insert into"
                            + " products(productCode, productName, productLine, productScale, productVendor, "
                            + "productDescription, quantityInStock, buyPrice, MSRP)"
                            + " values ("
                            + CHAR + productEntity.getProductCode() + CHAR + ","
                            + CHAR + productEntity.getProductName() + CHAR + ","
                            + CHAR + productEntity.getProductLine() + CHAR + ","
                            + CHAR + productEntity.getProductScale() + CHAR + ","
                            + CHAR + productEntity.getProductVendor() + CHAR + ","
                            + CHAR + productEntity.getProductDescription() + CHAR + ","
                            + CHAR + productEntity.getQuantityInStock() + CHAR + ","
                            + CHAR + productEntity.getBuyPrice() + CHAR + ","
                            + CHAR + productEntity.getIndex() + CHAR
                            + ");");
            DataBaseConnector.closeConnection();

        } catch (SQLException e) {
            log.error(e);
        }
    }

    @Override
    public int updateProduct(Map<String, Object> args, String productCode) {
        PrimaryKey<String> primaryKey = new PrimaryKey<>();
        primaryKey.setKey("productCode");
        primaryKey.setValue(productCode);
        Statement connection = null;
        int update = 0;
        try {
            connection = DataBaseConnector.createConnection();
            update = connection.executeUpdate(queryBuilderUpdate(args, primaryKey, "products"));
            DataBaseConnector.closeConnection();
        } catch (Exception e) {
            log.error(e);
        }
        return update;
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return getAllEntities("SELECT * FROM products", ProductEntity.class);
    }

    @Override
    public ProductEntity getProduct(String productCode) {
        return getAllEntities("SELECT * FROM products WHERE productCode=" + CHAR + productCode + CHAR + ";",
                ProductEntity.class).stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("product not found"));
    }
}
