package com.golden.transport.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.golden.transport.domain.Beneficiaire;
import com.golden.transport.service.dto.BeneficiaireDTO;
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

import com.golden.transport.service.BeneficiaireService;
import com.golden.transport.util.HeaderUtil;
import com.golden.transport.util.PaginationUtil;
import com.golden.transport.util.ResponseUtil;

/**
 * REST controller for managing {@link Beneficiaire}.
 */
@RestController
@RequestMapping("/api")
public class BeneficiaireResource {

    private final Logger log = LoggerFactory.getLogger(BeneficiaireResource.class);

    private static final String ENTITY_NAME = "beneficiaire";

    @Value("${clientApp.name}")
    private String applicationName;
    
    
    private final  BeneficiaireService beneficiaireService;

    
    @Autowired(required = true)
	public BeneficiaireResource(BeneficiaireService beneficiaireService) {
        this.beneficiaireService = beneficiaireService;
    }

    /**
     * {@code POST  /beneficiaires} : Create a new beneficiaire.
     *
     * @param beneficiaireDTO the beneficiaireDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new beneficiaireDTO, or with status {@code 400 (Bad Request)} if the beneficiaire has already an ID.
     * @throws Exception 
     */
    @PostMapping("/beneficiaires")
    public ResponseEntity<BeneficiaireDTO> createBeneficiaire(@RequestBody BeneficiaireDTO beneficiaireDTO) throws Exception {
        log.debug("REST request to save Beneficiaire : {}", beneficiaireDTO);
        if (beneficiaireDTO.getId() != null) {
            throw new Exception("A new beneficiaire cannot already have an ID"+ENTITY_NAME+"idexists");
        }
        BeneficiaireDTO result = beneficiaireService.save(beneficiaireDTO);
        return ResponseEntity.created(new URI("/api/beneficiaires/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false,ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /beneficiaires} : Updates an existing beneficiaire.
     *
     * @param beneficiaireDTO the beneficiaireDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated beneficiaireDTO,
     * or with status {@code 400 (Bad Request)} if the beneficiaireDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the beneficiaireDTO couldn't be updated.
     * @throws Exception 
     */
    @PutMapping("/beneficiaires")
    public ResponseEntity<BeneficiaireDTO> updateBeneficiaire(@RequestBody BeneficiaireDTO beneficiaireDTO) throws Exception {
        log.debug("REST request to update Beneficiaire : {}", beneficiaireDTO);
        if (beneficiaireDTO.getId() == null) {
            throw new Exception("Invalid id"+ENTITY_NAME+ "idnull");
        }
        BeneficiaireDTO result = beneficiaireService.save(beneficiaireDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false,ENTITY_NAME, beneficiaireDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /beneficiaires} : get all the beneficiaires.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of beneficiaires in body.
     */
    @GetMapping("/beneficiaires")
    public ResponseEntity<List<BeneficiaireDTO>> getAllBeneficiaires(Pageable pageable) {
        log.debug("REST request to get a page of Beneficiaires");
        Page<BeneficiaireDTO> page = beneficiaireService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /beneficiaires/:id} : get the "id" beneficiaire.
     *
     * @param id the id of the beneficiaireDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the beneficiaireDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/beneficiaires/{id}")
    public ResponseEntity<BeneficiaireDTO> getBeneficiaire(@PathVariable Long id) {
        log.debug("REST request to get Beneficiaire : {}", id);
        Optional<BeneficiaireDTO> beneficiaireDTO = beneficiaireService.findOne(id);
        return ResponseUtil.wrapOrNotFound(beneficiaireDTO);
    }

    /**
     * {@code DELETE  /beneficiaires/:id} : delete the "id" beneficiaire.
     *
     * @param id the id of the beneficiaireDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/beneficiaires/{id}")
    public ResponseEntity<Void> deleteBeneficiaire(@PathVariable Long id) {
        log.debug("REST request to delete Beneficiaire : {}", id);
        beneficiaireService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false,ENTITY_NAME, id.toString())).build();
    }
}
