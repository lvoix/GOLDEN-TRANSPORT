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

import com.zakaria.khobizi.service.StationService;
import com.zakaria.khobizi.service.dto.StationDTO;
import com.zakaria.khobizi.util.HeaderUtil;
import com.zakaria.khobizi.util.PaginationUtil;
import com.zakaria.khobizi.util.ResponseUtil;

/**
 * REST controller for managing {@link com.zakaria.khobizi.domain.Station}.
 */
@RestController
@RequestMapping("/api")
public class StationResource {

    private final Logger log = LoggerFactory.getLogger(StationResource.class);

    private static final String ENTITY_NAME = "station";

    @Value("${clientApp.name}")
    private String applicationName;

    private final StationService stationService;
    @Autowired(required = true)
    public StationResource(StationService stationService) {
        this.stationService = stationService;
    }

    /**
     * {@code POST  /stations} : Create a new station.
     *
     * @param stationDTO the stationDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new stationDTO, or with status {@code 400 (Bad Request)} if the station has already an ID.
     * @throws Exception if the Location URI syntax is incorrect.
     */
    @PostMapping("/stations")
    public ResponseEntity<StationDTO> createStation(@RequestBody StationDTO stationDTO) throws Exception {
        log.debug("REST request to save Station : {}", stationDTO);
        if (stationDTO.getId() != null) {
            throw new Exception("A new station cannot already have an ID"+ENTITY_NAME+ "idexists");
        }
        StationDTO result = stationService.save(stationDTO);
        return ResponseEntity.created(new URI("/api/stations/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /stations} : Updates an existing station.
     *
     * @param stationDTO the stationDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated stationDTO,
     * or with status {@code 400 (Bad Request)} if the stationDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the stationDTO couldn't be updated.
     * @throws Exception if the Location URI syntax is incorrect.
     */
    @PutMapping("/stations")
    public ResponseEntity<StationDTO> updateStation(@RequestBody StationDTO stationDTO) throws Exception {
        log.debug("REST request to update Station : {}", stationDTO);
        if (stationDTO.getId() == null) {
            throw new Exception("Invalid id"+ENTITY_NAME+ "idnull");
        }
        StationDTO result = stationService.save(stationDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, stationDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /stations} : get all the stations.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of stations in body.
     */
    @GetMapping("/stations")
    public ResponseEntity<List<StationDTO>> getAllStations(Pageable pageable) {
        log.debug("REST request to get a page of Stations");
        Page<StationDTO> page = stationService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /stations/:id} : get the "id" station.
     *
     * @param id the id of the stationDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the stationDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/stations/{id}")
    public ResponseEntity<StationDTO> getStation(@PathVariable Long id) {
        log.debug("REST request to get Station : {}", id);
        Optional<StationDTO> stationDTO = stationService.findOne(id);
        return ResponseUtil.wrapOrNotFound(stationDTO);
    }

    /**
     * {@code DELETE  /stations/:id} : delete the "id" station.
     *
     * @param id the id of the stationDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/stations/{id}")
    public ResponseEntity<Void> deleteStation(@PathVariable Long id) {
        log.debug("REST request to delete Station : {}", id);
        stationService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
