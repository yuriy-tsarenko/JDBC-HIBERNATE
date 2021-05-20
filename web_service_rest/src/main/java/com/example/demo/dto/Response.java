package com.example.demo.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {

    @SerializedName("code")
    public int code;

    @SerializedName("meta")
    public Meta meta;

    @SerializedName("data")
    public List<User> users;
}
