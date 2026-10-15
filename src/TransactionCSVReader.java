import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TransactionCSVReader {
    public List<Transaction> readTransactions(String filePath) {
        List<Transaction> transactions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {

            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("Дата") || line.startsWith("Date")) {
                    continue;
                }
                String[] values = line.split(",");
                if (values.length >= 3) {
                    Transaction transaction = new Transaction(
                            values[0].trim(),
                            Double.parseDouble(values[1].trim()),
                            values[2].trim()
                    );
                    transactions.add(transaction);
                }
            }
        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
        }
        return transactions;
    }
}