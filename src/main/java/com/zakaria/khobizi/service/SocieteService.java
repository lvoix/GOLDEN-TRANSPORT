package com.zakaria.khobizi.service;

import com.zakaria.khobizi.service.dto.SocieteDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.zakaria.khobizi.domain.Societe}.
 */
public interface SocieteService {

    /**
     * Save a societe.
     *
     * @param societeDTO the entity to save.
     * @return the persisted entity.
     */
    SocieteDTO save(SocieteDTO societeDTO);

    /**
     * Get all the societes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<SocieteDTO> findAll(Pageable pageable);

    /**
     * Get the "id" societe.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SocieteDTO> findOne(Long id);

    /**
     * Delete the "id" societe.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
