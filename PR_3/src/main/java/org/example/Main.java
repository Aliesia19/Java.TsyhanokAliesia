package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        try {
            System.out.print("Введіть перше число: ");
            double num1 = Double.parseDouble(scanner.nextLine());

            System.out.print("Введіть друге число: ");
            double num2 = Double.parseDouble(scanner.nextLine());

            System.out.print("Введіть операцію (+, -, *, /, sqrt): ");
            String operation = scanner.nextLine();

            double result = 0;

            switch (operation) {
                case "+":
                    result = calculator.add(num1, num2);
                    break;
                case "-":
                    result = calculator.subtract(num1, num2);
                    break;
                case "*":
                    result = calculator.multiply(num1, num2);
                    break;
                case "/":
                    result = calculator.divide(num1, num2);
                    break;
                case "sqrt":
                    result = calculator.sqrt(num1);
                    break;
                default:
                    System.out.println("Невідома операція.");
                    return;
            }

            System.out.println("Результат: " + result);

        } catch (ArithmeticException | InvalidInputException e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Помилка: Будь ласка, введіть числове значення.");
        } catch (Exception e) {
            System.out.println("Невідома помилка: " + e.getMessage());
        } finally {
            System.out.println("Завершення обробки запиту.");
        }
        scanner.close();
    }
}