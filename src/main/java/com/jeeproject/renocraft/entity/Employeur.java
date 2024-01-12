package com.jeeproject.renocraft.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Employeur")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_employeur")
public class Employeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_employeur;
    private String nom;
    private String prenom;
    private String numero;
    private String ville;
    @ManyToOne
    @JoinColumn(name = "id_service")
    private Service service;

}
