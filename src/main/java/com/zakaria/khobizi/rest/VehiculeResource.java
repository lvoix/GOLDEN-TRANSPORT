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

import com.zakaria.khobizi.service.VehiculeService;
import com.zakaria.khobizi.service.dto.VehiculeDTO;
import com.zakaria.khobizi.util.HeaderUtil;
import com.zakaria.khobizi.util.PaginationUtil;
import com.zakaria.khobizi.util.ResponseUtil;

/**
 * REST controller for managing {@link com.zakaria.khobizi.domain.Vehicule}.
 */
@RestController
@RequestMapping("/api")
public class VehiculeResource {

    private final Logger log = LoggerFactory.getLogger(VehiculeResource.class);

    private static final String ENTITY_NAME = "vehicule";

    @Value("${clientApp.name}")
    private String applicationName;

    private final VehiculeService vehiculeService;
    @Autowired(required = true)
    public VehiculeResource(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    /**
     * {@code POST  /vehicules} : Create a new vehicule.
     *
     * @param vehiculeDTO the vehiculeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new vehiculeDTO, or with status {@code 400 (Bad Request)} if the vehicule has already an ID.
     * @throws Exception if the Location URI syntax is incorrect.
     */
    @PostMapping("/vehicules")
    public ResponseEntity<VehiculeDTO> createVehicule(@RequestBody VehiculeDTO vehiculeDTO) throws Exception {
        log.debug("REST request to save Vehicule : {}", vehiculeDTO);
        if (vehiculeDTO.getId() != null) {
            throw new Exception("A new vehicule cannot already have an ID"+ENTITY_NAME+ "idexists");
        }
        VehiculeDTO result = vehiculeService.save(vehiculeDTO);
        return ResponseEntity.created(new URI("/api/vehicules/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /vehicules} : Updates an existing vehicule.
     *
     * @param vehiculeDTO the vehiculeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated vehiculeDTO,
     * or with status {@code 400 (Bad Request)} if the vehiculeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the vehiculeDTO couldn't be updated.
     * @throws Exception if the Location URI syntax is incorrect.
     */
    @PutMapping("/vehicules")
    public ResponseEntity<VehiculeDTO> updateVehicule(@RequestBody VehiculeDTO vehiculeDTO) throws Exception {
        log.debug("REST request to update Vehicule : {}", vehiculeDTO);
        if (vehiculeDTO.getId() == null) {
            throw new Exception("Invalid id"+ENTITY_NAME+ "idnull");
        }
        VehiculeDTO result = vehiculeService.save(vehiculeDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, vehiculeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /vehicules} : get all the vehicules.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of vehicules in body.
     */
    @GetMapping("/vehicules")
    public ResponseEntity<List<VehiculeDTO>> getAllVehicules(Pageable pageable) {
        log.debug("REST request to get a page of Vehicules");
        Page<VehiculeDTO> page = vehiculeService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /vehicules/:id} : get the "id" vehicule.
     *
     * @param id the id of the vehiculeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the vehiculeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/vehicules/{id}")
    public ResponseEntity<VehiculeDTO> getVehicule(@PathVariable Long id) {
        log.debug("REST request to get Vehicule : {}", id);
        Optional<VehiculeDTO> vehiculeDTO = vehiculeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(vehiculeDTO);
    }

    /**
     * {@code DELETE  /vehicules/:id} : delete the "id" vehicule.
     *
     * @param id the id of the vehiculeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/vehicules/{id}")
    public ResponseEntity<Void> deleteVehicule(@PathVariable Long id) {
        log.debug("REST request to delete Vehicule : {}", id);
        vehiculeService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
