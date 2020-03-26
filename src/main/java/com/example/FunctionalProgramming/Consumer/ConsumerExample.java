package com.example.FunctionalProgramming.Consumer;

import com.example.FunctionalProgramming.Model.Customer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExample {

    static BiConsumer<Customer, Boolean> customerBooleanBiConsumer = ((customer, showPhoneNumber) -> {
        System.out.println("Hello " + customer.getCustomerName().toUpperCase() + ", " +
                "thank you for registering: " + customer.getPhoneNumber());

    });
    static Consumer<Customer> greetingsConsumer = customer ->
            System.out.println("Hello " + customer.getCustomerName().toUpperCase() + ", " +
                    "thank you for registering: " + customer.getPhoneNumber());

    public static void main(String[] args) {
        Customer maria = new Customer("Maria", "1212121212");
        greetings(maria);
        greetingsConsumer.accept(maria);
        greetingsBiConsumer(maria, false);
    }

    static void greetings(Customer customer) {
        System.out.println("Hello " + customer.getCustomerName().toUpperCase() + ", " +
                "thank you for registering: " + customer.getPhoneNumber());
    }

    static void greetingsBiConsumer(Customer customer, Boolean showPhoneNumber) {
        System.out.println("Hello " + customer.getCustomerName().toUpperCase() + ", " +
                "thank you for registering: " +
                (showPhoneNumber ? customer.getPhoneNumber() : "*********"));
    }


}
