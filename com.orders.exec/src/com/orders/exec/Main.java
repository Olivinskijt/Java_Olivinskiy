package com.orders.exec;

import com.orders.model.Clothing;
import com.orders.model.Electronics;
import com.orders.model.Order;
import com.orders.model.OrderDataGenerator;
import com.orders.processing.OrderProcessor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Запуск системи заказів ===");

        List<Order<Electronics>> electronics = new ArrayList<>();
        List<Order<Clothing>> clothing = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            electronics.add(OrderDataGenerator.generateElectronicsOrder());
            clothing.add(OrderDataGenerator.generateClothingOrder());
        }

        OrderExecutionManager manager = new OrderExecutionManager();

        List<Order<Electronics>> filtered = manager.filterOrders(electronics, o -> o.getTotalPrice() > 100);

        filtered.forEach(OrderProcessor::processSingleOrder);

        manager.executeOrdersAsync(electronics);
        manager.executeOrdersAsync(clothing);

        manager.shutdown();
    }
}