package com.hdevelopers.converter.enums;

import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter<String, Currency> {
    @Override
    public Currency convert(String source) {
        try {
            return Currency.valueOf(source.toUpperCase());
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
