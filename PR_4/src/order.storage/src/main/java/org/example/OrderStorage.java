package org.example;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.List;

class OrderStorage {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(4); // 4 потоки

    // Метод для запуску обробки замовлення в окремому потоці
    public static void startProcessing(Runnable task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null"); // Перевірка на null
        }
        executorService.submit(() -> { //передача в поток
            try {
                task.run(); // робмим
            } catch (Exception e) {
                System.err.println("Error while processing task: " + e.getMessage()); // є помилка - поймали , виправляєм
            }
        });
    }
    // Завершення роботи всіх потоків після обробки з додатковим контролем
    public static void shutdown() {
        executorService.shutdown();// сигнал що завданна не передаються
        try {
            // завершення всіх потоків в пулі
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow(); // Якщо потоки не завершились за 60 секунд, примусове завершення
            }
        } catch (InterruptedException e) { // якщо поток робив shutdownNow і перервався
            executorService.shutdownNow(); //  примусове завершення
            Thread.currentThread().interrupt();
        }
    }

    public void saveOrder(OrderProcessor order) {
        System.out.println("Saving order: " + order);

    }

    public void startParallelProcessing(List<OrderProcessor> orders) {
        orders.forEach(order->OrderThreadManager.startProcessing(()->{
            System.out.println("Processing order: " + order.getProduct().getName()+"in thred" + Thread.currentThread().getName());
        }));
    }
}
