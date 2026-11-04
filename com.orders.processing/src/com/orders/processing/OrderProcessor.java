package com.orders.processing;

import com.orders.model.Item;
import com.orders.model.Order;
import com.orders.processing.internal.InternalValidator;

public class OrderProcessor {
    public static <T extends Item> void processSingleOrder(Order<T> order) {
        try {
            InternalValidator.validate(order);
            System.out.printf("[%s] Успішно оброблене замовлення #%s | Сума: $%.2f%n",
                    Thread.currentThread().getName(),
                    order.getOrderId(),
                    order.getTotalPrice());
        } catch (Exception e) {
            System.err.println("Помилка обробки замовлення: " + e.getMessage());
        }
    }
}