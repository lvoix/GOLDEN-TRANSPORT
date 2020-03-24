package com.zakaria.khobizi.service;

import com.zakaria.khobizi.service.dto.DepencesDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.zakaria.khobizi.domain.Depences}.
 */
public interface DepencesService {

    /**
     * Save a depences.
     *
     * @param depencesDTO the entity to save.
     * @return the persisted entity.
     */
    DepencesDTO save(DepencesDTO depencesDTO);

    /**
     * Get all the depences.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<DepencesDTO> findAll(Pageable pageable);

    /**
     * Get the "id" depences.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DepencesDTO> findOne(Long id);

    /**
     * Delete the "id" depences.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
