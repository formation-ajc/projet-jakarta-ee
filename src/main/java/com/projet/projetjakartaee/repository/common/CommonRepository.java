package com.projet.projetjakartaee.repository.common;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.sql.SQLException;
import java.util.List;
import java.util.function.Function;

public class CommonRepository<T, ID> {

    protected final EntityManagerFactory emf;
    private final Class<T> tClass;

    public CommonRepository(EntityManagerFactory emf, Class<T> tClass) {
        this.emf = emf;
        this.tClass = tClass;
    }

    public T getById(ID id) throws SQLException {
        return query(entityManager -> entityManager.find(this.tClass, id));
    }

    public List<T> getAll() throws SQLException {
        return query(entityManager -> {
            TypedQuery<T> typedQuery =  entityManager.createQuery("SELECT entity FROM "+ this.tClass.getName() +" entity", this.tClass);
            return typedQuery.getResultList();
        });
    }

    public T create(T entity) throws SQLException {
        return query((entityManager) -> {
            entityManager.persist(entity);
            return entityManager.merge(entity);
        });
    }

    public T update(T entity) throws SQLException {
        return query((entityManager) -> entityManager.merge(entity));
    }

    public boolean delete(ID id) throws SQLException {
        return query((entityManager) -> {
            entityManager.remove(entityManager.find(this.tClass, id));
            return true;
        });
    }

    protected <R> R query(Function<EntityManager, R> function) throws SQLException {
        R entity = null;
        try(EntityManager em = this.emf.createEntityManager()) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            entity = function.apply(em);

            transaction.commit();
        }
        catch (Exception e) {
            System.out.println("!!! error !!!");
            throw new SQLException();
        }
        return entity;
    }
}
