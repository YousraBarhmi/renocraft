package com.jeeproject.renocraft.service;

import com.jeeproject.renocraft.repo.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeeproject.renocraft.entity.Service;

import java.util.List;
import java.util.Optional;


@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepo serviceRepo;

    @Autowired
    public ServiceServiceImpl(ServiceRepo serviceRepo) {
        this.serviceRepo = serviceRepo;
    }

    @Override
    public Optional<Service> getServiceById(Long Id)
    {
        return serviceRepo.findById(Id);

    }

    @Override
    public List<Service> getService() {
        return serviceRepo.findAll();
    }

    @Override
    public void updateService(Long service_id, String nom, String description) {
        Optional<Service> serviceOptional = serviceRepo.findById(service_id);
        serviceOptional.ifPresent(service -> {
            service.setId_service(service_id);
            service.setNom(nom);
            service.setDescription(description);
            serviceRepo.save(service);
        });
    }
}
