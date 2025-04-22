package hard;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.Date;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public void transfer(int fromAcc, int toAcc, double amount) {
        Session session = entityManagerFactory.unwrap(Session.class).getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Account from = session.get(Account.class, fromAcc);
            Account to = session.get(Account.class, toAcc);

            if (from.getBalance() < amount) {
                throw new RuntimeException("Insufficient balance in source account!");
            }

            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);

            session.update(from);
            session.update(to);

            session.save(new Transaction(fromAcc, toAcc, amount, new Date()));

            tx.commit();
            System.out.println("Transfer successful!");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println("Transaction failed: " + e.getMessage());
        } finally {
            session.close();
        }
    }
}
