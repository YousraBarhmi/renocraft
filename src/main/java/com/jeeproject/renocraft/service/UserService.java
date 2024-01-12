package com.jeeproject.renocraft.service;

import com.jeeproject.renocraft.entity.User;

import java.util.Optional;

public interface UserService {
    public void registerUser(User user);
    public Optional<User> getUser(String userName);
    public boolean editUser(User profil);
}
