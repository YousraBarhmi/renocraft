package com.jeeproject.renocraft.service;

import com.jeeproject.renocraft.repo.CommandePacksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommandePackServiceImp implements CommandePackService{
    CommandePacksRepo commandePackRepo;
    @Autowired
    public CommandePackServiceImp(CommandePacksRepo commandePackRepo) {
        this.commandePackRepo = commandePackRepo;
    }
    public  List<Object[]> getTopPacksStatistics() {


        return commandePackRepo.findTopPacks();
    }

}
