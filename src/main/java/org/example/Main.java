package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Створення категорій
        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");

        // Створення об'єктів класу Product
        Product product1 = new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук для роботи та ігор", electronics);
        Product product2 = new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном та високою автономністю", smartphones);
        Product product3 = new Product(3, "Навушники", 2499.00, "Бездротові навушники з шумозаглушенням", accessories);

        // Додаємо всі товари до списку
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        // Створення кошика
        Cart cart = new Cart();

        // Створення об'єкта для пошуку товарів
        ProductSearch productSearch = new ProductSearch(products); // Додаємо пошук товарів

        OrderHistory orderHistory = new OrderHistory(); // Додаємо історію замовлень

        Scanner scanner = new Scanner(System.in);
        // Оголошення товарів і категорій з попереднього коду
        while (true) {
            System.out.println("\nВиберіть опцію:");
            System.out.println("1 - Переглянути список товарів");
            System.out.println("2 - Додати товар до кошика");
            System.out.println("3 - Переглянути кошик");
            System.out.println("4 - Зробити замовлення");
            System.out.println("5 - Видалити товар з кошика");
            System.out.println("6 - Переглянути історію замовлень");// Додаємо пункт для видалення
            System.out.println("7 - Пошук товарів");
            System.out.println("0 - Вийти");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(product1);
                    System.out.println(product2);
                    System.out.println(product3);
                    break;
                case 2:
                    System.out.println("Введіть ID товару для додавання до кошика:");
                    int id = scanner.nextInt();
                    // Проста логіка додавання, для прикладу використаємо ID для вибору
                    if (id == 1) cart.addProduct(product1);
                    else if (id == 2) cart.addProduct(product2);
                    else if (id == 3) cart.addProduct(product3);
                    else System.out.println("Товар з таким ID не знайдено");
                    break;
                case 3:
                    System.out.println(cart);
                    break;
                case 4:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Кошик порожній. Додайте товари перед оформленням замовлення.");
                    } else {
                        Order order = new Order(cart);
                        System.out.println("Замовлення оформлено:");
                        System.out.println(order);
                        orderHistory.addOrder(order); // Додаємо в історію
                        cart.clear(); // Очищення кошика після оформлення
                    }
                    break;
                case 5:
                    System.out.println("Введіть ID товару для видалення з кошика:");
                    int removeId = scanner.nextInt();
                    if (removeId == 1) cart.removeProduct(product1);  // видалення товару за ID
                    else if (removeId == 2) cart.removeProduct(product2);
                    else if (removeId == 3) cart.removeProduct(product3);
                    else System.out.println("Товар з таким ID не знайдено");
                    break;
                case 6:
                    orderHistory.showHistory(); // Show історію замовлень
                    break;
                case 7:
                    System.out.println("Виберіть опцію пошуку:");
                    System.out.println("1 - Шукати за назвою");
                    System.out.println("2 - Шукати за категорією");

                    int searchOption = scanner.nextInt();
                    scanner.nextLine(); // Чистим буфер після введення

                    switch (searchOption) {
                        case 1:
                            System.out.println("Введіть назву товару:");
                            String productName = scanner.nextLine();
                            List<Product> nameSearchResults = productSearch.searchByName(productName);
                            productSearch.printSearchResults(nameSearchResults);
                            break;
                        case 2:
                            System.out.println("Введіть назву категорії:");
                            String categoryName = scanner.nextLine();
                            List<Product> categorySearchResults = productSearch.searchByCategory(categoryName);
                            productSearch.printSearchResults(categorySearchResults);
                            break;
                        default:
                            System.out.println("Невірна опція пошуку.");
                            break;
                    }
                    break;
                case 0:
                    System.out.println("Дякуємо, що використовували наш магазин!");
                    return;
                default:
                    System.out.println("Невідома опція. Спробуйте ще раз.");
                    break;
            }
        }
    }
}
