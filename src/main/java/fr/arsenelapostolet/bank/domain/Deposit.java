package fr.arsenelapostolet.bank.domain;

import javax.persistence.DiscriminatorValue;
import java.math.BigDecimal;

@DiscriminatorValue(value="DEPOSIT")
public class Deposit extends Operation {
    public Deposit(BigDecimal montant) {
        super(montant);
    }
}
