package com.jeeproject.renocraft.repo;


import com.jeeproject.renocraft.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommandeRepo extends JpaRepository<Commande, Long> {
        @Query(value = "SELECT COUNT(*) FROM commandes WHERE MONTH(date_commande) = ?1", nativeQuery = true)
        long countByMonth(String month);
}
