package ior.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "player")
public class Player extends Person {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="team_id", nullable=false)
    private Team team;
}
