package fr.arsenelapostolet.bank.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "DISC", discriminatorType = DiscriminatorType.STRING)
public abstract class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numero", updatable = false, nullable = false)
    private int numero;
    private BigDecimal amount;
    private LocalDate date;

    public Operation() {
    }

    public Operation(BigDecimal montant) {
        this.amount = montant;
        this.date = LocalDate.now();
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getNumero() {
        return numero;
    }

    public LocalDate getDate() {
        return date;
    }
}
