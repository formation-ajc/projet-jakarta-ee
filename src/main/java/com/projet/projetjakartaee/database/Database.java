package com.projet.projetjakartaee.database;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Database {

    private static Database instance;
    private final EntityManagerFactory emf;

    private Database() {
        this.emf = Persistence.createEntityManagerFactory("db_config");
    }
    
    public static EntityManagerFactory getInstanceEmf() {
        if (instance == null) {
            instance = new Database();
        }
        return instance.getEmf();
    }

    private EntityManagerFactory getEmf() {
        return this.emf;
    }
}
