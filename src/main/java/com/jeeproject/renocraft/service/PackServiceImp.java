package com.jeeproject.renocraft.service;


import com.jeeproject.renocraft.entity.Pack;
import com.jeeproject.renocraft.repo.PackRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackServiceImp implements PackService{
    private final PackRepo packRepo;

    public PackServiceImp(PackRepo packRepo){
        this.packRepo=packRepo;
    }

    @Override
    public void addPack(Pack pack){
        packRepo.save(pack);
    }

    @Override
    public List<Pack> findPacksByIds(List<Long> packIds) {
        return packRepo.findAllById(packIds);
    }
}
