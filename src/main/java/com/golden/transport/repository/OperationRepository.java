package com.golden.transport.repository;

import com.golden.transport.domain.Operation;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Operation entity.
 */

@Repository
public interface OperationRepository extends RevisionRepository<Operation, Long, Long>, JpaRepository<Operation, Long> {
}
