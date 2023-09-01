package com.projet.projetjakartaee.repository;


import jakarta.persistence.EntityManagerFactory;

import java.sql.SQLException;

//public class ExempleRepository extends CommonRepository<Game, Integer> {
//
//    public ExempleRepository(EntityManagerFactory emf) {
//        super(emf, Game.class);
//    }
//
//    public List<Game> getAllByUser(User user) throws SQLException {
//        return query(entityManager -> {
//            TypedQuery<Game> typedQuery =  entityManager.createQuery("SELECT game FROM UserGame usergame WHERE usergame.user = :user", Game.class);
//            typedQuery.setParameter("user", user);
//            return typedQuery.getResultList();
//        });
//    }
//
//}
