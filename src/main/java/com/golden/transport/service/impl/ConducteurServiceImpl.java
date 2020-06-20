package com.golden.transport.service.impl;

import com.golden.transport.domain.Conducteur;
import com.golden.transport.service.ConducteurService;
import com.golden.transport.repository.ConducteurRepository;
import com.golden.transport.service.dto.ConducteurDTO;
import com.golden.transport.service.mapper.ConducteurMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Chauffeur}.
 */
@Service
@Transactional
public class ConducteurServiceImpl implements ConducteurService {

    private final Logger log = LoggerFactory.getLogger(ConducteurServiceImpl.class);

    private final ConducteurRepository conducteurRepository;

    private final ConducteurMapper conducteurMapper;
    @Autowired(required = true)
    public ConducteurServiceImpl(ConducteurRepository conducteurRepository, ConducteurMapper conducteurMapper) {
        this.conducteurRepository = conducteurRepository;
        this.conducteurMapper = conducteurMapper;
    }

    /**
     * Save a chauffeur.
     *
     * @param conducteurDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ConducteurDTO save(ConducteurDTO conducteurDTO) {
        log.debug("Request to save conducteur : {}", conducteurDTO);
        Conducteur conducteur = conducteurMapper.toEntity(conducteurDTO);
        conducteur = conducteurRepository.save(conducteur);
        return conducteurMapper.toDto(conducteur);
    }

    /**
     * Get all the conducteurs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ConducteurDTO> findAll(int page, int size, String sortBy) {
        log.debug("Request to get all conducteurs");
        Pageable paging = PageRequest.of(page, size, Sort.by(sortBy));
        return conducteurRepository.findAll(paging)
            .map(conducteurMapper::toDto);
    }

    /**
     * Get one conducteur by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ConducteurDTO> findOne(Long id) {
        log.debug("Request to get conducteur : {}", id);
        return conducteurRepository.findById(id)
            .map(conducteurMapper::toDto);
    }

    /**
     * Delete the conducteur by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete conducteur : {}", id);
        conducteurRepository.deleteById(id);
    }
}
