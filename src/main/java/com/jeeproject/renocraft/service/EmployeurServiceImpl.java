package com.jeeproject.renocraft.service;

import com.jeeproject.renocraft.entity.Employeur;
import com.jeeproject.renocraft.repo.ContactRepo;
import com.jeeproject.renocraft.repo.EmployeurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeurServiceImpl implements EmployeurService {

    private EmployeurRepo employeurRepo;
    public EmployeurServiceImpl(EmployeurRepo employeurRepo){
        this.employeurRepo=employeurRepo;
    }
    public List<Employeur> getEmployeur(){
        return employeurRepo.findAll();

    }


    public List<Employeur> getEmployeurByService(Long id){
        return employeurRepo.findEmployeursByServiceId(id);
    }
    public List<Employeur> getEmployeurByServiceCity(Long id, String ville){
        return employeurRepo.findEmployeursByServiceIdCity(id,ville);
    }

}
