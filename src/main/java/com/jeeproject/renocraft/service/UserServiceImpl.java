package com.jeeproject.renocraft.service;

import com.jeeproject.renocraft.entity.User;
import com.jeeproject.renocraft.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    }
    public List<User> getClient(){
        return repo.selectClient();
    }

    @Override
    public boolean deleteClient(String username) {
        Optional<User> userToDelete = repo.findById(username);
        if (userToDelete.isPresent()) {
            User deletedUser = userToDelete.get();
            repo.delete(deletedUser);
            return true;
        }
        return false;
    }

<<<<<<< HEAD

    @Override
    public void updateUser(String username, String name, String email, String phone) {
        Optional<User> userOptional = repo.findById(username);
        userOptional.ifPresent(user -> {
            user.setName(name);
            user.setEmail(email);
            user.setPhone(phone);
            repo.save(user);
        });
    }
=======
>>>>>>> ad028e689f2b47c71386162cfa9d623f1a7240ae
}
