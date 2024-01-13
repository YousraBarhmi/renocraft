package com.jeeproject.renocraft.repo;

import com.jeeproject.renocraft.entity.Employeur;
import com.jeeproject.renocraft.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
  boolean existsByUsername(String username);
  User findByUsernameAndPassword(String username, String password);
  @Query("SELECT u FROM User u WHERE u.username != 'admin'" )
  List<User> selectClient();

}

