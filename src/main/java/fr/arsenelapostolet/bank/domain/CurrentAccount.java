package fr.arsenelapostolet.bank.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value="CURRENT")
public class CurrentAccount extends Account {
    @Column
    private BigDecimal overdraft;

    public CurrentAccount(BigDecimal overdraft) {
        this.overdraft = overdraft;
    }

    public CurrentAccount() {}

    @Override
    public void withdraw(BigDecimal amount) {
        if(this.getBalance().subtract(amount).compareTo(this.overdraft.negate()) >= 0){
            super.withdraw(amount);
        }
        else {
            throw new IllegalStateException("Solde insuffisant");
        }
    }

    @Override
    public void updateBalance() {
        throw new UnsupportedOperationException("Les comptes courants n'ont pas d'intérêts");
    }

    public BigDecimal getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(BigDecimal overdraft) {
        this.overdraft = overdraft;
    }
}
