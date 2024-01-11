package com.jeeproject.renocraft.repo;

import com.jeeproject.renocraft.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact, Long> {

}