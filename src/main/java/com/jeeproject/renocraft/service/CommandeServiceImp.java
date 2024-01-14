package com.jeeproject.renocraft.service;

import com.jeeproject.renocraft.entity.Commande;
import com.jeeproject.renocraft.repo.CommandeRepo;
import org.springframework.stereotype.Service;

@Service
public class CommandeServiceImp implements CommandeService{
    private final CommandeRepo commandeRepo;

    public CommandeServiceImp(CommandeRepo commandeRepo){
        this.commandeRepo=commandeRepo;
    }

    @Override
    public void addCommande(Commande commande){
        commandeRepo.save(commande);
    }
    @Override
    public long getCommandesByMonth(String month) {

        return commandeRepo.countByMonth(month);
    }
}
