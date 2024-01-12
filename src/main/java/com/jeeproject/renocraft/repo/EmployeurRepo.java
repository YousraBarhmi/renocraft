package com.jeeproject.renocraft.repo;

import com.jeeproject.renocraft.entity.Employeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeurRepo  extends JpaRepository<Employeur, Long> {
    @Query("SELECT e FROM Employeur e WHERE e.service.id_service = :id")
    List<Employeur> findEmployeursByServiceId(@Param("id") Long id);
    @Query("SELECT e FROM Employeur e WHERE e.service.id_service = :id and e.ville like :ville")
    List<Employeur> findEmployeursByServiceIdCity(@Param("id") Long id,@Param("ville")String ville);
}
