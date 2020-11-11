package fr.arsenelapostolet.bank.services;

import fr.arsenelapostolet.bank.domain.Account;
import fr.arsenelapostolet.bank.domain.Operation;

import javax.ejb.Local;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Local
public interface AccountService {
    int createCurrentAccount(BigDecimal overdraft);

    int createSavingsAccount(BigDecimal interestRate);

    void pay(int accountNumber, BigDecimal amount);

    void withdraw(int accountNumber, BigDecimal amount);

    void transfer(int sourceAccountNumber, int beneficiaryAccountNumber, BigDecimal amount);

    BigDecimal getBalance(int accountNumber);

    Set<Operation> getOperations(int accountNumber);

    BigDecimal getDepositsTotal(int accountNumber);

    BigDecimal getWithdrawalsTotal(int accountNumber);

    List<Account> getAccounts();
    Account getAccount(int accountNumber);
}
