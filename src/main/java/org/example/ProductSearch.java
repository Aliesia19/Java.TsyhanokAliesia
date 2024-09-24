package org.example;
import java.util.ArrayList;
import java.util.List;

public class ProductSearch {
    private List<Product> products; // Усі доступні товари

    // Конструктор приймає список товарів
    public ProductSearch(List<Product> products) {
        this.products = products;
    }

    // Метод пошук товарів за назвою
    public List<Product> searchByName(String name) {
        List<Product> results = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                results.add(product);
            }
        }
        return results;
    }

    // Метод пошуку товарів за категорією
    public List<Product> searchByCategory(String categoryName) {
        List<Product> results = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().getName().toLowerCase().contains(categoryName.toLowerCase())) {
                results.add(product);
            }
        }
        return results;
    }

    // Метод виведення результатів пошуку
    public void printSearchResults(List<Product> searchResults) {
        if (searchResults.isEmpty()) {
            System.out.println("Товари не знайдено.");
        } else {
            System.out.println("Знайдені товари:");
            for (Product product : searchResults) {
                System.out.println(product);
            }
        }
    }
}
