package com.golden.transport.service;

import com.golden.transport.service.dto.StationDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface StationService {

    /**
     * Save a station.
     *
     * @return the persisted entity.
     */
    StationDTO save(StationDTO stationDTO);

    /**
     * Get all the stations.
     *
     * @return the list of entities.
     */
    Page<StationDTO> findAll(Pageable pageable);

    /**
     * Get the "id" station.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<StationDTO> findOne(Long id);

    /**
     * Delete the "id" station.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
