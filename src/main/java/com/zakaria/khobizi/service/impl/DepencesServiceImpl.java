package com.zakaria.khobizi.service.impl;

import com.zakaria.khobizi.service.DepencesService;
import com.zakaria.khobizi.domain.Depences;
import com.zakaria.khobizi.repository.DepencesRepository;
import com.zakaria.khobizi.service.dto.DepencesDTO;
import com.zakaria.khobizi.service.mapper.DepencesMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Depences}.
 */
@Service
@Transactional
public class DepencesServiceImpl implements DepencesService {

    private final Logger log = LoggerFactory.getLogger(DepencesServiceImpl.class);

    private final DepencesRepository depencesRepository;

    private final DepencesMapper depencesMapper;
    @Autowired(required = true)
    public DepencesServiceImpl(DepencesRepository depencesRepository, DepencesMapper depencesMapper) {
        this.depencesRepository = depencesRepository;
        this.depencesMapper = depencesMapper;
    }

    /**
     * Save a depences.
     *
     * @param depencesDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public DepencesDTO save(DepencesDTO depencesDTO) {
        log.debug("Request to save Depences : {}", depencesDTO);
        Depences depences = depencesMapper.toEntity(depencesDTO);
        depences = depencesRepository.save(depences);
        return depencesMapper.toDto(depences);
    }

    /**
     * Get all the depences.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<DepencesDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Depences");
        return depencesRepository.findAll(pageable)
            .map(depencesMapper::toDto);
    }

    /**
     * Get one depences by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<DepencesDTO> findOne(Long id) {
        log.debug("Request to get Depences : {}", id);
        return depencesRepository.findById(id)
            .map(depencesMapper::toDto);
    }

    /**
     * Delete the depences by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Depences : {}", id);
        depencesRepository.deleteById(id);
    }
}
