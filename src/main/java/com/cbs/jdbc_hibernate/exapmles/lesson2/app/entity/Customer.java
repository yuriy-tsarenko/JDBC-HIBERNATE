package com.cbs.jdbc_hibernate.exapmles.lesson2.app.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@Getter
@Setter
public class Customer {

    @SerializedName("customerNumber")
    private Integer customerNumber;

    @SerializedName("customerName")
    private String customerName;

    @SerializedName("contactLastName")
    private String contactLastName;

    @SerializedName("contactFirstName")
    private String contactFirstName;

    @SerializedName("phone")
    private String phone;

    @SerializedName("addressLine1")
    private String addressLineOne;

    @SerializedName("addressLine2")
    private String addressLineTwo;

    @SerializedName("city")
    private String city;

    @SerializedName("state")
    private String state;

    @SerializedName("postalCode")
    private String postalCode;

    @SerializedName("country")
    private String country;

    @SerializedName("salesRepEmployeeNumber")
    private Integer salesRepEmployeeNumber;

    @SerializedName("creditLimit")
    private BigDecimal creditLimit;

    @SerializedName("customer_category")
    private String customerCategory;

}
