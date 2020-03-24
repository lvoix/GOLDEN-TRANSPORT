package com.golden.transport.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.golden.transport.domain.Chauffeur;
import com.golden.transport.service.dto.ChauffeurDTO;
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

import com.golden.transport.service.ChauffeurService;
import com.golden.transport.util.HeaderUtil;
import com.golden.transport.util.PaginationUtil;
import com.golden.transport.util.ResponseUtil;

/**
 * REST controller for managing {@link Chauffeur}.
 */
@RestController
@RequestMapping("/api")
public class ChauffeurResource {

    private final Logger log = LoggerFactory.getLogger(ChauffeurResource.class);

    private static final String ENTITY_NAME = "chauffeur";

    @Value("${clientApp.name}")
    private String applicationName;

    private final ChauffeurService chauffeurService;
    
    @Autowired(required = true)
    public ChauffeurResource(ChauffeurService chauffeurService) {
        this.chauffeurService = chauffeurService;
    }

    /**
     * {@code POST  /chauffeurs} : Create a new chauffeur.
     *
     * @param chauffeurDTO the chauffeurDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new chauffeurDTO, or with status {@code 400 (Bad Request)} if the chauffeur has already an ID.
     * @throws Exception 
     */
    @PostMapping("/chauffeurs")
    public ResponseEntity<ChauffeurDTO> createChauffeur(@RequestBody ChauffeurDTO chauffeurDTO) throws Exception {
        log.debug("REST request to save Chauffeur : {}", chauffeurDTO);
        if (chauffeurDTO.getId() != null) {
            throw new Exception("A new chauffeur cannot already have an ID"+ ENTITY_NAME +"idexists");
        }
        ChauffeurDTO result = chauffeurService.save(chauffeurDTO);
        return ResponseEntity.created(new URI("/api/chauffeurs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /chauffeurs} : Updates an existing chauffeur.
     *
     * @param chauffeurDTO the chauffeurDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated chauffeurDTO,
     * or with status {@code 400 (Bad Request)} if the chauffeurDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the chauffeurDTO couldn't be updated.
     * @throws Exception 
     */
    @PutMapping("/chauffeurs")
    public ResponseEntity<ChauffeurDTO> updateChauffeur(@RequestBody ChauffeurDTO chauffeurDTO) throws Exception {
        log.debug("REST request to update Chauffeur : {}", chauffeurDTO);
        if (chauffeurDTO.getId() == null) {
            throw new Exception("Invalid id"+ ENTITY_NAME + "idnull");
        }
        ChauffeurDTO result = chauffeurService.save(chauffeurDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, chauffeurDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /chauffeurs} : get all the chauffeurs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of chauffeurs in body.
     */
    @GetMapping("/chauffeurs")
    public ResponseEntity<List<ChauffeurDTO>> getAllChauffeurs(Pageable pageable) {
        log.debug("REST request to get a page of Chauffeurs");
        Page<ChauffeurDTO> page = chauffeurService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /chauffeurs/:id} : get the "id" chauffeur.
     *
     * @param id the id of the chauffeurDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the chauffeurDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/chauffeurs/{id}")
    public ResponseEntity<ChauffeurDTO> getChauffeur(@PathVariable Long id) {
        log.debug("REST request to get Chauffeur : {}", id);
        Optional<ChauffeurDTO> chauffeurDTO = chauffeurService.findOne(id);
        return ResponseUtil.wrapOrNotFound(chauffeurDTO);
    }

    /**
     * {@code DELETE  /chauffeurs/:id} : delete the "id" chauffeur.
     *
     * @param id the id of the chauffeurDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/chauffeurs/{id}")
    public ResponseEntity<Void> deleteChauffeur(@PathVariable Long id) {
        log.debug("REST request to delete Chauffeur : {}", id);
        chauffeurService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
