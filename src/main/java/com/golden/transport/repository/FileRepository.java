package com.golden.transport.repository;

import com.golden.transport.domain.File;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



/**
 * Spring Data  repository for the Files entity.
 */


@EnableJpaRepositories
@Repository
public interface FileRepository extends JpaRepository<File, Long> {

    @Query("select f from File f where f.entityId=:entityId")
    Page <File> findByEntityId(@Param("entityId") Long entityId, Pageable pageable);
}
