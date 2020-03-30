package com.golden.transport.service.impl;

import com.golden.transport.domain.Entite;
import com.golden.transport.service.EntiteService;
import com.golden.transport.repository.EntiteRepository;
import com.golden.transport.service.dto.EntiteDTO;
import com.golden.transport.service.mapper.EntiteMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Societe}.
 */
@Service
@Transactional
public class EntiteServiceImpl implements EntiteService {

    private final Logger log = LoggerFactory.getLogger(EntiteServiceImpl.class);

    private final EntiteRepository entiteRepository;

    private final EntiteMapper entiteMapper;
    @Autowired(required = true)
    public EntiteServiceImpl(EntiteRepository entiteRepository, EntiteMapper entiteMapper) {
        this.entiteRepository = entiteRepository;
        this.entiteMapper = entiteMapper;
    }

    /**
     * Save a societe.
     *
     * @param entiteDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public EntiteDTO save(EntiteDTO entiteDTO) {
        log.debug("Request to save entite : {}", entiteDTO);
        Entite entite = entiteMapper.toEntity(entiteDTO);
        entite = entiteRepository.save(entite);
        return entiteMapper.toDto(entite);
    }

    /**
     * Get all the entite.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<EntiteDTO> findAll(Pageable pageable) {
        log.debug("Request to get all entites");
        return entiteRepository.findAll(pageable)
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
    public Optional<EntiteDTO> findOne(Long id) {
        log.debug("Request to get entite : {}", id);
        return entiteRepository.findById(id)
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
        entiteRepository.deleteById(id);
    }
}
