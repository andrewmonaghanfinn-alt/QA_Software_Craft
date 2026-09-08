import java.io.IOException;
import java.math.BigDecimal;

public class BankAccount {

    public static void main(String[] args) {

    }

    private static int accountGen = 1000000;
    private String name;
    private int accNumber;
    private BigDecimal balance;

    public BankAccount(String name) {
        this.name = name;
        this.accNumber = ++accountGen;
        this.balance = BigDecimal.ZERO;
    }
    public BankAccount(String name, int accNumber) {
        this.name = name;
        this.accNumber = accNumber;
        this.balance = BigDecimal.ZERO;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) throws IOException {
        if (balance.compareTo(amount) >= 0) {
            balance = balance.subtract(amount);
        } else {
            throw new IOException("Insufficient funds.");
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal amount) {
        balance = amount;

    }


}

class CurrentAccount extends BankAccount {

    private BigDecimal overdraft = new BigDecimal("2500");

    public CurrentAccount(String name) {
        super(name);
    }
    public CurrentAccount(String name, int accNumber) {
        super(name, accNumber);
    }

    @Override 
    public void withdraw(BigDecimal amount) throws IOException {
        if ((super.getBalance().add(overdraft)).compareTo(amount) >= 0) {
            super.setBalance(super.getBalance().subtract(amount));
        } else {
            throw new IOException("Insufficient funds.");
        }
    }

}

class SavingsAccount extends BankAccount {
    private final BigDecimal INTEREST_RATE = new BigDecimal("0.05");

    public SavingsAccount(String name) {
        super(name);
    }
    public SavingsAccount(String name, int accNumber){
        super(name, accNumber);
    }

    public void addInterest() throws IOException {
        if (super.getBalance().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IOException("Cannot add interest to this balance.");
        } else {
            BigDecimal interest = getBalance().multiply(INTEREST_RATE);
            super.setBalance(getBalance().add(interest));
        }
    }
}


