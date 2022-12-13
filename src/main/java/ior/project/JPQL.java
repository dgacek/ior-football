package ior.project;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class JPQL {

    private final SessionFactory sessionFactory;

    public JPQL(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<String> getPlayersNames() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select d.sName from Player d where d.sName LIKE 'M%'");
        List<String> players = query.getResultList();
        transaction.commit();
        session.close();
        return players;
    }

}
