package ior.project;

import ior.project.model.Player;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CriteriaAPI {
    private final SessionFactory sessionFactory;

    public CriteriaAPI(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<String> getPlayersNames() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
        Root<Player> root = criteriaQuery.from(Player.class);
        criteriaQuery.select(root.get("sName")).where(criteriaBuilder.like(root.get("sName"), "M%"));
        List<String> players = session.createQuery(criteriaQuery).getResultList();
        transaction.commit();
        session.close();
        return players;
    }
}
