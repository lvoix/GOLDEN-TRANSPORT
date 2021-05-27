package com.golden.transport.repository;


import com.golden.transport.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface PriceRepository extends JpaRepository<Price, Long>, JpaSpecificationExecutor {




}
