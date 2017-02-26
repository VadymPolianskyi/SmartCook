package com.polyanski.coursework.db.api.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Author: vadym
 * Date: 26.02.17
 * Time: 17:59
 */

public class HibernateUtil {

    private static SessionFactory SESSIONFACTORY = null;
    private static ServiceRegistry SERVICEREGISTRY = null;

    static{

        try{
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            SERVICEREGISTRY = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            SESSIONFACTORY = configuration.buildSessionFactory(SERVICEREGISTRY);


        }catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public  static SessionFactory getSessionFactory(){
        return SESSIONFACTORY;
    }

}