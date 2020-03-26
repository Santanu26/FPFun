package com.example.functionProgrammingPattern.StreamWreks.model;

import lombok.Data;

@Data
public class OrderLine {

    private Product product;

    private int itemCount;
}
