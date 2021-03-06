package com.zakaria.khobizi.service;

import com.zakaria.khobizi.service.dto.ChauffeurDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.zakaria.khobizi.domain.Chauffeur}.
 */
public interface ChauffeurService {

    /**
     * Save a chauffeur.
     *
     * @param chauffeurDTO the entity to save.
     * @return the persisted entity.
     */
    ChauffeurDTO save(ChauffeurDTO chauffeurDTO);

    /**
     * Get all the chauffeurs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
<<<<<<< HEAD:src/main/java/com/zakaria/khobizi/service/ChauffeurService.java
    Page<ChauffeurDTO> findAll(Pageable pageable);
=======
    Page<ConducteurDTO> findAll(int page, int size, String sortBy);
>>>>>>> lvoix-2020:src/main/java/com/golden/transport/service/ConducteurService.java

    /**
     * Get the "id" chauffeur.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ChauffeurDTO> findOne(Long id);

    /**
     * Delete the "id" chauffeur.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
