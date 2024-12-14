package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OrderThreadManager {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(4); //інтерфейс Пул з 4 потоків

    // Метод для запуску обробки замовлення в окремому потоці
    public static void startProcessing(Runnable task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null"); // якщо нул - виключення
        }
        executorService.submit(task); // Податча на виконання в пул потоку
    }

    // Завершення роботи пулу потоків
    public static void shutdown() {
        executorService.shutdown(); // завершення роботи пулу потоків !)
    }
}
