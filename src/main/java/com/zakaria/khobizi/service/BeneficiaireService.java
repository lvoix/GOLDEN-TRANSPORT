package com.zakaria.khobizi.service;

import com.zakaria.khobizi.service.dto.BeneficiaireDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.zakaria.khobizi.domain.Beneficiaire}.
 */
public interface BeneficiaireService {

    /**
     * Save a beneficiaire.
     *
     * @param beneficiaireDTO the entity to save.
     * @return the persisted entity.
     */
    BeneficiaireDTO save(BeneficiaireDTO beneficiaireDTO);

    /**
     * Get all the beneficiaires.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<BeneficiaireDTO> findAll(Pageable pageable);

    /**
     * Get the "id" beneficiaire.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BeneficiaireDTO> findOne(Long id);

    /**
     * Delete the "id" beneficiaire.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
