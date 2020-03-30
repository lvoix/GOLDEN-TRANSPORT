package com.golden.transport.repository;

import com.golden.transport.domain.OperationLineConducteurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Operation Line Conducteurs entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OperationLineConRepository extends JpaRepository<OperationLineConducteurs, Long> {
}
