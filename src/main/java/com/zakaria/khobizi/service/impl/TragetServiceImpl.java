package com.zakaria.khobizi.service.impl;

import com.zakaria.khobizi.service.TragetService;
import com.zakaria.khobizi.domain.Traget;
import com.zakaria.khobizi.repository.TragetRepository;
import com.zakaria.khobizi.service.dto.TragetDTO;
import com.zakaria.khobizi.service.mapper.TragetMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Traget}.
 */
@Service
@Transactional
public class TragetServiceImpl implements TragetService {

    private final Logger log = LoggerFactory.getLogger(TragetServiceImpl.class);

    private final TragetRepository tragetRepository;

    private final TragetMapper tragetMapper;
    @Autowired(required = true)
    public TragetServiceImpl(TragetRepository tragetRepository, TragetMapper tragetMapper) {
        this.tragetRepository = tragetRepository;
        this.tragetMapper = tragetMapper;
    }

    /**
     * Save a traget.
     *
     * @param tragetDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public TragetDTO save(TragetDTO tragetDTO) {
        log.debug("Request to save Traget : {}", tragetDTO);
        Traget traget = tragetMapper.toEntity(tragetDTO);
        traget = tragetRepository.save(traget);
        return tragetMapper.toDto(traget);
    }

    /**
     * Get all the tragets.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<TragetDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Tragets");
        return tragetRepository.findAll(pageable)
            .map(tragetMapper::toDto);
    }

    /**
     * Get one traget by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<TragetDTO> findOne(Long id) {
        log.debug("Request to get Traget : {}", id);
        return tragetRepository.findById(id)
            .map(tragetMapper::toDto);
    }

    /**
     * Delete the traget by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Traget : {}", id);
        tragetRepository.deleteById(id);
    }
}
