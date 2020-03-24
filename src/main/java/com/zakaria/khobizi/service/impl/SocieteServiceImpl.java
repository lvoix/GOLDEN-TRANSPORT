package com.zakaria.khobizi.service.impl;

import com.zakaria.khobizi.service.SocieteService;
import com.zakaria.khobizi.domain.Societe;
import com.zakaria.khobizi.repository.SocieteRepository;
import com.zakaria.khobizi.service.dto.SocieteDTO;
import com.zakaria.khobizi.service.mapper.SocieteMapper;
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
public class SocieteServiceImpl implements SocieteService {

    private final Logger log = LoggerFactory.getLogger(SocieteServiceImpl.class);

    private final SocieteRepository societeRepository;

    private final SocieteMapper societeMapper;
    @Autowired(required = true)
    public SocieteServiceImpl(SocieteRepository societeRepository, SocieteMapper societeMapper) {
        this.societeRepository = societeRepository;
        this.societeMapper = societeMapper;
    }

    /**
     * Save a societe.
     *
     * @param societeDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public SocieteDTO save(SocieteDTO societeDTO) {
        log.debug("Request to save Societe : {}", societeDTO);
        Societe societe = societeMapper.toEntity(societeDTO);
        societe = societeRepository.save(societe);
        return societeMapper.toDto(societe);
    }

    /**
     * Get all the societes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SocieteDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Societes");
        return societeRepository.findAll(pageable)
            .map(societeMapper::toDto);
    }

    /**
     * Get one societe by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<SocieteDTO> findOne(Long id) {
        log.debug("Request to get Societe : {}", id);
        return societeRepository.findById(id)
            .map(societeMapper::toDto);
    }

    /**
     * Delete the societe by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Societe : {}", id);
        societeRepository.deleteById(id);
    }
}
