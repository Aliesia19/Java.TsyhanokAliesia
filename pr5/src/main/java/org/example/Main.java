package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть рядок для перевірки скінченим автоматом:");
        String input = scanner.nextLine();

        // Викликаємо скінчений автомат для перевірки
        State finalState = FiniteStateMachine.processString(input);

        // Виводимо результат
        System.out.println("Кінцевий стан для рядка \"" + input + "\": " + finalState);
    }
}
