package com.jeeproject.renocraft.service;

import com.jeeproject.renocraft.entity.Employeur;

import java.util.List;
import java.util.Optional;

public interface EmployeurService {
    public List<Employeur> getEmployeur();
    public List<Employeur> getEmployeurByService(Long id);
    public List<Employeur> getEmployeurByServiceCity(Long id, String ville);
    public void updateEmployeur(Long id_employeur, String nom, String prenom, String numero, String ville, Long id_service);
    public Optional<Employeur> getEmployeurById(Long id);
    public boolean deleteEmp(Long id);
    public void addEmployeur(String nom, String prenom, String numero, String ville, Long id_service);

}
