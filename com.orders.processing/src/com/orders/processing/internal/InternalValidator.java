package com.orders.processing.internal;

import com.orders.model.Item;
import com.orders.model.Order;
import com.orders.model.exceptions.InvalidOrderException;

public class InternalValidator {
    public static <T extends Item> void validate(Order<T> order) throws InvalidOrderException {
        if (order == null || order.getQuantity() <= 0) {
            throw new InvalidOrderException("Некорректный заказ");
        }
    }
}