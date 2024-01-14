package com.jeeproject.renocraft.entity;
import java.io.Serializable;
import java.util.Objects;

public class CommandePackId implements Serializable {

    private Long idCommande;
    private Long idPack;

    // Constructeurs, getters, setters et equals/hashCode
    // Assurez-vous de fournir les méthodes equals et hashCode pour une clé composite

    public CommandePackId() {
    }

    public CommandePackId(Long idCommande, Long idPack) {
        this.idCommande = idCommande;
        this.idPack = idPack;
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

    // equals and hashCode
    // Assurez-vous de générer ces méthodes en fonction des champs de la classe.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommandePackId that = (CommandePackId) o;
        return Objects.equals(idCommande, that.idCommande) &&
                Objects.equals(idPack, that.idPack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCommande, idPack);
    }
}
