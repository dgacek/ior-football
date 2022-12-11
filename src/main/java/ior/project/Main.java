package ior.project;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.graph.GraphAdapterBuilder;
import ior.project.model.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

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

            Session session = sessionFactory.getCurrentSession();
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Player> cr = cb.createQuery(Player.class);
            Root<Player> root = cr.from(Player.class);
            cr.select(root);
            Query<Player> query = session.createQuery(cr);
            List<Player> results = query.getResultList();
            GsonBuilder gsonBuilder = new GsonBuilder();
            new GraphAdapterBuilder()
                    .addType(Player.class)
                    .addType(Team.class)
                    .registerOn(gsonBuilder);
            Gson gson = gsonBuilder.create();
            System.out.println(gson.toJson(results));
            transaction.rollback();

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}