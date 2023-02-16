package fr.negosud.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "familly")
public class Familly {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idFamilly;

    @Column(name = "name", nullable=false)
    private String nameFamilly;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "familly_house",
            joinColumns = @JoinColumn(name = "familly_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "house_id", referencedColumnName = "id", nullable = false)
    )
    @JsonIgnore
    private Set<House> houses = new HashSet<>();
    //private List<House> houses = new ArrayList<>();



}
