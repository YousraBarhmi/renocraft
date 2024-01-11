package com.jeeproject.renocraft.repo;

import com.jeeproject.renocraft.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

}

