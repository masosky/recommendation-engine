package com.buttons;

import java.util.Objects;

public final class Product {
    private final String tagId;
    private final String productName;

    public Product(String tagId, String productName) {
        this.tagId = tagId;
        this.productName = productName;
    }

    public String getTagId() {
        return tagId;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return tagId.equals(product.tagId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagId);
    }

    @Override
    public String toString() {
        return "Product{" +
                "tagId='" + tagId + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}

