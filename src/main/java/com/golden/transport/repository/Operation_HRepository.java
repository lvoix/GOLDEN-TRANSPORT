package com.golden.transport.repository;

import com.golden.transport.domain.Operation_H;
import com.golden.transport.util.IDHistorique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Operation_H entity.
 */

@Repository
public interface Operation_HRepository extends JpaRepository<Operation_H, IDHistorique> {
}
