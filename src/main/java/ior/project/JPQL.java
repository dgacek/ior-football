package ior.project;

import ior.project.model.Position;
import ior.project.model.PositionName;
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

    public void changePlayersPosition() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select p from Player d join Position p on d.id = p.player.id where d.sName LIKE 'M%'");
        List<Position> positions = query.getResultList();
        positions.forEach(position -> position.setName(PositionName.RESERVE));
        transaction.commit();
        session.close();
    }

    public List<Object[]> countPositionsGreaterThanOrEqualTwo() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select p.name, count(p.id) from Position p GROUP BY p.name HAVING count(p.id) >= 5");
        List<Object[]> countPositions = query.getResultList();
        transaction.commit();
        session.close();
        return countPositions;
    }

}
