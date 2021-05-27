package com.golden.transport.repository;

import com.golden.transport.domain.Currency;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long>, JpaSpecificationExecutor {
/*
    @Query("select c from Currency c where c.name like CONCAT('%',:name,'%') ")
    public Page<Currency> findByName(@Param("name") String name, Pageable pageable);*/

}
