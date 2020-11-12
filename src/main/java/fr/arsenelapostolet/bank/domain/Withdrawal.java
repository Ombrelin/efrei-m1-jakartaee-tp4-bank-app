package fr.arsenelapostolet.bank.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Withdrawal extends Operation {
    public Withdrawal(BigDecimal montant) {
        super(montant);
    }

    public Withdrawal() {

    }

    @Override
    public String getType() {
        return "Withdrawal";
    }
}
