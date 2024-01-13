package com.jeeproject.renocraft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "commandes")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_commande")
    private Long idCommande;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "commande_pack",
            joinColumns = @JoinColumn(name = "id_commande"),
            inverseJoinColumns = @JoinColumn(name = "id_pack")
    )
    private List<Pack> packs;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_commande")
    private Date dateCommande;

    @Temporal(TemporalType.TIME)
    @Column(name = "heure_commande")
    private Date heureCommande;
}
