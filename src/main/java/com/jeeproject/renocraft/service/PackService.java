package com.jeeproject.renocraft.service;


import com.jeeproject.renocraft.entity.Pack;

import java.util.List;

public interface PackService {
    public void addPack(Pack pack);
    public List<Pack> findPacksByIds(List<Long> packIds);
}
