package fr.arsenelapostolet.bank.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class SavingsAccount extends Account {

    @Column
    private BigDecimal interestRate;

    public SavingsAccount() {

    }

    public SavingsAccount(BigDecimal interestRate) {
        this.interestRate = interestRate;

        if (this.interestRate.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Le taux d'intéret doit être positif");
        }
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if(this.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) >= 0){
            super.withdraw(amount);
        }
        else {
            throw new IllegalStateException("Solde insuffisant");
        }
    }

    @Override
    public void updateBalance() {
        this.setBalance(this.getBalance().add(this.getBalance().multiply(this.interestRate.divide(new BigDecimal(100)))));
    }

    @Override
    public String getType() {
        return "Savings Account";
    }
}
