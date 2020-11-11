package fr.arsenelapostolet.bank.repositories;

import fr.arsenelapostolet.bank.domain.Account;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class InMemoryAccountRepository implements AccountRepository {

    @PersistenceContext
    private EntityManager em;

    public InMemoryAccountRepository() {
    }

    @Override
    public void insert(Account account) {
        em.persist(account);
    }

    @Override
    public Account get(int accountNumber) {
        return em.find(Account.class, accountNumber);
    }

    @Override
    public List<Account> getAll() {
        Query query = em.createQuery("SELECT a FROM Account a");
        return query.getResultList();
    }

    @Override
    public void save(Account account) {
        em.getTransaction().commit();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
