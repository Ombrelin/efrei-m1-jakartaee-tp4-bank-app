package fr.arsenelapostolet.bank.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Deposit extends Operation {
    public Deposit(BigDecimal montant) {
        super(montant);
    }

    @Override
    public String getType() {
        return "Deposit";
    }

    public Deposit() {
    }
}
