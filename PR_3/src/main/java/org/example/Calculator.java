package org.example;

public class Calculator {

    // Метод для додавання
    public double add(double a, double b) {
        return a + b;
    }

    // Метод для віднімання
    public double subtract(double a, double b) {
        return a - b;
    }

    // Метод для множення
    public double multiply(double a, double b) {
        return a * b;
    }

    // Метод для ділення з обробкою виключення при діленні на нуль
    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Помилка: Ділення на нуль неможливе.");
        }
        return a / b;
    }

    // Метод для квадратного кореня з обробкою некоректних вхідних даних
    public double sqrt(double a) throws InvalidInputException {
        if (a < 0) {
            throw new InvalidInputException("Помилка: Негативне число не може мати квадратний корінь.");
        }
        return Math.sqrt(a);
    }
}