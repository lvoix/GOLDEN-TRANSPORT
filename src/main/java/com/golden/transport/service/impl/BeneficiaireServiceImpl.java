package com.golden.transport.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.golden.transport.domain.Beneficiaire;
import com.golden.transport.repository.BeneficiaireRepository;
import com.golden.transport.service.BeneficiaireService;
import com.golden.transport.service.dto.BeneficiaireDTO;
import com.golden.transport.service.mapper.BeneficiaireMapper;

/**
 * Service Implementation for managing {@link Beneficiaire}.
 */
@Service
@Transactional
public class BeneficiaireServiceImpl implements BeneficiaireService {

    private final Logger log = LoggerFactory.getLogger(BeneficiaireServiceImpl.class);
    
    private final BeneficiaireRepository beneficiaireRepository;
     
    private final  BeneficiaireMapper beneficiaireMapper;
    
    @Autowired(required = true)
	public BeneficiaireServiceImpl(BeneficiaireRepository beneficiaireRepository, BeneficiaireMapper beneficiaireMapper) {
        this.beneficiaireRepository = beneficiaireRepository;
        this.beneficiaireMapper = beneficiaireMapper;
    }

    /**
     * Save a beneficiaire.
     *
     * @param beneficiaireDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public BeneficiaireDTO save(BeneficiaireDTO beneficiaireDTO) {
        log.debug("Request to save Beneficiaire : {}", beneficiaireDTO);
        Beneficiaire beneficiaire = beneficiaireMapper.toEntity(beneficiaireDTO);
        beneficiaire = beneficiaireRepository.save(beneficiaire);
        return beneficiaireMapper.toDto(beneficiaire);
    }

    /**
     * Get all the beneficiaires.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BeneficiaireDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Beneficiaires");
        return beneficiaireRepository.findAll(pageable)
            .map(beneficiaireMapper::toDto);
    }

    /**
     * Get one beneficiaire by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BeneficiaireDTO> findOne(Long id) {
        log.debug("Request to get Beneficiaire : {}", id);
        return beneficiaireRepository.findById(id)
            .map(beneficiaireMapper::toDto);
    }

    /**
     * Delete the beneficiaire by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Beneficiaire : {}", id);
        beneficiaireRepository.deleteById(id);
    }
}
