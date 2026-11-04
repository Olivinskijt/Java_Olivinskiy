package com.orders.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class Electronics extends Item {
    private final int warrantyMonths;
    private final String brand;

    @Builder
    public Electronics(String id, String name, double price, int warrantyMonths, String brand) {
        super(id, name, price);
        this.warrantyMonths = warrantyMonths;
        this.brand = brand;
    }
}