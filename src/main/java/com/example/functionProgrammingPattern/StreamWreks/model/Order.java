package com.example.functionProgrammingPattern.StreamWreks.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class Order {

    private Long id;

    private List<OrderLine> orderLines;

    private LocalDate creationDate;
}
