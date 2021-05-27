package com.golden.transport.repository;

import com.golden.transport.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Contact entity.
 */

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
