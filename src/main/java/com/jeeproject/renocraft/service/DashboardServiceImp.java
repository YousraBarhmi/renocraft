package com.jeeproject.renocraft.service;

import com.jeeproject.renocraft.repo.CommandeRepo;
import com.jeeproject.renocraft.repo.ContactRepo;
import com.jeeproject.renocraft.repo.EmployeurRepo;
import com.jeeproject.renocraft.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DashboardServiceImp implements DashboardService {

    private UserRepo userRep;

    private CommandeRepo commandeRepo;

    private EmployeurRepo empRepo;

    private ContactRepo contactRepo;

    public DashboardServiceImp(UserRepo userRep, CommandeRepo commandeRepo, EmployeurRepo empRepo, ContactRepo contactRepo) {
        this.userRep = userRep;
        this.commandeRepo = commandeRepo;
        this.empRepo = empRepo;
        this.contactRepo = contactRepo;
    }

    @Override
    public long getNombreClients(){
        return userRep.count();
    }
    @Override
    public long getNombreCommandes(){
        return commandeRepo.count();
    }
    @Override
    public long getNombreEmployes(){
        return empRepo.count();
    }
    @Override
    public long getNombreContacts(){
        return contactRepo.count();
    }
}
