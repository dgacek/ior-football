package ior.project;

import ior.project.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        try {
            Configuration cfg = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Coach.class)
                    .addAnnotatedClass(Match.class)
                    .addAnnotatedClass(Person.class)
                    .addAnnotatedClass(Player.class)
                    .addAnnotatedClass(Position.class)
                    .addAnnotatedClass(Stadium.class)
                    .addAnnotatedClass(Team.class);
            StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
            sb.applySettings(cfg.getProperties());
            StandardServiceRegistry standardServiceRegistry = sb.build();
            SessionFactory sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
            Session session = sessionFactory.getCurrentSession();

            //TUTAJ WSTAW BAJER MARCIN

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}