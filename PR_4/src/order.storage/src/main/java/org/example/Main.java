package org.example;
import com.github.javafaker.Faker;
import org.example.Clothing;
import org.example.Electronics;
import org.example.OrderProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var faker = new Faker();// генерейшн даних товар ціна там всяке

        OrderProcessor<Electronics> electronicsOrder = new OrderProcessor<>(new Electronics("Mobile phone", 45000, "New features"));
        OrderProcessor<Clothing> clothingOrder = new OrderProcessor<>(new Clothing("Trousers", 40, "Size M"));

        OrderStorage orderStorage = new OrderStorage();// екземплярчик для збережень
        orderStorage.saveOrder(electronicsOrder);
        orderStorage.saveOrder(clothingOrder);

        var clothingList = IntStream.range(0, 10).mapToObj(i -> new OrderProcessor<>( // на число замовлення
                Clothing.builder() // новий об'єкт
                        .name(faker.commerce().productName())
                        .price(Double.parseDouble(faker.commerce().price(10, 100000).replace(",", ".")))
                        .description(faker.lebowski().quote())
                        .build())).toList(); // шо вийшло то у список
        List<OrderProcessor> orderProcessors= new ArrayList<>();
        orderProcessors.add(electronicsOrder);
        orderProcessors.add(clothingOrder);
        clothingList.forEach(orderStorage::saveOrder); // метод включається і зберігає
        orderStorage.startParallelProcessing(orderProcessors); // обробка
    }
}

