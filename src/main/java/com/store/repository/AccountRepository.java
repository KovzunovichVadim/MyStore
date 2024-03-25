package com.store.repository;

import com.store.model.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    private Session session = null;

    public AccountRepository() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
    }

    public boolean createAccount(Account account) {
        try {
            session.getTransaction().begin();
            session.persist(account);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            session.getTransaction().rollback();
            return false;
        }
    }

    public Account readAccount(Long id) {
        try {
            return session.get(Account.class, id);

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public boolean updateAccount(Account account) {

        try {
            session.getTransaction().begin();
            session.merge(account);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean deleteUser(Long id) {
        try {
            session.getTransaction().begin();
            session.remove(session.get(Account.class, id));
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            session.getTransaction().rollback();
            return false;
        }
    }

    public List<Account> readAllAccount() {
        Query<Account> query = session.createQuery("FROM accounts", Account.class);
        return query.getResultList();
    }
}
