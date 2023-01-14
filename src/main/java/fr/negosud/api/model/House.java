package fr.negosud.api.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idHouse;

    @Column(name = "name")
    private String nameHouse;
}
