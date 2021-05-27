package com.golden.transport.repository;

import com.golden.transport.domain.Entite;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Societe entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EntiteRepository extends JpaRepository<Entite, Long> {
}