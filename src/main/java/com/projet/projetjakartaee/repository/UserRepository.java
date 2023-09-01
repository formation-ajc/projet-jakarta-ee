package com.projet.projetjakartaee.repository;

import com.projet.projetjakartaee.entity.User;
import com.projet.projetjakartaee.repository.common.CommonRepository;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.sql.SQLException;

public class UserRepository extends CommonRepository<User, Integer> {

    public UserRepository(EntityManagerFactory emf) {
        super(emf, User.class);
    }

    public User getByEmailAndPassword(String email, String password) throws SQLException {
        return query(entityManager -> {
            TypedQuery<User> typedQuery =  entityManager.createQuery("SELECT user FROM User user WHERE user.email = :email AND user.password = :password", User.class);
            typedQuery.setParameter("email", email);
            typedQuery.setParameter("password", password);
            return typedQuery.getSingleResult();
        });
    }

}
