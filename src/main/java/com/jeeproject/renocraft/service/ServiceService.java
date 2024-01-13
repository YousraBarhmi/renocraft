package com.jeeproject.renocraft.service;

import com.jeeproject.renocraft.entity.Employeur;
import com.jeeproject.renocraft.entity.Service;

import java.util.List;
import java.util.Optional;

public interface ServiceService {
    Service getServiceById(Long id);
    List<Service> getService();
}
