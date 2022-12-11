package ior.project;

import ior.project.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;

public class DatabaseInitialData {
    Session session;

    public void initData(SessionFactory sessionFactory) {
        session = sessionFactory.getCurrentSession();

        // TEAMS
        Team team1 = new Team();
        team1.setCountry("Bangladesz");

        Team team2 = new Team();
        team2.setCountry("Polska");

        Team team3 = new Team();
        team3.setCountry("Francja");

        Team team4 = new Team();
        team4.setCountry("Niger");





        // PLAYERS
        Player player1 = new Player();
        player1.setFName("Janusz");
        player1.setSName("Sram");
        player1.setTeam(team1);

        Player player2 = new Player();
        player2.setFName("Sebastian");
        player2.setSName("Bąk");
        player2.setTeam(team1);

        Player player3 = new Player();
        player3.setFName("Wade");
        player3.setSName("Williams");
        player3.setTeam(team1);

        Player player4 = new Player();
        player4.setFName("Dave");
        player4.setSName("Harris");
        player4.setTeam(team1);

        Player player5 = new Player();
        player5.setFName("Ivan");
        player5.setSName("Thomas");
        player5.setTeam(team1);

        Player player6 = new Player();
        player6.setFName("Riley");
        player6.setSName("Robinson");
        player6.setTeam(team1);

        Player player7 = new Player();
        player7.setFName("Gilbert");
        player7.setSName("Walker");
        player7.setTeam(team2);

        Player player8 = new Player();
        player8.setFName("Jorge");
        player8.setSName("Scott");
        player8.setTeam(team2);

        Player player9 = new Player();
        player9.setFName("Dan");
        player9.setSName("Nelson");
        player9.setTeam(team2);

        Player player10 = new Player();
        player10.setFName("Brian");
        player10.setSName("Mitchell");
        player10.setTeam(team2);

        Player player11 = new Player();
        player11.setFName("Roberto");
        player11.setSName("Morgan");
        player11.setTeam(team2);

        Player player12 = new Player();
        player12.setFName("Ramon");
        player12.setSName("Cooper");
        player12.setTeam(team2);

        Player player13 = new Player();
        player13.setFName("Miles");
        player13.setSName("Howard");
        player13.setTeam(team3);

        Player player14 = new Player();
        player14.setFName("Liam");
        player14.setSName("Bąk");
        player14.setTeam(team3);

        Player player15 = new Player();
        player15.setFName("Nathaniel");
        player15.setSName("Davis");
        player15.setTeam(team3);

        Player player16 = new Player();
        player16.setFName("Ethan");
        player16.setSName("Miller");
        player16.setTeam(team3);

        Player player17 = new Player();
        player17.setFName("Lewis");
        player17.setSName("Martin");
        player17.setTeam(team3);

        Player player18 = new Player();
        player18.setFName("Milton");
        player18.setSName("Smith");
        player18.setTeam(team3);

        Player player19 = new Player();
        player19.setFName("Claude");
        player19.setSName("Anderson");
        player19.setTeam(team4);

        Player player20 = new Player();
        player20.setFName("Joshua");
        player20.setSName("White");
        player20.setTeam(team4);

        Player player21 = new Player();
        player21.setFName("Glen");
        player21.setSName("Perry");
        player21.setTeam(team4);

        Player player22 = new Player();
        player22.setFName("Harvey");
        player22.setSName("Clark");
        player22.setTeam(team4);

        Player player23 = new Player();
        player23.setFName("Blake");
        player23.setSName("Sram");
        player23.setTeam(team4);

        Player player24 = new Player();
        player24.setFName("Antonio");
        player24.setSName("Bąk");
        player24.setTeam(team4);




        // COACHES
        Coach coach1 = new Coach();
        coach1.setFName("Tytus");
        coach1.setSName("Bomba");
        coach1.setTeam(team1);
        team1.setCoach(coach1);

        Coach coach2 = new Coach();
        coach2.setFName("Jacob");
        coach2.setSName("Little");
        coach2.setTeam(team2);
        team2.setCoach(coach2);

        Coach coach3 = new Coach();
        coach3.setFName("Huj");
        coach3.setSName("Alvarez");
        coach3.setTeam(team3);
        team3.setCoach(coach3);

        Coach coach4 = new Coach();
        coach4.setFName("Jarek");
        coach4.setSName("Coach");
        coach4.setTeam(team4);
        team4.setCoach(coach4);





        // STADIONS
        Stadium stadium1 = new Stadium();
        stadium1.setName("Stadion ruchu");
        stadium1.setLocation("Chorzow");




        // MATCHES
        Match match1 = new Match();
        match1.setStadium(stadium1);
        match1.setDate(new Date());
        match1.setTeam1(team1);
        match1.setTeam2(team2);
        match1.setResult("Team 1 won");

        Match match2 = new Match();
        match2.setStadium(stadium1);
        match2.setDate(new Date(System.currentTimeMillis() + 172800000));
        match2.setTeam1(team3);
        match2.setTeam2(team4);
        match2.setResult("Team 4 won");




        // POSITIONS
        Position position1 = new Position();
        position1.setName(PositionName.GOALKEEPER);
        position1.setMatch(match1);
        position1.setPlayer(player1);
        position1.setTime(90);

        Position position2 = new Position();
        position2.setName(PositionName.LEFT_BACK);
        position2.setMatch(match1);
        position2.setPlayer(player2);
        position2.setTime(90);

        Position position3 = new Position();
        position3.setName(PositionName.LEFT_WING);
        position3.setMatch(match1);
        position3.setPlayer(player3);
        position3.setTime(90);

        Position position4 = new Position();
        position4.setName(PositionName.LEFT_MIDLEFTER);
        position4.setMatch(match1);
        position4.setPlayer(player4);
        position4.setTime(90);

        Position position5 = new Position();
        position5.setName(PositionName.STRIKER);
        position5.setMatch(match1);
        position5.setPlayer(player5);
        position5.setTime(90);

        Position position6 = new Position();
        position6.setName(PositionName.RESERVE);
        position6.setMatch(match1);
        position6.setPlayer(player6);
        position6.setTime(90);

        Position position7 = new Position();
        position7.setName(PositionName.GOALKEEPER);
        position7.setMatch(match1);
        position7.setPlayer(player7);
        position7.setTime(90);

        Position position8 = new Position();
        position8.setName(PositionName.LEFT_BACK);
        position8.setMatch(match1);
        position8.setPlayer(player8);
        position8.setTime(90);

        Position position9 = new Position();
        position9.setName(PositionName.LEFT_WING);
        position9.setMatch(match1);
        position9.setPlayer(player9);
        position9.setTime(90);

        Position position10 = new Position();
        position10.setName(PositionName.LEFT_MIDLEFTER);
        position10.setMatch(match1);
        position10.setPlayer(player10);
        position10.setTime(90);

        Position position11 = new Position();
        position11.setName(PositionName.STRIKER);
        position11.setMatch(match1);
        position11.setPlayer(player11);
        position11.setTime(90);

        Position position12 = new Position();
        position12.setName(PositionName.GOALKEEPER);
        position12.setMatch(match1);
        position12.setPlayer(player12);
        position12.setTime(90);

        Position position13 = new Position();
        position13.setName(PositionName.GOALKEEPER);
        position13.setMatch(match2);
        position13.setPlayer(player13);
        position13.setTime(90);

        Position position14 = new Position();
        position14.setName(PositionName.LEFT_BACK);
        position14.setMatch(match2);
        position14.setPlayer(player14);
        position14.setTime(90);

        Position position15 = new Position();
        position15.setName(PositionName.LEFT_WING);
        position15.setMatch(match2);
        position15.setPlayer(player15);
        position15.setTime(90);

        Position position16 = new Position();
        position16.setName(PositionName.LEFT_MIDLEFTER);
        position16.setMatch(match2);
        position16.setPlayer(player16);
        position16.setTime(90);

        Position position17 = new Position();
        position17.setName(PositionName.STRIKER);
        position17.setMatch(match2);
        position17.setPlayer(player17);
        position17.setTime(90);

        Position position18 = new Position();
        position18.setName(PositionName.GOALKEEPER);
        position18.setMatch(match2);
        position18.setPlayer(player18);
        position18.setTime(90);

        Position position19 = new Position();
        position19.setName(PositionName.GOALKEEPER);
        position19.setMatch(match2);
        position19.setPlayer(player19);
        position19.setTime(90);

        Position position20 = new Position();
        position20.setName(PositionName.LEFT_BACK);
        position20.setMatch(match2);
        position20.setPlayer(player20);
        position20.setTime(90);

        Position position21 = new Position();
        position21.setName(PositionName.LEFT_WING);
        position21.setMatch(match2);
        position21.setPlayer(player21);
        position21.setTime(90);

        Position position22 = new Position();
        position22.setName(PositionName.LEFT_MIDLEFTER);
        position22.setMatch(match2);
        position22.setPlayer(player22);
        position22.setTime(90);

        Position position23 = new Position();
        position23.setName(PositionName.STRIKER);
        position23.setMatch(match2);
        position23.setPlayer(player23);
        position23.setTime(90);

        Position position24 = new Position();
        position24.setName(PositionName.RESERVE);
        position24.setMatch(match2);
        position24.setPlayer(player24);
        position24.setTime(90);

        Transaction transaction = session.beginTransaction();
        session.persist(player1);
        session.persist(player2);
        session.persist(player3);
        session.persist(player4);
        session.persist(player5);
        session.persist(player6);
        session.persist(player7);
        session.persist(player8);
        session.persist(player9);
        session.persist(player10);
        session.persist(player11);
        session.persist(player12);
        session.persist(player13);
        session.persist(player14);
        session.persist(player15);
        session.persist(player16);
        session.persist(player17);
        session.persist(player18);
        session.persist(player19);
        session.persist(player20);
        session.persist(player21);
        session.persist(player22);
        session.persist(player23);
        session.persist(player24);

        session.persist(team1);
        session.persist(team2);
        session.persist(team3);
        session.persist(team4);

        session.persist(coach1);
        session.persist(coach2);
        session.persist(coach3);
        session.persist(coach4);

        session.persist(stadium1);

        session.persist(match1);
        session.persist(match2);

        session.persist(position1);
        session.persist(position2);
        session.persist(position3);
        session.persist(position4);
        session.persist(position5);
        session.persist(position6);
        session.persist(position7);
        session.persist(position8);
        session.persist(position9);
        session.persist(position10);
        session.persist(position11);
        session.persist(position12);
        session.persist(position13);
        session.persist(position14);
        session.persist(position15);
        session.persist(position16);
        session.persist(position17);
        session.persist(position18);
        session.persist(position19);
        session.persist(position20);
        session.persist(position21);
        session.persist(position22);
        session.persist(position23);
        session.persist(position24);

        transaction.commit();
    }
}
