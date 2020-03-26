package com.example.functionProgrammingPattern.StreamWreks.service;

import com.example.functionProgrammingPattern.StreamWreks.model.Order;
import com.example.functionProgrammingPattern.StreamWreks.model.OrderLine;
import com.example.functionProgrammingPattern.StreamWreks.model.Product;
import com.example.functionProgrammingPattern.StreamWreks.repo.ProductRepo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class ProductService {

    private ProductRepo productRepo;

    public List<Product> getFrequentOrderProduct(List<Order> orders) {

        return orders.stream()
                .filter(o -> o.getCreationDate().isAfter(LocalDate.now().minusYears(1)))
                .flatMap(o -> o.getOrderLines().stream())
                .collect(groupingBy(OrderLine::getProduct, summingInt(OrderLine::getItemCount)))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() >= 10)
                .map(Map.Entry::getKey)
                .filter(p -> !p.isDeleted())
                .filter(p -> !productRepo.getHiddenProductIds().contains(p.getId()))
                .collect(toList());
    }
}
