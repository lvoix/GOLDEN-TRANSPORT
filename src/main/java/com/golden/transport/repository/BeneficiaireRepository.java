package com.golden.transport.repository;

import com.golden.transport.domain.Beneficiaire;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Societe Beneficiaire.
 */

@Repository
public interface BeneficiaireRepository extends JpaRepository<Beneficiaire, Long> {
}
