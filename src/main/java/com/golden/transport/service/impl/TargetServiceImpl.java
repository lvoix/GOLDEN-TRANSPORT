package com.golden.transport.service.impl;

import com.golden.transport.domain.Target;
import com.golden.transport.repository.TargetRepository;
import com.golden.transport.service.TargetService;
import com.golden.transport.service.dto.TargetDTO;
import com.golden.transport.service.mapper.TargetMapper;
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
public class TargetServiceImpl implements TargetService {

    private final Logger log = LoggerFactory.getLogger(TargetServiceImpl.class);

    private final TargetRepository targetRepository;

    private final TargetMapper targetMapper;
    @Autowired(required = true)
    public TargetServiceImpl(TargetRepository targetRepository, TargetMapper targetMapper) {
        this.targetRepository = targetRepository;
        this.targetMapper = targetMapper;
    }

    /**
     * Save a traget.
     *
     * @return the persisted entity.
     */
    @Override
    public TargetDTO save(TargetDTO targetDTO) {
        log.debug("Request to save Target : {}", targetDTO);
        Target target = targetMapper.toEntity(targetDTO);
        target = targetRepository.save(target);
        return targetMapper.toDto(target);
    }

    /**
     * Get all the tragets.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<TargetDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Tragets");
        return targetRepository.findAll(pageable)
            .map(targetMapper::toDto);
    }

    /**
     * Get one traget by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<TargetDTO> findOne(Long id) {
        log.debug("Request to get Target : {}", id);
        return targetRepository.findById(id)
            .map(targetMapper::toDto);
    }

    /**
     * Delete the traget by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Target : {}", id);
        targetRepository.deleteById(id);
    }
}
