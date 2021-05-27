package com.golden.transport.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.golden.transport.domain.Target;
import com.golden.transport.service.dto.TargetDTO;
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

import com.golden.transport.service.TargetService;
import com.golden.transport.util.HeaderUtil;
import com.golden.transport.util.PaginationUtil;
import com.golden.transport.util.ResponseUtil;

/**
 * REST controller for managing
 */
@RestController
@RequestMapping("/api")
public class TargetResource {

    private final Logger log = LoggerFactory.getLogger(TargetResource.class);

    private static final String ENTITY_NAME = "target";

    @Value("${clientApp.name}")
    private String applicationName;

    private final TargetService targetService;
    @Autowired(required = true)
    public TargetResource(TargetService targetService) {
        this.targetService = targetService;
    }

    /**
     * {@code POST  /targets} : Create a new target.
     *
     * @param targetDTO the targetDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new targetDTO, or with status {@code 400 (Bad Request)} if the target has already an ID.
     * @throws Exception if the Location URI syntax is incorrect.
     */
    @PostMapping("/targets")
    public ResponseEntity<TargetDTO> createTarget(@RequestBody TargetDTO targetDTO) throws Exception {
        log.debug("REST request to save Target : {}", targetDTO);
        if (targetDTO.getId() != null) {
            throw new Exception("A new target cannot already have an ID"+ENTITY_NAME+ "idexists");
        }
        TargetDTO result = targetService.save(targetDTO);
        return ResponseEntity.created(new URI("/api/targets/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /targets} : Updates an existing target.
     *
     * @param targetDTO the targetDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated targetDTO,
     * or with status {@code 400 (Bad Request)} if the targetDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the targetDTO couldn't be updated.
     * @throws Exception if the Location URI syntax is incorrect.
     */
    @PutMapping("/targets")
    public ResponseEntity<TargetDTO> updatetarget(@RequestBody TargetDTO targetDTO) throws Exception {
        log.debug("REST request to update Target : {}", targetDTO);
        if (targetDTO.getId() == null) {
            throw new Exception("Invalid id"+ENTITY_NAME+ "idnull");
        }
        TargetDTO result = targetService.save(targetDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, targetDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /targets} : get all the targets.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of targets in body.
     */
    @GetMapping("/targets")
    public ResponseEntity<List<TargetDTO>> getAllTargets(Pageable pageable) {
        log.debug("REST request to get a page of targets");
        Page<TargetDTO> page = targetService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /targets/:id} : get the "id" target.
     *
     * @param id the id of the targetDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the targetDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/targets/{id}")
    public ResponseEntity<TargetDTO> getTarget(@PathVariable Long id) {
        log.debug("REST request to get Target : {}", id);
        Optional<TargetDTO> targetDTO = targetService.findOne(id);
        return ResponseUtil.wrapOrNotFound(targetDTO);
    }

    /**
     * {@code DELETE  /targets/:id} : delete the "id" target.
     *
     * @param id the id of the targetDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/targets/{id}")
    public ResponseEntity<Void> deleteTarget(@PathVariable Long id) {
        log.debug("REST request to delete Target : {}", id);
        targetService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
