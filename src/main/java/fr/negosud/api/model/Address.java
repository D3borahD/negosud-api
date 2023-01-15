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

    private String type;

    private String number;

    @Column(name = "street_name")
    private String streetName;

    private int zip;

    private String city;

    private String additional;
}
