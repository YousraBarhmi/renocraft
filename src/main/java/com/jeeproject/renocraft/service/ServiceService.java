package com.jeeproject.renocraft.service;

import com.jeeproject.renocraft.entity.Service;

import java.util.List;
import java.util.Optional;

public interface ServiceService {
    Optional<Service> getServiceById(Long id);
    List<Service> getService();
    public void updateService(Long service_id, String nom, String description);
}
