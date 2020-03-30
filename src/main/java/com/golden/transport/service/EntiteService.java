package com.golden.transport.service;

import com.golden.transport.domain.Entite;
import com.golden.transport.service.dto.EntiteDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link entite}.
 */
public interface EntiteService {

    /**
     * Save a societe.
     *
     * @param entiteDTO the entity to save.
     * @return the persisted entity.
     */
    EntiteDTO save(EntiteDTO entiteDTO);

    /**
     * Get all the societes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<EntiteDTO> findAll(Pageable pageable);

    /**
     * Get the "id" societe.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<EntiteDTO> findOne(Long id);

    /**
     * Delete the "id" societe.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
