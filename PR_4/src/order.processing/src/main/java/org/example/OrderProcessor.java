package org.example;

public class OrderProcessor<T extends Product> { // клас з параметризованим типом T, який обмежений класом Product
    private final T product;  // для незмінності поля

    public OrderProcessor(T product) {
        if (product == null) { // шоб не було замовлення без товара , кидаєм виключення
            throw new IllegalArgumentException("Product cannot be null");
        }
        this.product = product;
    }

    public void process() {
        System.out.println("Processing order for: " + product.getName() + " - " + product.getDescription()); // більше інфи продукта
    }

    public T getProduct() {
        return product; // доступ до продукта що связаний з замовленням
    }
}

