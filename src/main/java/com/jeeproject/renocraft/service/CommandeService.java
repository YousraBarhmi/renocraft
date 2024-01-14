package com.jeeproject.renocraft.service;

import com.jeeproject.renocraft.entity.Commande;


public interface CommandeService {
    public long getCommandesByMonth(String month);
    public void addCommande(Commande commande);
}
