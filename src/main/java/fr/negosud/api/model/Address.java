package fr.negosud.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idAddress;

    @Enumerated(EnumType.STRING)
    private AdresseType type;

    private String number;

    private String customerFirstname;
    private String customerLastname;


    @Column(name = "street_name", nullable=false)
    private String streetName;

    @Column(nullable=false)
    private String zip;
    @Column(nullable=false)
    private String city;

    private String additional;

}
