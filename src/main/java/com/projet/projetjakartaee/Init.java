package com.projet.projetjakartaee;

import com.projet.projetjakartaee.database.Database;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Init implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        Database.getInstanceEmf();
        System.out.println("Init OK !");
    }

    public void contextDestroyed(ServletContextEvent event) {}
}