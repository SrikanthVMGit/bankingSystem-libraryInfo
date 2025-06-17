package bank;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class BankService {

    private final MongoCollection<Document> accountCollection;

    // Constructor: connects to MongoDB and gets the "accounts" collection
    public BankService() {
        MongoDatabase database = MongoDBConnection.getDatabase();
        accountCollection = database.getCollection("accounts");
    }

    // Create a new account in the database
    public void createAccount(Account account) {
        Document doc = new Document("accountNumber", account.getAccountNumber())
                .append("name", account.getName())
                .append("balance", account.getBalance());

        accountCollection.insertOne(doc);
        System.out.println("Account created successfully.");
    }

    // Deposit money to an account
    public void deposit(String accountNumber, double amount) {
        Document doc = accountCollection.find(eq("accountNumber", accountNumber)).first();

        if (doc != null) {
            double currentBalance = doc.getDouble("balance");
            double newBalance = currentBalance + amount;

            accountCollection.updateOne(
                    eq("accountNumber", accountNumber),
                    new Document("$set", new Document("balance", newBalance))
            );

            System.out.println("Deposit successful. New balance: " + newBalance);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Withdraw money from an account
    public void withdraw(String accountNumber, double amount) {
        Document doc = accountCollection.find(eq("accountNumber", accountNumber)).first();

        if (doc != null) {
            double currentBalance = doc.getDouble("balance");

            if (amount <= currentBalance) {
                double newBalance = currentBalance - amount;

                accountCollection.updateOne(
                        eq("accountNumber", accountNumber),
                        new Document("$set", new Document("balance", newBalance))
                );

                System.out.println("Withdrawal successful. New balance: " + newBalance);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    // Check the balance of an account
    public void checkBalance(String accountNumber) {
        Document doc = accountCollection.find(eq("accountNumber", accountNumber)).first();

        if (doc != null) {
            double balance = doc.getDouble("balance");
            System.out.println("Account balance: " + balance);
        } else {
            System.out.println("Account not found.");
        }
    }
}
