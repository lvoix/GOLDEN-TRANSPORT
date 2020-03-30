package com.golden.transport.service;

import com.golden.transport.domain.Target;
import com.golden.transport.service.dto.TargetDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Traget}.
 */
public interface TargetService {

    /**
     * Save a traget.
     *
     * @param targetDTO the entity to save.
     * @return the persisted entity.
     */
    TargetDTO save(TargetDTO targetDTO);

    /**
     * Get all the tragets.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<TargetDTO> findAll(Pageable pageable);

    /**
     * Get the "id" traget.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TargetDTO> findOne(Long id);

    /**
     * Delete the "id" traget.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
