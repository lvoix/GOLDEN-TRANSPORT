package com.golden.transport.repository;

import com.golden.transport.domain.Conducteur;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Chauffeur entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ConducteurRepository extends JpaRepository<Conducteur, Long> {
}
