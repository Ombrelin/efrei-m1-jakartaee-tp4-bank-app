package fr.arsenelapostolet.bank.repositories;

import fr.arsenelapostolet.bank.domain.Account;

import javax.ejb.Local;
import java.util.List;

@Local
public interface AccountRepository {
    void insert(Account c);
    Account get(int numero);
    List<Account> getAll();
}
