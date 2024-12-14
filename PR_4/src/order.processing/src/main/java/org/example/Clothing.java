package org.example;

import lombok.Builder;


public class Clothing extends Product {//розширення продукта ураа
    @Builder // ств об'єкти використовуючи "ланцюгові" виклики методів
    public Clothing(String name, double price, String description  ) { //прийом
        super(name,price,description); // передача
    }
}

