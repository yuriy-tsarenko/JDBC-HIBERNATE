package com.example.demo.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class User {
    @SerializedName(value = "id")
    public int id;

    @SerializedName(value = "name")
    public String name;

    @SerializedName(value = "email")
    public String email;

    @SerializedName(value = "gender")
    public String gender;

    @SerializedName(value = "status")
    public String status;

    @SerializedName(value = "created_at")
    public Date createdAt;

    @SerializedName(value = "updated_at")
    public Date updatedAt;
}
