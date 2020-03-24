package com.zakaria.khobizi.service.impl;

import com.zakaria.khobizi.service.VehiculeService;
import com.zakaria.khobizi.domain.Vehicule;
import com.zakaria.khobizi.repository.VehiculeRepository;
import com.zakaria.khobizi.service.dto.VehiculeDTO;
import com.zakaria.khobizi.service.mapper.VehiculeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Vehicule}.
 */
@Service
@Transactional
public class VehiculeServiceImpl implements VehiculeService {

    private final Logger log = LoggerFactory.getLogger(VehiculeServiceImpl.class);

    private final VehiculeRepository vehiculeRepository;

    private final VehiculeMapper vehiculeMapper;
    @Autowired(required = true)
    public VehiculeServiceImpl(VehiculeRepository vehiculeRepository, VehiculeMapper vehiculeMapper) {
        this.vehiculeRepository = vehiculeRepository;
        this.vehiculeMapper = vehiculeMapper;
    }

    /**
     * Save a vehicule.
     *
     * @param vehiculeDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public VehiculeDTO save(VehiculeDTO vehiculeDTO) {
        log.debug("Request to save Vehicule : {}", vehiculeDTO);
        Vehicule vehicule = vehiculeMapper.toEntity(vehiculeDTO);
        vehicule = vehiculeRepository.save(vehicule);
        return vehiculeMapper.toDto(vehicule);
    }

    /**
     * Get all the vehicules.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<VehiculeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Vehicules");
        return vehiculeRepository.findAll(pageable)
            .map(vehiculeMapper::toDto);
    }

    /**
     * Get one vehicule by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<VehiculeDTO> findOne(Long id) {
        log.debug("Request to get Vehicule : {}", id);
        return vehiculeRepository.findById(id)
            .map(vehiculeMapper::toDto);
    }

    /**
     * Delete the vehicule by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Vehicule : {}", id);
        vehiculeRepository.deleteById(id);
    }
}
