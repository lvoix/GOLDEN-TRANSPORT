package com.golden.transport.repository;

import com.golden.transport.domain.Depences;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Depences entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DepencesRepository extends JpaRepository<Depences, Long> {
}
