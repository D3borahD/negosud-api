package fr.negosud.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import jakarta.persistence.*;

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

    @OneToMany(mappedBy = "familly")
    @JsonIgnore
    private Set<Product> productList;
}
