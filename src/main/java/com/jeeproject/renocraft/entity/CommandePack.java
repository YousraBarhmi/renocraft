package com.jeeproject.renocraft.entity;
import jakarta.persistence.*;

@Entity
@IdClass(CommandePackId.class)

@Table(name = "commande_pack")
public class CommandePack {


    @Id
    @Column(name = "id_commande")
    private Long idCommande;

    @Id
    @Column(name = "id_pack")
    private Long idPack;

    // D'autres champs de la table commande_pack

    // Constructeurs, getters, setters

    public CommandePack() {
    }

    public CommandePack(Long idCommande, Long idPack /*, d'autres champs */) {
        this.idCommande = idCommande;
        this.idPack = idPack;
        // Initialiser d'autres champs
    }

    // Getters and Setters

    public Long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
    }

    public Long getIdPack() {
        return idPack;
    }

    public void setIdPack(Long idPack) {
        this.idPack = idPack;
    }

    // D'autres getters et setters pour les autres champs de la table

    // equals and hashCode
    // Assurez-vous de générer ces méthodes en fonction des champs de la classe.
}
