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
}
