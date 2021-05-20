package com.example.demo.dto;

import com.google.gson.annotations.SerializedName;

public class Pagination {

    @SerializedName("total")
    public int total;

    @SerializedName("pages")
    public int pages;

    @SerializedName("page")
    public int page;

    @SerializedName("limit")
    public int limit;
}

