package com.golden.transport.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.golden.transport.domain.Entite;
import com.golden.transport.service.dto.EntiteDTO;
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

import com.golden.transport.service.EntiteService;
import com.golden.transport.util.HeaderUtil;
import com.golden.transport.util.PaginationUtil;
import com.golden.transport.util.ResponseUtil;

/**
 * REST controller for managing {@link Entite}.
 */
@RestController
@RequestMapping("/api")
public class EntiteResource {

    private final Logger log = LoggerFactory.getLogger(EntiteResource.class);

    private static final String ENTITY_NAME = "entite";

    @Value("${clientApp.name}")
    private String applicationName;

    private final EntiteService entiteService;
    @Autowired(required = true)
    public EntiteResource(EntiteService entiteService) {
        this.entiteService = entiteService;
    }

    /**
     * {@code POST  /entites} : Create a new entite.
     *
     * @param entiteDTO the entiteDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new entiteDTO, or with status {@code 400 (Bad Request)} if the entite has already an ID.
     * @throws Exception if the Location URI syntax is incorrect.
     */
    @PostMapping("/entites")
    public ResponseEntity<EntiteDTO> createEntite(@RequestBody EntiteDTO entiteDTO) throws Exception {
        log.debug("REST request to save entite : {}", entiteDTO);
        if (entiteDTO.getId() != null) {
            throw new Exception("A new entite cannot already have an ID"+ENTITY_NAME+ "idexists");
        }
        EntiteDTO result = entiteService.save(entiteDTO);
        return ResponseEntity.created(new URI("/api/entites/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /entites} : Updates an existing entite.
     *
     * @param entiteDTO the entiteDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated entiteDTO,
     * or with status {@code 400 (Bad Request)} if the entiteDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the entiteDTO couldn't be updated.
     * @throws Exception if the Location URI syntax is incorrect.
     */
    @PutMapping("/entites")
    public ResponseEntity<EntiteDTO> updateEntite(@RequestBody EntiteDTO entiteDTO) throws Exception {
        log.debug("REST request to update entite : {}", entiteDTO);
        if (entiteDTO.getId() == null) {
            throw new Exception("Invalid id"+ENTITY_NAME+ "idnull");
        }
        EntiteDTO result = entiteService.save(entiteDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, entiteDTO.getId().toString()))
            .body(result);
    }

    /**
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of entites in body.
     */
    @GetMapping("/entites")
    public ResponseEntity<List<EntiteDTO>> getAllEntites(Pageable pageable) {
        log.debug("REST request to get a page of entites");
        Page<EntiteDTO> page = entiteService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /entites/:id} : get the "id" entite.
     *
     * @param id the id of the entiteDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the entiteDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/entites/{id}")
    public ResponseEntity<EntiteDTO> getEntite(@PathVariable Long id) {
        log.debug("REST request to get entite : {}", id);
        Optional<EntiteDTO> entiteDTO = entiteService.findOne(id);
        return ResponseUtil.wrapOrNotFound(entiteDTO);
    }

    /**
     * {@code DELETE  /entites/:id} : delete the "id" entite.
     *
     * @param id the id of the entiteDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/entites/{id}")
    public ResponseEntity<Void> deleteEntite(@PathVariable Long id) {
        log.debug("REST request to delete entite : {}", id);
        entiteService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
