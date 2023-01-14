package fr.negosud.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "provider")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idProvider;

    @Column(name = "name")
    private String nameProvider;

    @Column(name = "mail")
    private  String mailProvider;

}
