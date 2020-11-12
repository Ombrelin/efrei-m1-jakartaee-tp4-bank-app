package fr.arsenelapostolet.bank.domain;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "accountNumber", updatable = false, nullable = false)
    private int accountNumber;

    @Column
    private BigDecimal balance;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Operation> operations;

    public Account() {
        this.balance = BigDecimal.ZERO;
    }

    public void deposit(BigDecimal amount) {
        this.operations.add(new Deposit(amount));
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        this.getOperations().add(new Withdrawal(amount));
        this.balance = this.balance.subtract(amount);
    }

    public void transfer(BigDecimal amount, Account beneficiary) {
        this.withdraw(amount);
        beneficiary.deposit(amount);
    }

    public abstract void updateBalance();


    public Set<Operation> getOperations() {
        return this.operations;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    public BigDecimal getDepositsTotal() {
        return this.operations
                .stream()
                .filter(operation -> operation instanceof Deposit)
                .map(Operation::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    public BigDecimal getWithdrawalsTotal() {
        return this.operations
                .stream()
                .filter(operation -> operation instanceof Withdrawal)
                .map(Operation::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public abstract String getType();

    public int getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
