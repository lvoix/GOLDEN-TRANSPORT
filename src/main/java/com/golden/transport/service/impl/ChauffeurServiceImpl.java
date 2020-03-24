package com.golden.transport.service.impl;

import com.golden.transport.service.ChauffeurService;
import com.golden.transport.domain.Chauffeur;
import com.golden.transport.repository.ChauffeurRepository;
import com.golden.transport.service.dto.ChauffeurDTO;
import com.golden.transport.service.mapper.ChauffeurMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Chauffeur}.
 */
@Service
@Transactional
public class ChauffeurServiceImpl implements ChauffeurService {

    private final Logger log = LoggerFactory.getLogger(ChauffeurServiceImpl.class);

    private final ChauffeurRepository chauffeurRepository;

    private final ChauffeurMapper chauffeurMapper;
    @Autowired(required = true)
    public ChauffeurServiceImpl(ChauffeurRepository chauffeurRepository, ChauffeurMapper chauffeurMapper) {
        this.chauffeurRepository = chauffeurRepository;
        this.chauffeurMapper = chauffeurMapper;
    }

    /**
     * Save a chauffeur.
     *
     * @param chauffeurDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ChauffeurDTO save(ChauffeurDTO chauffeurDTO) {
        log.debug("Request to save Chauffeur : {}", chauffeurDTO);
        Chauffeur chauffeur = chauffeurMapper.toEntity(chauffeurDTO);
        chauffeur = chauffeurRepository.save(chauffeur);
        return chauffeurMapper.toDto(chauffeur);
    }

    /**
     * Get all the chauffeurs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ChauffeurDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Chauffeurs");
        return chauffeurRepository.findAll(pageable)
            .map(chauffeurMapper::toDto);
    }

    /**
     * Get one chauffeur by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ChauffeurDTO> findOne(Long id) {
        log.debug("Request to get Chauffeur : {}", id);
        return chauffeurRepository.findById(id)
            .map(chauffeurMapper::toDto);
    }

    /**
     * Delete the chauffeur by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Chauffeur : {}", id);
        chauffeurRepository.deleteById(id);
    }
}
