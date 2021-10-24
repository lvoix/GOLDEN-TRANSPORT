package com.golden.transport.service;

import com.golden.transport.domain.Conducteur;
import com.golden.transport.service.dto.ConducteurDTO;

import com.golden.transport.service.dto.criteresRechercheCondDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface ConducteurService {

    /**
     * Save a chauffeur.
     *
     * @param conducteurDTO the entity to save.
     * @return the persisted entity.
     */
    ConducteurDTO save(ConducteurDTO conducteurDTO);

    /**
     * Get all the chauffeurs.
     *
     * @return the list of entities.
     */
    Page<ConducteurDTO> findAll(int page, int size, String sortBy);


    Page<ConducteurDTO> findAll(Pageable pageable);
    /**
     * Get the "id" chauffeur.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ConducteurDTO> findOne(Long id);

    Optional<ConducteurDTO> findOneByCritere(criteresRechercheCondDTO criteresRecherchecondDTO);

    /**
     * Delete the "id" chauffeur.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
