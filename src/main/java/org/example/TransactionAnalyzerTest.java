package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionAnalyzerTest{
    @Test
    public void testCalculateTotalBalance() {
        // Створення тестових даних
        Transaction transaction1 = new Transaction("2023-01-01", 100.0, "Дохід");
        Transaction transaction2 = new Transaction("2023-01-02", -50.0, "Витрата");
        Transaction transaction3 = new Transaction("2023-01-03", 150.0, "Дохід");
        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3);

        // Виклик методу, який потрібно протестувати
        double result = TransactionAnalyzer.calculateTotalBalance(transactions);

        // Перевірка результату
        assertEquals(200.0, result, "Розрахунок загального балансу неправильний");
    }
    @Test
    public void testCountTransactionsByMonth() {
        // Підготовка тестових даних
        Transaction transaction1 = new Transaction("01-02-2023", 50.0, "Дохід");
        Transaction transaction2 = new Transaction("15-02-2023", -20.0, "Витрата");
        Transaction transaction3 = new Transaction("05-03-2023", 100.0, "Дохід");
        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3);

        // Створення екземпляру TransactionAnalyzer з тестовими даними

        int countFeb = TransactionAnalyzer.countTransactionsByMonth( "02-2023",transactions,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        int countMar = TransactionAnalyzer.countTransactionsByMonth("03-2023",transactions,DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        // Перевірка результатів
        assertEquals(2, countFeb, "Кількість транзакцій за лютий неправильна");
        assertEquals(1, countMar, "Кількість транзакцій за березень неправильна");
    }

    @Test
    public void shouldReadFileSuccessfully() {
        String fileUrl = "https://informer.com.ua/dut/java/pr2.csv";
        var transactions = TransactionCSVReader.readTransactions(fileUrl);

        Assertions.assertNotNull(transactions);
        Assertions.assertFalse(transactions.isEmpty());
    }

    @Test
    public void shouldFindTopTransactionsByMonth() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("02-01-2023", -10000, ""));
        for (int i = 1; i < 21; i++) {
            transactions.add(new Transaction("19-03-2023", -i, ""));
            transactions.add(new Transaction("19-03-2023", i, ""));
        }
        transactions.add(new Transaction("12-05-2023", -10000, ""));

        var result = TransactionAnalyzer.findTopTransactionsByMonth(
                "03-2023", transactions, DateTimeFormatter.ofPattern("dd-MM-yyyy")
        );

        Assertions.assertNotNull(result);
        Assertions.assertNotNull(result.getCheapestTransactions());
        Assertions.assertNotNull(result.getExpensiveTransactions());

        assertEquals(10, result.getCheapestTransactions().size());
        assertEquals(10, result.getExpensiveTransactions().size());

        assertEquals(-20, result.getExpensiveTransactions().get(0).getAmount());
        assertEquals("19-03-2023", result.getExpensiveTransactions().get(0).getDate());

        assertEquals(-1, result.getCheapestTransactions().get(0).getAmount());
        assertEquals("19-03-2023", result.getCheapestTransactions().get(0).getDate());

        Assertions.assertFalse(result.getExpensiveTransactions().stream()
                .anyMatch(x -> !x.getDate().equals("19-03-2023")));
        Assertions.assertFalse(result.getCheapestTransactions().stream()
                .anyMatch(x -> !x.getDate().equals("19-03-2023")));

        Assertions.assertFalse(result.getExpensiveTransactions().stream()
                .anyMatch(x -> x.getAmount() > 0));
        Assertions.assertFalse(result.getCheapestTransactions().stream()
                .anyMatch(x -> x.getAmount() > 0));
    }
}