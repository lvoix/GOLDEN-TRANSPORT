package com.zakaria.khobizi.service;

<<<<<<< HEAD:src/main/java/com/zakaria/khobizi/service/OperationService.java
import com.zakaria.khobizi.service.dto.OperationDTO;
=======
import com.golden.transport.domain.Operation;
import com.golden.transport.service.dto.OperationADDDTO;
import com.golden.transport.service.dto.OperationDTO;
>>>>>>> lvoix-2020:src/main/java/com/golden/transport/service/OperationService.java

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.zakaria.khobizi.domain.Operation}.
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
