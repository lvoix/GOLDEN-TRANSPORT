package com.golden.transport.service.impl;

import com.golden.transport.domain.Beneficiaire;
import com.golden.transport.service.BeneficiaireService;
import com.golden.transport.repository.BeneficiaireRepository;
import com.golden.transport.service.dto.BeneficiaireDTO;
import com.golden.transport.service.mapper.EntiteMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
public class BeneficiaireServiceImpl implements BeneficiaireService {

    private final Logger log = LoggerFactory.getLogger(BeneficiaireServiceImpl.class);

    private final BeneficiaireRepository beneficiaireRepository;

    private final EntiteMapper entiteMapper;
    @Autowired(required = true)
    public BeneficiaireServiceImpl(BeneficiaireRepository beneficiaireRepository, EntiteMapper entiteMapper) {
        this.beneficiaireRepository = beneficiaireRepository;
        this.entiteMapper = entiteMapper;
    }

    /**
     * Save a societe.
     *
     * @param beneficiaireDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public BeneficiaireDTO save(BeneficiaireDTO beneficiaireDTO) {
        log.debug("Request to save beneficiaire : {}", beneficiaireDTO);
        Beneficiaire beneficiaire = entiteMapper.toEntity(beneficiaireDTO);
        beneficiaire = beneficiaireRepository.save(beneficiaire);
        return entiteMapper.toDto(beneficiaire);
    }

    /**
     * Get all the entite.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BeneficiaireDTO> findAll(Pageable pageable) {
        log.debug("Request to get all entites");
        return beneficiaireRepository.findAll(pageable)
            .map(entiteMapper::toDto);
    }

    /**
     * Get one entite by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BeneficiaireDTO> findOne(Long id) {
        log.debug("Request to get entite : {}", id);
        return beneficiaireRepository.findById(id)
            .map(entiteMapper::toDto);
    }

    /**
     * Delete the entite by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete entite : {}", id);
        beneficiaireRepository.deleteById(id);
    }
}
