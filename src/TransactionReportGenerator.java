import java.util.List;
import java.util.Map;

public class TransactionReportGenerator {

    public void printBalanceReport(double totalBalance) {
        System.out.println("Загальний баланс: " + totalBalance);
    }

    public void printTransactionsCountByMonth(String monthYear, int count) {
        System.out.println("Кількість транзакцій за " + monthYear + ": " + count);
    }

    public void printTopExpensesReport(List<Transaction> topExpenses) {
        System.out.println("\n--- 10 найбільших витрат ---");
        for (Transaction expense : topExpenses) {
            System.out.println(expense.getDescription() + ": " + expense.getAmount());
        }
    }

    public void printVisualCategoryReport(Map<String, Double> categoryExpenses) {
        System.out.println("\n--- Звіт по категоріях витрат (кожна '*' = 1000 грн) ---");
        for (Map.Entry<String, Double> entry : categoryExpenses.entrySet()) {
            int stars = (int) (entry.getValue() / 1000);
            String visual = "*".repeat(Math.max(0, stars));
            System.out.printf("%-20s: %8.2f грн | %s%n", entry.getKey(), entry.getValue(), visual);
        }
    }

    public void printVisualMonthReport(Map<String, Double> monthExpenses) {
        System.out.println("\n--- Звіт по місяцях витрат (кожна '*' = 1000 грн) ---");
        for (Map.Entry<String, Double> entry : monthExpenses.entrySet()) {
            int stars = (int) (entry.getValue() / 1000);
            String visual = "*".repeat(Math.max(0, stars));
            System.out.printf("%-10s: %8.2f грн | %s%n", entry.getKey(), entry.getValue(), visual);
        }
    }
}