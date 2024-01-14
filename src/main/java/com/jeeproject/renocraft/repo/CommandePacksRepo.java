package com.jeeproject.renocraft.repo;

import com.jeeproject.renocraft.entity.CommandePack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommandePacksRepo extends JpaRepository<CommandePack, Long> {
    @Query(value = "SELECT cp.id_pack, COUNT(cp.id_pack) " +
            "FROM commande_pack cp " +
            "GROUP BY cp.id_pack " +
            "ORDER BY COUNT(cp.id_pack) DESC",
            nativeQuery = true)

    List<Object[]> findTopPacks();
}
