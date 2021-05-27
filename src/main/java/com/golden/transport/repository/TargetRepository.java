package com.golden.transport.repository;

import com.golden.transport.domain.Target;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Target entity.
 */

@Repository
public interface TargetRepository extends JpaRepository<Target, Long> {
}
