package com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@Getter
@Setter
public class ProductEntity {

    @SerializedName("productCode")
    private String productCode;

    @SerializedName("productName")
    private String productName;

    @SerializedName("productLine")
    private String productLine;

    @SerializedName("productScale")
    private String productScale;

    @SerializedName("productVendor")
    private String productVendor;

    @SerializedName("productDescription")
    private String productDescription;

    @SerializedName("quantityInStock")
    private Integer quantityInStock;

    @SerializedName("buyPrice")
    private BigDecimal buyPrice;

    @SerializedName("MSRP")
    private BigDecimal index;
}
