package com.golden.transport.service;

import com.golden.transport.service.dto.OperationADDDTO;
import com.golden.transport.service.dto.OperationDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface OperationService {

    /**
     * Save a operation.
     *
     * @return the persisted entity.
     */
    OperationDTO save(OperationADDDTO operationDTO);

    /**
     * Get all the operations.
     *
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


    OperationDTO getOperation1(Long operationId);

    /**
     * Delete the "id" operation.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
