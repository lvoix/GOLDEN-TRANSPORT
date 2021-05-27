//package com.golden.transport.rest;
//
//import java.util.List;
//import java.util.Optional;
//
//import com.golden.transport.domain.Client;
//import com.golden.transport.service.dto.ClientDTO;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import com.golden.transport.service.ClientService;
//import com.golden.transport.util.HeaderUtil;
//import com.golden.transport.util.PaginationUtil;
//import com.golden.transport.util.ResponseUtil;
//
///**
// * REST controller for managing {@link Client}.
// */
//@RestController
//@RequestMapping("/api")
//public class ClientResource {
//
//    private final Logger log = LoggerFactory.getLogger(ClientResource.class);
//
//    private static final String ENTITY_NAME = "beneficiaire";
//
//    @Value("${clientApp.name}")
//    private String applicationName;
//
//
//    private final ClientService clientService;
//
//
//    @Autowired(required = true)
//	public ClientResource(ClientService clientService) {
//        this.clientService = clientService;
//    }
//
//    /**
//     * {@code POST  /beneficiaires} : Create a new beneficiaire.
//     *
//     * @param clientDTO the clientDTO to create.
//     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new clientDTO, or with status {@code 400 (Bad Request)} if the beneficiaire has already an ID.
//     * @throws Exception
//     */
//    @PostMapping("/beneficiaires")
//    public ClientDTO createBeneficiaire(@RequestBody ClientDTO clientDTO) throws Exception {
//        log.debug("REST request to save Client : {}", clientDTO);
//        if (clientDTO.getId() != null) {
//            throw new Exception("A new beneficiaire cannot already have an ID"+ENTITY_NAME+"idexists");
//        }
//        ClientDTO result = clientService.save(clientDTO);
//        return result;
//      /*  return ResponseEntity.created(new URI("/api/beneficiaires/" + result.getId()))
//            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false,ENTITY_NAME, result.getId().toString()))
//            .body(result);*/
//    }
//
//    /**
//     * {@code PUT  /beneficiaires} : Updates an existing beneficiaire.
//     *
//     * @param clientDTO the clientDTO to update.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated clientDTO,
//     * or with status {@code 400 (Bad Request)} if the clientDTO is not valid,
//     * or with status {@code 500 (Internal Server Error)} if the clientDTO couldn't be updated.
//     * @throws Exception
//     */
//    @PutMapping("/beneficiaires")
//    public ResponseEntity<ClientDTO> updateBeneficiaire(@RequestBody ClientDTO clientDTO) throws Exception {
//        log.debug("REST request to update Client : {}", clientDTO);
//        if (clientDTO.getId() == null) {
//            throw new Exception("Invalid id"+ENTITY_NAME+ "idnull");
//        }
//        ClientDTO result = clientService.save(clientDTO);
//        return ResponseEntity.ok()
//            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false,ENTITY_NAME, clientDTO.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * {@code GET  /beneficiaires} : get all the beneficiaires.
//     *
//     * @param pageable the pagination information.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of beneficiaires in body.
//     */
//    @GetMapping("/beneficiaires")
//    public ResponseEntity<List<ClientDTO>> getAllBeneficiaires(Pageable pageable) {
//        log.debug("REST request to get a page of Beneficiaires");
//        Page<ClientDTO> page = clientService.findAll(pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//        return ResponseEntity.ok().headers(headers).body(page.getContent());
//    }
//
//    /**
//     * {@code GET  /beneficiaires/:id} : get the "id" beneficiaire.
//     *
//     * @param id the id of the beneficiaireDTO to retrieve.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the beneficiaireDTO, or with status {@code 404 (Not Found)}.
//     */
//    @GetMapping("/beneficiaires/{id}")
//    public ResponseEntity<ClientDTO> getBeneficiaire(@PathVariable Long id) {
//        log.debug("REST request to get Client : {}", id);
//        Optional<ClientDTO> beneficiaireDTO = clientService.findOne(id);
//        return ResponseUtil.wrapOrNotFound(beneficiaireDTO);
//    }
//
//    /**
//     * {@code DELETE  /beneficiaires/:id} : delete the "id" beneficiaire.
//     *
//     * @param id the id of the beneficiaireDTO to delete.
//     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
//     */
//    @DeleteMapping("/beneficiaires/{id}")
//    public ResponseEntity<Void> deleteBeneficiaire(@PathVariable Long id) {
//        log.debug("REST request to delete Client : {}", id);
//        clientService.delete(id);
//        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false,ENTITY_NAME, id.toString())).build();
//    }
//}
