package com.cbs.jdbc_hibernate.exapmles.lesson4.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    private String productCode;

    @Setter
    @Column(name = "productName")
    private String productName;

    @Column(name = "productLine")
    private String productLine;

    @Column(name = "productScale")
    private String productScale;

    @Column(name = "productVendor")
    private String productVendor;

    @Column(name = "productDescription")
    private String productDescription;

    @Column(name = "quantityInStock")
    private Integer quantityInStock;

    @Column(name = "buyPrice")
    private BigDecimal buyPrice;

    @Column(name = "MSRP")
    private BigDecimal alternatePrice;
}
