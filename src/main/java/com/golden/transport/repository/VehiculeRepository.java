package com.golden.transport.repository;

import com.golden.transport.domain.Vehicule;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Vehicule entity.
 */

//@EnableJpaAuditing
@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> , JpaSpecificationExecutor{

    @Query("select c from Vehicule c where c.vehiculesNature=:vehiculeNatureID")
    Page<Vehicule> findByVehiculeNature(@Param("vehiculeNatureID") Long vehiculeNatureID, Pageable pageable);
}


