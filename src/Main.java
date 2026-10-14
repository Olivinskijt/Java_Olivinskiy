import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";

        TransactionCSVReader csvReader = new TransactionCSVReader();
        List<Transaction> transactions = csvReader.readTransactions(filePath);

        TransactionAnalyzer analyzer = new TransactionAnalyzer(transactions);
        TransactionReportGenerator reportGenerator = new TransactionReportGenerator();

        double totalBalance = analyzer.calculateTotalBalance();
        reportGenerator.printBalanceReport(totalBalance);

        String monthYear = "01-2024";
        int transactionsCount = analyzer.countTransactionsByMonth(monthYear);
        reportGenerator.printTransactionsCountByMonth(monthYear, transactionsCount);

        List<Transaction> topExpenses = analyzer.findTopExpenses();
        reportGenerator.printTopExpensesReport(topExpenses);

        LocalDate start = LocalDate.of(2023, 12, 1);
        LocalDate end = LocalDate.of(2024, 1, 31);
        System.out.println("\n--- Аналіз за період (01.12.2023 - 31.01.2024) ---");
        analyzer.findMaxExpenseInPeriod(start, end)
                .ifPresent(t -> System.out.println("Найбільша витрата: " + t.getDescription() + " (" + t.getAmount() + ")"));
        analyzer.findMinExpenseInPeriod(start, end)
                .ifPresent(t -> System.out.println("Найменша витрата: " + t.getDescription() + " (" + t.getAmount() + ")"));

        reportGenerator.printVisualCategoryReport(analyzer.calculateExpensesByCategory());
        reportGenerator.printVisualMonthReport(analyzer.calculateExpensesByMonth());
    }
}