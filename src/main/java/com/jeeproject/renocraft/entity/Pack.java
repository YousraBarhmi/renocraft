package com.jeeproject.renocraft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pack")
public class Pack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPack;

    private String piece;
    private double prix;
    private String description;

    @ManyToMany(mappedBy = "packs")
    private List<Commande> commandes;

}