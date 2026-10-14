import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class TransactionAnalyzerTest {

    @Test
    public void testCalculateTotalBalance() {
        Transaction transaction1 = new Transaction("01-01-2023", 100.0, "Дохід");
        Transaction transaction2 = new Transaction("02-01-2023", -50.0, "Витрата");
        Transaction transaction3 = new Transaction("03-01-2023", 150.0, "Дохід");

        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3);
        TransactionAnalyzer analyzer = new TransactionAnalyzer(transactions);

        double result = analyzer.calculateTotalBalance();
        Assertions.assertEquals(200.0, result, "Розрахунок загального балансу неправильний");
    }

    @Test
    public void testCountTransactionsByMonth() {
        Transaction transaction1 = new Transaction("01-02-2023", 50.0, "Дохід");
        Transaction transaction2 = new Transaction("15-02-2023", -20.0, "Витрата");
        Transaction transaction3 = new Transaction("05-03-2023", 100.0, "Дохід");

        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3);
        TransactionAnalyzer analyzer = new TransactionAnalyzer(transactions);

        int countFeb = analyzer.countTransactionsByMonth("02-2023");
        int countMar = analyzer.countTransactionsByMonth("03-2023");

        Assertions.assertEquals(2, countFeb, "Кількість транзакцій за лютий неправильна");
        Assertions.assertEquals(1, countMar, "Кількість транзакцій за березень неправильна");
    }

    @Test
    public void testFindTopExpenses() {
        Transaction t1 = new Transaction("01-01-2024", -100.0, "Продукти");
        Transaction t2 = new Transaction("02-01-2024", -500.0, "Оренда");
        Transaction t3 = new Transaction("03-01-2024", -200.0, "Бензин");
        Transaction t4 = new Transaction("04-01-2024", 1000.0, "Зарплата");

        List<Transaction> transactions = Arrays.asList(t1, t2, t3, t4);
        TransactionAnalyzer analyzer = new TransactionAnalyzer(transactions);

        List<Transaction> topExpenses = analyzer.findTopExpenses();
        Assertions.assertEquals(3, topExpenses.size());
        Assertions.assertEquals(-500.0, topExpenses.get(0).getAmount(), "Перша витрата має бути найбільшою (-500)");
    }
}