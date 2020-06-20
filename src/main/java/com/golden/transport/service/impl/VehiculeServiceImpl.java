package com.golden.transport.service.impl;

import com.golden.transport.domain.Vehicule;
import com.golden.transport.repository.VehiculeRepository;
import com.golden.transport.service.VehiculeService;
import com.golden.transport.service.dto.VehiculeDTO;
import com.golden.transport.service.mapper.VehiculeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        vehicule.setMiseCirculation(vehiculeDTO.getMiseCirculation());
        vehicule.setDateMiseCirculation(vehiculeDTO.getDateMiseCirculation());
        vehicule.setDateCreation(new Date());
        vehicule.setEmail(vehiculeDTO.getEmail());
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
    public List<VehiculeDTO> findAll(Integer pageNo, Integer pageSize, String sortBy) {
        log.debug("Request to get all Vehicules");
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<VehiculeDTO> pagedResult = vehiculeRepository.findAll(paging).map(vehiculeMapper::toDto);
         if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<VehiculeDTO>();
        }
    }
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
