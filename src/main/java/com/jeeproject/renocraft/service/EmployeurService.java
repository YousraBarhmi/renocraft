package com.jeeproject.renocraft.service;

import com.jeeproject.renocraft.entity.Employeur;

import java.util.List;

public interface EmployeurService {
    public List<Employeur> getEmployeur();
    public List<Employeur> getEmployeurByService(Long id);
    public List<Employeur> getEmployeurByServiceCity(Long id, String ville);

}
