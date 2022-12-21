package ior.project;

import ior.project.model.Player;
import ior.project.model.Position;
import ior.project.model.PositionName;
import jakarta.persistence.criteria.*;
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

    public void changePlayersPosition() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaUpdate<Position> update = builder.createCriteriaUpdate(Position.class);
        Root<Position> root = update.from(Position.class);
        update.set(root.get("name"), PositionName.RESERVE);

        Subquery<Player> subquery = update.subquery(Player.class);
        Root<Player> subRoot = subquery.from(Player.class);
        subquery.select(subRoot);
        subquery.where(builder.like(subRoot.get("sName"), "M%"));

        update.where(builder.in(root.get("player")).value(subquery));

        session.createQuery(update).executeUpdate();
        transaction.commit();
        session.close();
    }


    public List<Object[]> countPositionsGreaterThanOrEqualTwo() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
        Root<Position> root = criteria.from(Position.class);
        criteria.multiselect(root.get("name"), builder.count(root.get("id")));
        criteria.groupBy(root.get("name"));
        criteria.having(builder.ge(builder.count(root.get("id")), 5));

        List<Object[]> countPositions = session.createQuery(criteria).getResultList();

        transaction.commit();
        session.close();
        return countPositions;
    }

}
