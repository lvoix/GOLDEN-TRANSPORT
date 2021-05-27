package com.golden.transport.service;

import com.golden.transport.service.dto.TargetDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface TargetService {

    /**
     * Save a traget.
     *
     * @return the persisted entity.
     */
    TargetDTO save(TargetDTO targetDTO);

    /**
     * Get all the tragets.
     *
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
