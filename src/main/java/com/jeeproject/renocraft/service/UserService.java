package com.jeeproject.renocraft.service;

import com.jeeproject.renocraft.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public void registerUser(User user);


    boolean usernameExists(String username);
    User signin(String username, String password);


    public Optional<User> getUser(String userName);
    public boolean editUser(User profil);
    public List<User> getClient();
    public boolean deleteClient(String username);

    void updateUser(String username, String name, String email, String phone);
}
