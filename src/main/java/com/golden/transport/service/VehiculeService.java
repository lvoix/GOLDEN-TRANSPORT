package com.golden.transport.service;

import com.golden.transport.domain.Vehicule;
import com.golden.transport.service.dto.VehiculeDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Vehicule}.
 */
public interface VehiculeService {

    /**
     * Save a vehicule.
     *
     * @param vehiculeDTO the entity to save.
     * @return the persisted entity.
     */
    VehiculeDTO save(VehiculeDTO vehiculeDTO);

    /**
     * Get all the vehicules.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<VehiculeDTO> findAll(Pageable pageable);

    /**
     * Get the "id" vehicule.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<VehiculeDTO> findOne(Long id);

    /**
     * Delete the "id" vehicule.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
