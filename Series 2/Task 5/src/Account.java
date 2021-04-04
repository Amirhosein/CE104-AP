import java.util.ArrayList;
import java.util.UUID;

public class Account {
    private final UUID serial = UUID.randomUUID();
    private String id;
    private String firstName;
    private String lastName;
    private String type;
    private long balance;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account(String id, String firstName, String lastName, String type, long balance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.balance = balance;
    }

    public void updateBalance(int amount) {
        balance += amount;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void printTransactions() {
        for (Transaction transaction : this.transactions) {
            System.out.println("\n-----------------");
            transaction.print();
            System.out.println("\n-----------------");
        }
    }

    public void printAccountData() {
        System.out.println("-----------------");
        System.out.println("UUID: " + serial);
        System.out.println("First name: " + firstName);
        System.out.println("Last name: " + lastName);
        System.out.println("ID: " + id);
        System.out.println("Type: " + type);
        System.out.println("Balance: " + balance);
        System.out.println("-----------------");
    }
}
