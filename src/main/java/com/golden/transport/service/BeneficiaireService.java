package com.golden.transport.service;

import com.golden.transport.service.dto.BeneficiaireDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface BeneficiaireService {

    /**
     * Save a societe.
     *
     * @return the persisted entity.
     */
    BeneficiaireDTO save(BeneficiaireDTO beneficiaireDTO);

    /**
     * Get all the societes.
     *
     * @return the list of entities.
     */
    Page<BeneficiaireDTO> findAll(Pageable pageable);

    /**
     * Get the "id" societe.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BeneficiaireDTO> findOne(Long id);

    /**
     * Delete the "id" societe.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);


}
