package com.homework.helpers;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.math.BigDecimal;

/**
 * Class which converts BigDecimal to String for our Jpa persistence.
 */
@Converter(autoApply = true)
public class BigDecimalConverter implements AttributeConverter<BigDecimal, String> {
    @Override
    public String convertToDatabaseColumn(BigDecimal attribute) {
        if (attribute == null) {
            return null;
        }
        return String.valueOf(attribute);
    }

    @Override
    public BigDecimal convertToEntityAttribute(String dbData) {
        return new BigDecimal(dbData);
    }
}
