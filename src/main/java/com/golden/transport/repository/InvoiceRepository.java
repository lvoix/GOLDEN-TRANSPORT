package com.golden.transport.repository;


import com.golden.transport.domain.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;


@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, String> {

/*    @Query("select i from invoices i join i.billaccount a where a.id=:id")
    Page<Invoice> findInvoiceByAccountId(@Param("id") Long accountId, Pageable pageable);
    Invoice findByRef(String ref);*/

     @Query("select i from Invoice as i where (i.billingDate>= :date1 and i.billingDate<= :date2)")
     Page<Invoice> findAllByBDates(@Param("date1") Date date1, @Param("date2") Date date2, Pageable pageable);

     @Query("select i from Invoice as i where (i.dateCreation>= :date1 and i.dateCreation<= :date2)")
     Page<Invoice> findAllByCDates(@Param("date1") Date date1, @Param("date2") Date date2, Pageable pageable);

     @Query("select i from Invoice as i where i.beneficiaire = :beneficiaire")
     Page<Invoice> findAllByEntite(@Param("beneficiaire") Integer beneficiaire, Pageable pageable);
}
