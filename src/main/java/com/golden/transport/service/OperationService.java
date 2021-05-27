package com.golden.transport.service;

import com.golden.transport.domain.Operation;
import com.golden.transport.service.dto.OperationADDDTO;
import com.golden.transport.service.dto.OperationDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Operation}.
 */
public interface OperationService {

    /**
     * Save a operation.
     *
     * @param operationDTO the entity to save.
     * @return the persisted entity.
     */
    OperationDTO save(OperationADDDTO operationDTO);

    /**
     * Get all the operations.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<OperationDTO> findAll(Pageable pageable);

    /**
     * Get the "id" operation.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<OperationDTO> findOne(Long id);

    /**
     * Delete the "id" operation.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}