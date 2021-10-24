package com.golden.transport.rest;

import com.golden.transport.domain.Conducteur;
import com.golden.transport.response.ListResponse;
import com.golden.transport.service.ConducteurService;
import com.golden.transport.service.dto.ConducteurDTO;
import com.golden.transport.service.dto.criteresRechercheCondDTO;
import com.golden.transport.util.HeaderUtil;
import com.golden.transport.util.PaginationUtil;
import com.golden.transport.util.ResponseUtil;
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

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST controller for managing {@link Conducteur}.
 */
@RestController
@RequestMapping("/api")
public class ConducteurResource {

    private final Logger log = LoggerFactory.getLogger(ConducteurResource.class);

    private static final String ENTITY_NAME = "conducteur";

    @Value("${clientApp.name}")
    private String applicationName;
    private ModelMapper modelMapper = new ModelMapper();
    private final ConducteurService conducteurService;
    
    @Autowired(required = true)
    public ConducteurResource(ConducteurService conducteurService) {
        this.conducteurService = conducteurService;
    }

    /**
     * {@code POST  /conducteurs} : Create a new conducteur.
     *
     * @param conducteurDTO the conducteurDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new conducteurDTO, or with status {@code 400 (Bad Request)} if the chauffeur has already an ID.
     * @throws Exception 
     */
    @PostMapping("/conducteurs")
    public ResponseEntity<ConducteurDTO> createChauffeur(@RequestBody ConducteurDTO conducteurDTO) throws Exception {
        log.debug("REST request to save conducteur : {}", conducteurDTO);
        if (conducteurDTO.getId() != null) {
            throw new Exception("A new conducteur cannot already have an ID"+ ENTITY_NAME +"idexists");
        }
        ConducteurDTO result = conducteurService.save(conducteurDTO);
        return ResponseEntity.created(new URI("/api/conducteurs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /conducteurs} : Updates an existing conducteur.
     *
     * @param conducteurDTO the conducteurDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated conducteurDTO,
     * or with status {@code 400 (Bad Request)} if the conducteurDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the conducteurDTO couldn't be updated.
     * @throws Exception 
     */
    @PutMapping("/conducteurs")
    public ResponseEntity<ConducteurDTO> updateChauffeur(@RequestBody ConducteurDTO conducteurDTO) throws Exception {
        log.debug("REST request to update conducteur : {}", conducteurDTO);
        if (conducteurDTO.getId() == null) {
            throw new Exception("Invalid id"+ ENTITY_NAME + "idnull");
        }
        ConducteurDTO result = conducteurService.save(conducteurDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, conducteurDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /conducteurs} : get all the conducteurs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of chauffeurs in body.
     @GetMapping("/conducteurs")
     public ResponseEntity<List<ConducteurDTO>> getAllConducteurs(Pageable pageable) {
     log.debug("REST request to get a page of conducteurs");
     Page<ConducteurDTO> page = conducteurService.findAll(pageable);
     HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
     return ResponseEntity.ok().headers(headers).body(page.getContent());
     }
     */
/*
    @GetMapping("/conducteurs")
    public Page<ConducteurDTO> getAllConducteurs(@RequestParam(defaultValue = "0")  int page,
                                                 @RequestParam(defaultValue = "10") int size,
                                                 @RequestParam(defaultValue = "id") String sortBy) {
        log.debug("REST request to get a page of conducteurs");
        Page<ConducteurDTO> resultPage = conducteurService.findAll(page, size, sortBy);
        if (page > resultPage.getTotalPages()) {
            log.debug("REST request to Exception");

        }
        return resultPage;
    }
*/


    @GetMapping("/conducteurs/all")
    public ListResponse<ConducteurDTO> getAllConducteurs(Pageable pageable) {
        Pageable wholePage = Pageable.unpaged();
        return new ListResponse<>(conducteurService.findAll(wholePage).stream()
                .map(conducteur -> modelMapper.map(conducteur, ConducteurDTO.class)).collect(Collectors.toList()));
    }


    @GetMapping("/conducteurs")
    public ResponseEntity<List<ConducteurDTO>> getConducteursAll(Pageable pageable) {
        log.debug("REST request to get a page of Operations");
        Page<ConducteurDTO> page = conducteurService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        ResponseEntity<List<ConducteurDTO>> res = ResponseEntity.ok().headers(headers).body(page.getContent());
        return res ;
    }
/*    @GetMapping("/conducteurs")
    public ListResponse<ConducteurDTO> getAllOperations(@RequestParam(defaultValue = "0")  int page,
                                                        @RequestParam(defaultValue = "10") int size,
                                                        @RequestParam(defaultValue = "id") String sortBy) {
        return new ListResponse<>(conducteurService.findAll(page, size, sortBy).stream()
                .map(operation -> modelMapper.map(operation, ConducteurDTO.class)).collect(Collectors.toList()));
    }*/

    /**
     * {@code GET  /conducteurs/:id} : get the "id" conducteur.
     *
     * @param id the id of the conducteurDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the conducteurDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/conducteurs/conducteur")
    public ResponseEntity<ConducteurDTO> getConducteurs(@RequestParam(defaultValue = "id")  String id) {
        log.debug("REST request to get Chauffeur : {}", id);
        long idc = Long.valueOf(id).longValue();
        Optional<ConducteurDTO> chauffeurDTO = conducteurService.findOne(idc);
        return ResponseUtil.wrapOrNotFound(chauffeurDTO);
    }

    @PostMapping("/conducteurs/recherchecritere")
    public ResponseEntity<ConducteurDTO> getConducteur(@RequestBody criteresRechercheCondDTO criteresRecherchecondDTO) {
        log.debug("REST request to get Chauffeur : {}", criteresRecherchecondDTO);
        //long idc = criteresRecherchecondDTO.getId();
        Optional<ConducteurDTO> chauffeurDTO = conducteurService.findOneByCritere(criteresRecherchecondDTO);
        return ResponseUtil.wrapOrNotFound(chauffeurDTO);
    }


    /**
     * {@code DELETE  /conducteurs/:id} : delete the "id" conducteur.
     *
     * @param id the id of the conducteursDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/conducteurs")
    public ResponseEntity<Void> deleteConducteur( @RequestParam(defaultValue = "id") String id) {
        log.debug("REST request to delete conducteur : {}", id);
        long idc = Long.valueOf(id).longValue();
        conducteurService.delete(idc);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
