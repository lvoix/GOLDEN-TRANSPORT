package com.zakaria.khobizi.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zakaria.khobizi.service.OperationService;
import com.zakaria.khobizi.service.dto.OperationDTO;
import com.zakaria.khobizi.util.HeaderUtil;
import com.zakaria.khobizi.util.PaginationUtil;
import com.zakaria.khobizi.util.ResponseUtil;

/**
 * REST controller for managing {@link com.zakaria.khobizi.domain.Operation}.
 */
@RestController
@RequestMapping("/api")
public class OperationResource {

    private final Logger log = LoggerFactory.getLogger(OperationResource.class);

    private static final String ENTITY_NAME = "operation";

    @Value("${clientApp.name}")
    private String applicationName;

    private final OperationService operationService;
    
    @Autowired(required = true)
    public OperationResource(OperationService operationService) {
        this.operationService = operationService;
    }

    /**
     * {@code POST  /operations} : Create a new operation.
     *
     * @param operationDTO the operationDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new operationDTO, or with status {@code 400 (Bad Request)} if the operation has already an ID.
     * @throws Exception if the Location URI syntax is incorrect.
     */
    @PostMapping("/operations")
    public ResponseEntity<OperationDTO> createOperation(@RequestBody OperationDTO operationDTO) throws Exception {
        log.debug("REST request to save Operation : {}", operationDTO);
        if (operationDTO.getId() != null) {
            throw new Exception("A new operation cannot already have an ID"+ENTITY_NAME+ "idexists");
        }
        OperationDTO result = operationService.save(operationDTO);
        return ResponseEntity.created(new URI("/api/operations/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /operations} : Updates an existing operation.
     *
     * @param operationDTO the operationDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated operationDTO,
     * or with status {@code 400 (Bad Request)} if the operationDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the operationDTO couldn't be updated.
     * @throws Exception if the Location URI syntax is incorrect.
     */
    @PutMapping("/operations")
    public ResponseEntity<OperationDTO> updateOperation(@RequestBody OperationDTO operationDTO) throws Exception {
        log.debug("REST request to update Operation : {}", operationDTO);
        if (operationDTO.getId() == null) {
            throw new Exception("Invalid id"+ENTITY_NAME+ "idnull");
        }
        OperationDTO result = operationService.save(operationDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, operationDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /operations} : get all the operations.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of operations in body.
     */
    @GetMapping("/operations")
    public ResponseEntity<List<OperationDTO>> getAllOperations(Pageable pageable) {
        log.debug("REST request to get a page of Operations");
        Page<OperationDTO> page = operationService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /operations/:id} : get the "id" operation.
     *
     * @param id the id of the operationDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the operationDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/operations/{id}")
    public ResponseEntity<OperationDTO> getOperation(@PathVariable Long id) {
        log.debug("REST request to get Operation : {}", id);
        Optional<OperationDTO> operationDTO = operationService.findOne(id);
        return ResponseUtil.wrapOrNotFound(operationDTO);
    }

    /**
     * {@code DELETE  /operations/:id} : delete the "id" operation.
     *
     * @param id the id of the operationDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/operations/{id}")
    public ResponseEntity<Void> deleteOperation(@PathVariable Long id) {
        log.debug("REST request to delete Operation : {}", id);
        operationService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
