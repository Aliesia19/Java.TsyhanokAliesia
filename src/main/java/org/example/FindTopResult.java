package org.example;
import java.util.List;
import lombok.Getter;

@Getter
public class FindTopResult {
    List<Transaction> ExpensiveTransactions;
    List<Transaction> CheapestTransactions;
}
