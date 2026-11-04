package com.orders.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public abstract class Item {
    private final String id;
    private final String name;
    private final double price;
}