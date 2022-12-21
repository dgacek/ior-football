package ior.project;

import ior.project.model.*;
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

            DatabaseInitialData databaseInitialData = new DatabaseInitialData();
            databaseInitialData.initData((sessionFactory));

            JPQL jpqlQueries = new JPQL(sessionFactory);
            CriteriaAPI criteriaAPIQueries = new CriteriaAPI(sessionFactory);

            // Query 1
            System.out.println(jpqlQueries.getPlayersNames());
            System.out.println(criteriaAPIQueries.getPlayersNames());

            //Query 2
            jpqlQueries.changePlayersPosition();
            criteriaAPIQueries.changePlayersPosition();

            //Query 3
            System.out.println(jpqlQueries.countPositionsGreaterThanOrEqualTwo().size());
            System.out.println(criteriaAPIQueries.countPositionsGreaterThanOrEqualTwo().size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}