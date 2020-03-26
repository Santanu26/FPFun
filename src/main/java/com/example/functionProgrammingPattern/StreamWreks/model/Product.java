package com.example.functionProgrammingPattern.StreamWreks.model;

import lombok.Data;

@Data
public class Product {

    private Long id;

    private boolean deleted;

    public boolean isNotDeleted() {
        return !deleted;
    }
}
