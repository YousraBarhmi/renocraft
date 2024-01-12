package com.jeeproject.renocraft.service;

import com.jeeproject.renocraft.entity.User;
import com.jeeproject.renocraft.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo repo;
    @Override
    public void registerUser(User user) {
            repo.save(user);
    }
    public boolean usernameExists(String username) {
        return repo.existsByUsername(username);

    }
    @Override
    public User signin(String username, String password) {
            User user = repo.findByUsernameAndPassword(username, password);
            return user;
    }
}
