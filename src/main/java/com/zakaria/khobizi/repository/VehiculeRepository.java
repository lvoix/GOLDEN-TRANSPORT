package com.zakaria.khobizi.repository;

import com.zakaria.khobizi.domain.Vehicule;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Vehicule entity.
 */
@SuppressWarnings("unused")
@EnableJpaAuditing
@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> , JpaSpecificationExecutor{
}
