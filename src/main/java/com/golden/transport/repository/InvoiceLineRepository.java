package com.golden.transport.repository;


import com.golden.transport.domain.InvoiceLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;



public interface InvoiceLineRepository extends JpaRepository<InvoiceLine, Long>, JpaSpecificationExecutor {




}
