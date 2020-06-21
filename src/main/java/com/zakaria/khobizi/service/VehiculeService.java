package com.zakaria.khobizi.service;

import com.zakaria.khobizi.service.dto.VehiculeDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.zakaria.khobizi.domain.Vehicule}.
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
     List<VehiculeDTO> findAll(Integer pageNo, Integer pageSize, String sortBy) ;
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
