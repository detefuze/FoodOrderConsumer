package com.ru.klimashd.enums;

import com.ru.klimashd.classes.*;

public enum ProductType {
    FRUIT("fruits", Fruits.class),
    BAKERY("bakery", Bakery.class),
    VEGETABLE("vegetables", Vegetables.class),
    DAIRY("dairy", Dairy.class);

    private final String productType;
    private final Class<? extends Product> productClass;

    ProductType(String productType, Class<? extends Product> productClass) {
        this.productType = productType;
        this.productClass = productClass;
    }

    public String getProductTypeString() {
        return productType;
    }

    public Class<? extends Product> getProductClass() {
        return productClass;
    }

    public static Class<? extends Product> fromString(String value) {
        for (ProductType type : ProductType.values()) {
            if (type.productType.equalsIgnoreCase(value)) {
                return type.productClass;
            }
        }
        throw new IllegalArgumentException("Unknown product type: " + value);
    }
}
