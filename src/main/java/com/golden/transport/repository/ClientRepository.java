package com.golden.transport.repository;

import com.golden.transport.domain.Client;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Client entity.
 */

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
         List<Client> findAllByUserId(Long user);

}
