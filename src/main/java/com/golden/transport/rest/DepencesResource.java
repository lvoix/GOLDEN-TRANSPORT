package com.golden.transport.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import com.golden.transport.domain.Depences;
import com.golden.transport.service.dto.DepencesDTO;
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

import com.golden.transport.service.DepencesService;
import com.golden.transport.util.HeaderUtil;
import com.golden.transport.util.PaginationUtil;
import com.golden.transport.util.ResponseUtil;

/**
 * REST controller for managing {@link Depences}.
 */
@RestController
@RequestMapping("/api")
public class DepencesResource {

    private final Logger log = LoggerFactory.getLogger(DepencesResource.class);

    private static final String ENTITY_NAME = "depences";

    @Value("${clientApp.name}")
    private String applicationName;

    private final DepencesService depencesService;
    
    @Autowired(required = true)
    public DepencesResource(DepencesService depencesService) {
        this.depencesService = depencesService;
    }

    /**
     * {@code POST  /depences} : Create a new depences.
     *
     * @param depencesDTO the depencesDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new depencesDTO, or with status {@code 400 (Bad Request)} if the depences has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/depences")
    public ResponseEntity<DepencesDTO> createDepences(@RequestBody DepencesDTO depencesDTO) throws Exception {
        log.debug("REST request to save Depences : {}", depencesDTO);
        if (depencesDTO.getId() != null) {
            throw new Exception("A new depences cannot already have an ID"+ENTITY_NAME+ "idexists");
        }
        DepencesDTO result = depencesService.save(depencesDTO);
        return ResponseEntity.created(new URI("/api/depences/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }
    @PostMapping("/depencesall")
    public Boolean saveAllDepences(@RequestBody List<DepencesDTO>  depencesDTOs) throws Exception {
        log.debug("REST request to save Depences : {}", depencesDTOs);
        Boolean result = depencesService.saveAll(depencesDTOs);
        return true;
    }

    /**
     * {@code PUT  /depences} : Updates an existing depences.
     *
     * @param depencesDTO the depencesDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated depencesDTO,
     * or with status {@code 400 (Bad Request)} if the depencesDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the depencesDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/depences")
    public ResponseEntity<DepencesDTO> updateDepences(@RequestBody DepencesDTO depencesDTO) throws Exception {
        log.debug("REST request to update Depences : {}", depencesDTO);
        if (depencesDTO.getId() == null) {
            throw new Exception("Invalid id"+ENTITY_NAME+ "idnull");
        }
        DepencesDTO result = depencesService.save(depencesDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, depencesDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /depences} : get all the depences.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of depences in body.
     */
    @GetMapping("/depences")
    public ResponseEntity<List<DepencesDTO>> getAllDepences(Pageable pageable) {
        log.debug("REST request to get a page of Depences");
        Page<DepencesDTO> page = depencesService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /depences/:id} : get the "id" depences.
     *
     * @param id the id of the depencesDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the depencesDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/depences/{id}")
    public ResponseEntity<DepencesDTO> getDepences(@PathVariable Long id) {
        log.debug("REST request to get Depences : {}", id);
        Optional<DepencesDTO> depencesDTO = depencesService.findOne(id);
        return ResponseUtil.wrapOrNotFound(depencesDTO);
    }

    /**
     * {@code DELETE  /depences/:id} : delete the "id" depences.
     *
     * @param id the id of the depencesDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/depences/{id}")
    public ResponseEntity<Void> deleteDepences(@PathVariable Long id) {
        log.debug("REST request to delete Depences : {}", id);
        depencesService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
