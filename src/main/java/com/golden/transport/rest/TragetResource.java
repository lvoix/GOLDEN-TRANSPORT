package com.golden.transport.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.golden.transport.domain.Traget;
import com.golden.transport.service.dto.TragetDTO;
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

import com.golden.transport.service.TragetService;
import com.golden.transport.util.HeaderUtil;
import com.golden.transport.util.PaginationUtil;
import com.golden.transport.util.ResponseUtil;

/**
 * REST controller for managing {@link Traget}.
 */
@RestController
@RequestMapping("/api")
public class TragetResource {

    private final Logger log = LoggerFactory.getLogger(TragetResource.class);

    private static final String ENTITY_NAME = "traget";

    @Value("${clientApp.name}")
    private String applicationName;

    private final TragetService tragetService;
    @Autowired(required = true)
    public TragetResource(TragetService tragetService) {
        this.tragetService = tragetService;
    }

    /**
     * {@code POST  /tragets} : Create a new traget.
     *
     * @param tragetDTO the tragetDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new tragetDTO, or with status {@code 400 (Bad Request)} if the traget has already an ID.
     * @throws Exception if the Location URI syntax is incorrect.
     */
    @PostMapping("/tragets")
    public ResponseEntity<TragetDTO> createTraget(@RequestBody TragetDTO tragetDTO) throws Exception {
        log.debug("REST request to save Traget : {}", tragetDTO);
        if (tragetDTO.getId() != null) {
            throw new Exception("A new traget cannot already have an ID"+ENTITY_NAME+ "idexists");
        }
        TragetDTO result = tragetService.save(tragetDTO);
        return ResponseEntity.created(new URI("/api/tragets/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /tragets} : Updates an existing traget.
     *
     * @param tragetDTO the tragetDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated tragetDTO,
     * or with status {@code 400 (Bad Request)} if the tragetDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the tragetDTO couldn't be updated.
     * @throws Exception if the Location URI syntax is incorrect.
     */
    @PutMapping("/tragets")
    public ResponseEntity<TragetDTO> updateTraget(@RequestBody TragetDTO tragetDTO) throws Exception {
        log.debug("REST request to update Traget : {}", tragetDTO);
        if (tragetDTO.getId() == null) {
            throw new Exception("Invalid id"+ENTITY_NAME+ "idnull");
        }
        TragetDTO result = tragetService.save(tragetDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, tragetDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /tragets} : get all the tragets.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of tragets in body.
     */
    @GetMapping("/tragets")
    public ResponseEntity<List<TragetDTO>> getAllTragets(Pageable pageable) {
        log.debug("REST request to get a page of Tragets");
        Page<TragetDTO> page = tragetService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /tragets/:id} : get the "id" traget.
     *
     * @param id the id of the tragetDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the tragetDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/tragets/{id}")
    public ResponseEntity<TragetDTO> getTraget(@PathVariable Long id) {
        log.debug("REST request to get Traget : {}", id);
        Optional<TragetDTO> tragetDTO = tragetService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tragetDTO);
    }

    /**
     * {@code DELETE  /tragets/:id} : delete the "id" traget.
     *
     * @param id the id of the tragetDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/tragets/{id}")
    public ResponseEntity<Void> deleteTraget(@PathVariable Long id) {
        log.debug("REST request to delete Traget : {}", id);
        tragetService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
