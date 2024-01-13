package com.jeeproject.renocraft.service;

import com.jeeproject.renocraft.entity.Employeur;
import com.jeeproject.renocraft.repo.ServiceRepo;
import jakarta.persistence.EntityNotFoundException;
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
    public Service getServiceById(Long Id)
    {
        Optional<Service> optionalService = serviceRepo.findById(Id);
        return optionalService.orElse(null);
    }

    @Override
    public List<Service> getService() {
        return serviceRepo.findAll();
    }
}
