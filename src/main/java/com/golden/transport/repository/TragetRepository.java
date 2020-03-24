package com.golden.transport.repository;

import com.golden.transport.domain.Traget;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Traget entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TragetRepository extends JpaRepository<Traget, Long> {
}
