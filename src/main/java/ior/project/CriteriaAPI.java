package ior.project;

import ior.project.model.Player;
import ior.project.model.Position;
import ior.project.model.PositionName;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
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

    public void changePlayersPosition() {
        // TODO: doesn't work
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Position> criteria = builder.createQuery(Position.class);
        Root<Player> playerRoot = criteria.from(Player.class);
        Join<Player, Position> positionJoin = playerRoot.join("position");
        criteria.select(positionJoin).where(builder.like(playerRoot.get("sName"), "M%"));
        List<Position> positions = session.createQuery(criteria).getResultList();
        positions.forEach(position -> position.setName(PositionName.RESERVE));
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
