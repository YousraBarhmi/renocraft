package com.jeeproject.renocraft.service;

import com.jeeproject.renocraft.entity.User;
import com.jeeproject.renocraft.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo repo;
    @Override
    public void registerUser(User user) {
            repo.save(user);
    }
<<<<<<< HEAD
    public boolean usernameExists(String username) {
        return repo.existsByUsername(username);

    }
    @Override
    public User signin(String username, String password) {
            User user = repo.findByUsernameAndPassword(username, password);
            return user;
=======

    @Override
    public Optional<User> getUser(String userName) {
        return repo.findById(userName);
    }

    @Override
    public boolean editUser(User updatedUser) {
        // Check if the user with the given username exists
        Optional<User> existingUser = repo.findById(updatedUser.getUsername());

        if (existingUser.isPresent()) {
            // Update the existing user's profile information
            User userToUpdate = existingUser.get();
            userToUpdate.setName(updatedUser.getName());
            userToUpdate.setPhone(updatedUser.getPhone());
            repo.save(userToUpdate);
            return true;
        }
        return false;
>>>>>>> 9c001438efcd4a809a9c3934fd38bb55354ffcd6
    }
}
