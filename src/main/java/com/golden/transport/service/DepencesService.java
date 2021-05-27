package com.golden.transport.service;

import com.golden.transport.service.dto.DepencesDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DepencesService {

    /**
     * Save a depences.
     *
     * @return the persisted entity.
     */
    DepencesDTO save(DepencesDTO depencesDTO);


     Boolean saveAll(List<DepencesDTO> depences);

    /**
     * Get all the depences.
     *
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
