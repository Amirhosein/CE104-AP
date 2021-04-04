import java.util.Date;

public final class Transaction {
    private final int amount;
    private final Date date = new Date();

    public Transaction(int amount) {
        this.amount = amount;
    }

    public void print() {
        System.out.println("Amount = " + amount + " //// Date: " + date.toString());
    }


}
