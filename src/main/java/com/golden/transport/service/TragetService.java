package com.golden.transport.service;

import com.golden.transport.domain.Traget;
import com.golden.transport.service.dto.TragetDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Traget}.
 */
public interface TragetService {

    /**
     * Save a traget.
     *
     * @param tragetDTO the entity to save.
     * @return the persisted entity.
     */
    TragetDTO save(TragetDTO tragetDTO);

    /**
     * Get all the tragets.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<TragetDTO> findAll(Pageable pageable);

    /**
     * Get the "id" traget.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TragetDTO> findOne(Long id);

    /**
     * Delete the "id" traget.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
