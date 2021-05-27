package com.golden.transport.service;

import com.golden.transport.domain.Client;
import com.golden.transport.service.dto.ClientDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Client}.
 */
public interface ClientService {

    /**
     * Save a beneficiaire.
     *
     * @param clientDTO the entity to save.
     * @return the persisted entity.
     */
    ClientDTO save(ClientDTO clientDTO);

    /**
     * Get all the beneficiaires.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ClientDTO> findAll(Pageable pageable);


    List<ClientDTO> getClientsByUserId(Long userId);

    /**
     * Get the "id" clients.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ClientDTO> findOne(Long id);

    /**
     * Delete the "id" beneficiaire.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
