package com.example.functionProgrammingPattern.StreamWreks.service;

import com.example.functionProgrammingPattern.StreamWreks.model.Order;
import com.example.functionProgrammingPattern.StreamWreks.model.OrderLine;
import com.example.functionProgrammingPattern.StreamWreks.model.Product;
import com.example.functionProgrammingPattern.StreamWreks.repo.ProductRepo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class ProductService {

    private ProductRepo productRepo;

    public List<Product> getFrequentOrderProduct(List<Order> orders) {
        List<Long> hiddenProductIds = productRepo.getHiddenProductIds();
        Predicate<Product> productIsNotHidden = p -> !hiddenProductIds.contains(p.getId());

        Stream<Product> frequentProducts = getProductCountsOverTheLastYear(orders).entrySet().stream()
                .filter(e -> e.getValue() >= 10)
                .map(Map.Entry::getKey);

        return frequentProducts
                .filter(Product::isNotDeleted)
                .filter(productIsNotHidden)
                .collect(toList());
    }

    private Map<Product, Integer> getProductCountsOverTheLastYear(List<Order> orders) {
        Predicate<Order> inThePreviousYear = o -> o.getCreationDate().isAfter(LocalDate.now().minusYears(1));
        return orders.stream()
                .filter(inThePreviousYear)
                .flatMap(o -> o.getOrderLines().stream())
                .collect(groupingBy(OrderLine::getProduct, summingInt(OrderLine::getItemCount)));
    }
}
