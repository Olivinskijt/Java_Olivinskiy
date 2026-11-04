package com.orders.model;

import com.github.javafaker.Faker;
import java.util.UUID;

public class OrderDataGenerator {
    private static final Faker faker = new Faker();

    public static Order<Electronics> generateElectronicsOrder() {
        Electronics item = Electronics.builder()
                .id(UUID.randomUUID().toString())
                .name(faker.commerce().productName())
                .price(faker.number().randomDouble(2, 50, 2000))
                .warrantyMonths(12)
                .brand(faker.company().name())
                .build();

        return new Order<>(UUID.randomUUID().toString(), item, 2);
    }

    public static Order<Clothing> generateClothingOrder() {
        Clothing item = Clothing.builder()
                .id(UUID.randomUUID().toString())
                .name(faker.commerce().productName())
                .price(faker.number().randomDouble(2, 10, 300))
                .size("L")
                .material(faker.commerce().material())
                .build();

        return new Order<>(UUID.randomUUID().toString(), item, 1);
    }
}