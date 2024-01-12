package com.jeeproject.renocraft.repo;

import com.jeeproject.renocraft.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ServiceRepo extends JpaRepository<Service, Long> {
}
