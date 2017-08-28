package com.chhaichivon.backend.utils;

import com.chhaichivon.backend.models.Product;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/28/2017
 * TIME   : 2:44 PM
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    // configuration.properties
    private static SessionFactory buildSessionFactory(){
        try{
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Product.class);

            //configuration.addPackage("com.chhaichivon.backend.models");
            return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
        }catch(Exception ex){
            ex.printStackTrace();
            throw new RuntimeException("There was an error building the factory.");
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}