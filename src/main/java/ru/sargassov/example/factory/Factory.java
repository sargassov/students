package ru.sargassov.example.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Factory {
    private static SessionFactory factory;
    private static final String configuration = "hibernate.cfg.xml";

    public Factory(){
        factory = new Configuration()
                .configure(configuration)
                .buildSessionFactory();
    }

    public Session getSession(){
        return factory.getCurrentSession();
    }

    public static SessionFactory getFactory() {
        return factory;
    }

    public void shutdown(){
        if(factory != null)
            factory.close();
    }
}
