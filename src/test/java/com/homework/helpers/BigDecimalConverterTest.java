package com.homework.helpers;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BigDecimalConverterTest {
    @Test
    void convertToDatabaseColumn() {
        BigDecimalConverter converter = new BigDecimalConverter();
        String string = converter.convertToDatabaseColumn(new BigDecimal(3));
        assertEquals("3", string);
    }

    @Test
    void convertToEntityAttribute() {
        BigDecimalConverter converter = new BigDecimalConverter();
        BigDecimal bigDecimal = converter.convertToEntityAttribute("3");
        assertEquals(new BigDecimal(3), bigDecimal);
    }
}