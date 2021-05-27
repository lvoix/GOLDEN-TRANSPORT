package com.golden.transport.repository;

import com.golden.transport.domain.Station;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Station entity.
 */

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {
}
