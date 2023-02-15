package fr.negosud.api.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "house")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idHouse;

    @Column(name = "name", nullable=false)
    private String nameHouse;

   /*@ManyToMany(
            mappedBy = "houses",fetch = FetchType.LAZY
    )
    private Set<Familly> famillies = new HashSet<>();*/
    //private List<Familly> famillies = new ArrayList<>();



}
