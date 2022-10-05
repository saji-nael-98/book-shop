package com.example.bookshop.utils;

import org.springframework.core.convert.converter.Converter;

import java.util.Arrays;
import java.util.Locale;

public class GenderConverter implements Converter<String, Gender> {
    @Override
    public Gender convert(String source) {
        try {
            return Gender.valueOf(source.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(String.format("select one of these %s", Arrays.toString(Gender.values())));
        }
    }
}
