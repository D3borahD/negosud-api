package fr.negosud.api.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "familly")
public class Familly {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idFamilly;

    @Column(name = "name")
    private String nameFamilly;
}
