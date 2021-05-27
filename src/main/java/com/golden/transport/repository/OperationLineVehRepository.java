package com.golden.transport.repository;

import com.golden.transport.domain.OperationLineVehicules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Operation Line Vehicules entity.
 */

@Repository
public interface OperationLineVehRepository extends JpaRepository<OperationLineVehicules, Long> {
}
