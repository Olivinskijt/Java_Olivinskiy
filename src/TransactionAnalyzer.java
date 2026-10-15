import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class TransactionAnalyzer {
    private final List<Transaction> transactions;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public double calculateTotalBalance() {
        double balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
        }
        return balance;
    }

    public int countTransactionsByMonth(String monthYear) {
        int count = 0;
        for (Transaction transaction : transactions) {
            LocalDate date = LocalDate.parse(transaction.getDate(), dateFormatter);
            String transactionMonthYear = date.format(DateTimeFormatter.ofPattern("MM-yyyy"));
            if (transactionMonthYear.equals(monthYear)) {
                count++;
            }
        }
        return count;
    }

    public List<Transaction> findTopExpenses() {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .sorted(Comparator.comparing(Transaction::getAmount))
                .limit(10)
                .collect(Collectors.toList());
    }

    public Optional<Transaction> findMaxExpenseInPeriod(LocalDate startDate, LocalDate endDate) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .filter(t -> {
                    LocalDate d = LocalDate.parse(t.getDate(), dateFormatter);
                    return !d.isBefore(startDate) && !d.isAfter(endDate);
                })
                .min(Comparator.comparing(Transaction::getAmount));
    }

    public Optional<Transaction> findMinExpenseInPeriod(LocalDate startDate, LocalDate endDate) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .filter(t -> {
                    LocalDate d = LocalDate.parse(t.getDate(), dateFormatter);
                    return !d.isBefore(startDate) && !d.isAfter(endDate);
                })
                .max(Comparator.comparing(Transaction::getAmount));
    }

    public Map<String, Double> calculateExpensesByCategory() {
        Map<String, Double> categoryExpenses = new HashMap<>();
        for (Transaction t : transactions) {
            if (t.getAmount() < 0) {
                categoryExpenses.put(t.getDescription(),
                        categoryExpenses.getOrDefault(t.getDescription(), 0.0) + Math.abs(t.getAmount()));
            }
        }
        return categoryExpenses;
    }

    public Map<String, Double> calculateExpensesByMonth() {
        Map<String, Double> monthExpenses = new HashMap<>();
        for (Transaction t : transactions) {
            if (t.getAmount() < 0) {
                LocalDate date = LocalDate.parse(t.getDate(), dateFormatter);
                String monthYear = date.format(DateTimeFormatter.ofPattern("MM-yyyy"));
                monthExpenses.put(monthYear,
                        monthExpenses.getOrDefault(monthYear, 0.0) + Math.abs(t.getAmount()));
            }
        }
        return monthExpenses;
    }
}