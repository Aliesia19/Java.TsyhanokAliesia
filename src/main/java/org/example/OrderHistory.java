package org.example;
import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    private List<Order> orderHistory; // Список  зберігання історії замовлень

    // Конструктор класу
    public OrderHistory() {
        this.orderHistory = new ArrayList<>();
    }

    // Метод додавання замовлення до історії
    public void addOrder(Order order) {
        orderHistory.add(order);
    }

    // Метод виведення всієї історії замовлень
    public void showHistory() {
        if (orderHistory.isEmpty()) {
            System.out.println("Історія замовлень порожня.");
        } else {
            System.out.println("Історія замовлень:");
            for (Order order : orderHistory) {
                System.out.println(order);
                System.out.println(); // Відокремлюємо замовлення для зручності
            }
        }
    }
}
