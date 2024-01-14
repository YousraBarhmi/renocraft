package com.jeeproject.renocraft.service;

import com.jeeproject.renocraft.entity.Employeur;
import com.jeeproject.renocraft.repo.EmployeurRepo;
import com.jeeproject.renocraft.repo.ServiceRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeurServiceImpl implements EmployeurService {

    private EmployeurRepo employeurRepo;
    private final ServiceRepo serviceRepo;
    public EmployeurServiceImpl(EmployeurRepo employeurRepo, ServiceRepo serviceRepo){
        this.employeurRepo=employeurRepo;
        this.serviceRepo = serviceRepo;
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

    @Override
    public void updateEmployeur(Long id_employeur, String nom, String prenom, String numero, String ville , Long id_service) {
        Optional<Employeur> employeurOptional = employeurRepo.findById(id_employeur);
        employeurOptional.ifPresent(employeur -> {
            employeur.setId_employeur(id_employeur);
            employeur.setNom(nom);
            employeur.setPrenom(prenom);
            employeur.setNumero(numero);
            employeur.setVille(ville);
            Optional<com.jeeproject.renocraft.entity.Service> service = serviceRepo.findById(id_service);
            employeur.setService(service.get());
            employeurRepo.save(employeur);
        });
    }

    @Override
    public Optional<Employeur> getEmployeurById(Long id) {
        return employeurRepo.findById(id);
    }

    @Override
    public boolean deleteEmp(Long id) {
        Optional<Employeur> empToDelete = employeurRepo.findById(id);
        if (empToDelete.isPresent()) {
            Employeur deleteEmp = empToDelete.get();
            employeurRepo.delete(deleteEmp);
            return true;
        }
        return false;
    }

    @Override
    public void addEmployeur(String nom, String prenom, String numero, String ville, Long id_service) {
        Employeur empToAdd = new Employeur();
        empToAdd.setNom(nom);
        empToAdd.setPrenom(prenom);
        empToAdd.setNumero(numero);
        empToAdd.setVille(ville);
        Optional<com.jeeproject.renocraft.entity.Service> service = serviceRepo.findById(id_service);
        empToAdd.setService(service.get());
        employeurRepo.save(empToAdd);
    }
}

