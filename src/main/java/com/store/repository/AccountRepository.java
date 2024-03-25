package com.store.repository;

import com.store.model.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    private EntityManager entityManager = null;

    public AccountRepository() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        entityManager = factory.createEntityManager();
    }

    public boolean createAccount(Account account) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(account);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    public Account readAccount(Long id) {
        try {
            return entityManager.find(Account.class, id);

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public boolean updateAccount(Account account) {

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(account);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    public boolean deleteUser(Long id) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(Account.class,id));
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    public List<Account> readAllAccount() {
        List<Account> accounts = new ArrayList<>();
        Query query = entityManager.createQuery("FROM accounts ", Account.class);
        return query.getResultList();
    }
}
