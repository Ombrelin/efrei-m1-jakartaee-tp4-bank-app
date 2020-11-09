package fr.arsenelapostolet.bank.domain;

import javax.persistence.DiscriminatorValue;
import java.math.BigDecimal;

@DiscriminatorValue(value="WITHDRAWAL")
public class Withdrawal extends Operation {
    public Withdrawal(BigDecimal montant) {
        super(montant);
    }
}
