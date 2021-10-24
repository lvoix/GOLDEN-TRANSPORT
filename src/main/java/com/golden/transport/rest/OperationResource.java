package com.golden.transport.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.golden.transport.domain.Operation;
import com.golden.transport.response.ListResponse;
import com.golden.transport.response.SingleResponse;
import com.golden.transport.service.dto.ClientDTO;
import com.golden.transport.service.dto.OperationADDDTO;
import com.golden.transport.service.dto.operationTiersAddDTO;
import com.golden.transport.service.dto.OperationDTO;
import com.golden.transport.service.dto.OperationUpdateDTO;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.golden.transport.service.OperationService;
import com.golden.transport.util.HeaderUtil;
import com.golden.transport.util.PaginationUtil;
import com.golden.transport.util.ResponseUtil;

import javax.websocket.server.PathParam;

/**
 * REST controller for managing {@link Operation}.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class OperationResource {

    private final Logger log = LoggerFactory.getLogger(OperationResource.class);

    private static final String ENTITY_NAME = "operation";

    @Value("${clientApp.name}")
    private String applicationName;
    private ModelMapper modelMapper = new ModelMapper();
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
/*    @PostMapping("/operations")
    public ResponseEntity<OperationDTO> createOperation(@RequestBody OperationADDDTO operationDTO) throws Exception {
        log.debug("REST request to save Operation : {}", operationDTO);
       if (operationDTO.getId() != null) {
            throw new Exception("A new operation cannot already have an ID"+ENTITY_NAME+ "idexists");
        }
        OperationDTO result = operationService.save(operationDTO);
        return ResponseEntity.created(new URI("/api/operations/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }*/
   @PostMapping("/operations")
    public ResponseEntity<OperationDTO> createOperation(@RequestBody operationTiersAddDTO operationDTO) throws Exception {
        log.debug("REST request to save Operation : {}", operationDTO);
       if (operationDTO.getId() != null) {
            throw new Exception("A new operation cannot already have an ID"+ENTITY_NAME+ "idexists");
        }
        OperationDTO result = operationService.save(null);
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
    public ResponseEntity<OperationDTO> updateOperation(@RequestBody OperationADDDTO operationDTO) throws Exception {
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

/*
    public ResponseEntity<List<OperationDTO>> getAllOperations(Pageable pageable) {
        log.debug("REST request to get a page of Operations");
        Page<OperationDTO> page = operationService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        ResponseEntity<List<OperationDTO>> res = ResponseEntity.ok().headers(headers).body(page.getContent());
        return res ;
    }
*/
    @GetMapping("/operations")
    public ListResponse<OperationDTO> getAllOperations(Pageable pageable) {
        return new ListResponse<>(operationService.findAll(pageable).stream()
                .map(operation -> modelMapper.map(operation, OperationDTO.class)).collect(Collectors.toList()));
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


    @GetMapping(value = "/operations/operation")
    public SingleResponse<OperationDTO> getOperation1(@PathParam("operationId") Long operationId){
        return new SingleResponse<>(operationService.getOperation1(operationId));
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
