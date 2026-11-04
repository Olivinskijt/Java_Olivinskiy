package com.orders.exec;

import com.orders.model.Item;
import com.orders.model.Order;
import com.orders.processing.OrderProcessor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class OrderExecutionManager {
    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    public <T extends Item> List<Order<T>> filterOrders(List<Order<T>> orders, Predicate<Order<T>> predicate) {
        return orders.stream().filter(predicate).toList();
    }

    public <T extends Item> void executeOrdersAsync(List<Order<T>> orders) {
        for (Order<T> order : orders) {
            executor.submit(() -> OrderProcessor.processSingleOrder(order));
        }
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(3, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}