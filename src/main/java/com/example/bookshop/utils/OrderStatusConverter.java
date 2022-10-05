package com.example.bookshop.utils;

import org.springframework.core.convert.converter.Converter;

import java.util.Arrays;
import java.util.Locale;

public class OrderStatusConverter implements Converter<String, OrderStatus> {
    @Override
    public OrderStatus convert(String source) {
        try {
            return OrderStatus.valueOf(source.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(String.format("select one of these %s", Arrays.toString(OrderStatus.values())));
        }
    }
}
