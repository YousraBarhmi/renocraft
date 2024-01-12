package com.jeeproject.renocraft.service;

import com.jeeproject.renocraft.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface UserService {
    public void registerUser(User user);
<<<<<<< HEAD

    boolean usernameExists(String username);
    User signin(String username, String password);

=======
    public Optional<User> getUser(String userName);
    public boolean editUser(User profil);
>>>>>>> 9c001438efcd4a809a9c3934fd38bb55354ffcd6
}
