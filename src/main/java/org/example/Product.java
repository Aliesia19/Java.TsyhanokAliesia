package org.example;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Product {
    private int id; // Унікальний ідентифікатор товару
    private String name; // Назва товару
    private double price; // Ціна товару
    private String description; // Опис товару
    private Category category; // Додано поле для зберігання категорії

    // Метод для виведення інформації про товар
    @Override
    public String toString() {
        return "Товар{" +
                "id=" + id +
                ", назва='" + name + '\'' +
                ", ціна=" + price +
                ", опис='" + description + '\'' +
                ", категорія='" + category.getName() + '\'' +
                '}';
    }
}