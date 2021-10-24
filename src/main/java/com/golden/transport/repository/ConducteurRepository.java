package com.golden.transport.repository;

import com.golden.transport.domain.Conducteur;

import com.golden.transport.service.dto.ConducteurDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data  repository for the Chauffeur entity.
 */

@Repository
public interface ConducteurRepository extends JpaRepository<Conducteur, Long> {
    @Query("select c from Conducteur c where c.id=:id or c.cni like CONCAT('%',:cin,'%') or  c.npasseport like CONCAT('%',:npasseport,'%')")
    Optional<Conducteur> findByCritere(@Param("id") Long id, @Param("cin") String cin, @Param("npasseport") String npasseport);
}
