package fr.negosud.api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToMany(mappedBy = "house")
    @JsonIgnore
    private Set<Product> productList;

}
