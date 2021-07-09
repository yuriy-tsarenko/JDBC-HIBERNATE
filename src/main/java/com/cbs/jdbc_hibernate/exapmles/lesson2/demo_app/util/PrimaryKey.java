package com.cbs.jdbc_hibernate.exapmles.lesson2.demo_app.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrimaryKey<T> {

    private String key;
    private T value;
}
