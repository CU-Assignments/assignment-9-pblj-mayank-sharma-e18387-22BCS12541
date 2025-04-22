package hard;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int fromAccount;
    private int toAccount;
    private double amount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    public Transaction() {}

    public Transaction(int fromAccount, int toAccount, double amount, Date timestamp) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    // Getters and Setters...
}
