package com.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    private static EntityManagerFactory factory;

    static{
        factory = Persistence.createEntityManagerFactory("IFBA-PU");
    }

    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }

    public static void close(){
        factory.close();
    }
    
}
