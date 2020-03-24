package com.zakaria.khobizi.repository;

import com.zakaria.khobizi.domain.Traget;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Traget entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TragetRepository extends JpaRepository<Traget, Long> {
}
