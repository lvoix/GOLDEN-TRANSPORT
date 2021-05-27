package com.golden.transport.repository;

import com.golden.transport.domain.BillingAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BillAccountRepository extends JpaRepository<BillingAccount, Long>, JpaSpecificationExecutor {
/*    @Query("select c from Account c where c.name like :name")
    Page<BillingAccount> findAcountByName(@Param("name") String name, Pageable pageable);

    @Query("select c from Account c where c.ref like :ref")
    Page<BillingAccount> findAcountByRef(@Param("ref") String ref, Pageable pageable);

    BillingAccount findByRef(String ref);*/
}
