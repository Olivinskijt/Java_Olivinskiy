package com.orders.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class Order<T extends Item> {
    private final String orderId;
    private final T item;
    private final int quantity;

    public double getTotalPrice() {
        return item.getPrice() * quantity;
    }
}