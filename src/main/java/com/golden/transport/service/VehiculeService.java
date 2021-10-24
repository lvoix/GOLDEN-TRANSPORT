package com.golden.transport.service;

import com.golden.transport.service.dto.VehiculeDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface VehiculeService {

    /**
     * Save a vehicule.
     *
     * @return the persisted entity.
     */
    VehiculeDTO save(VehiculeDTO vehiculeDTO);

    /**
     * Get all the vehicules.
     *
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


    Page<VehiculeDTO> findByvehiculeNature(String vehiculeNature , Pageable pageable);

}
