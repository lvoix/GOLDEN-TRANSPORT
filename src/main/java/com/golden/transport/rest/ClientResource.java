package com.golden.transport.rest;

import com.golden.transport.domain.Client;
import com.golden.transport.response.ListResponse;
import com.golden.transport.service.ClientService;
import com.golden.transport.service.dto.ClientDTO;
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

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST controller for managing {@link Client}.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ClientResource {

    private final Logger log = LoggerFactory.getLogger(ClientResource.class);

    private static final String ENTITY_NAME = "client";

    @Value("${clientApp.name}")
    private String applicationName;

    private ModelMapper modelMapper = new ModelMapper();

    private final ClientService clientService;


    @Autowired(required = true)
	public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * {@code POST  /clients} : Create a new clients.
     *
     * @param clientDTO the clientDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new clientDTO, or with status {@code 400 (Bad Request)} if the beneficiaire has already an ID.
     * @throws Exception 
     */
    @PostMapping("/clients")
    public ClientDTO createClient(@RequestBody ClientDTO clientDTO) throws Exception {
        log.debug("REST request to save Client : {}", clientDTO);
        if (clientDTO.getId() != null) {
            throw new Exception("A new client cannot already have an ID"+ENTITY_NAME+"idexists");
        }
        ClientDTO result = clientService.save(clientDTO);
        return result;
      /*  return ResponseEntity.created(new URI("/api/beneficiaires/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false,ENTITY_NAME, result.getId().toString()))
            .body(result);*/
    }

    /**
     * {@code PUT  /beneficiaires} : Updates an existing beneficiaire.
     *
     * @param clientDTO the clientDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated clientDTO,
     * or with status {@code 400 (Bad Request)} if the clientDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the clientDTO couldn't be updated.
     * @throws Exception 
     */
    @PutMapping("/clients")
    public ResponseEntity<ClientDTO> updateClient(@RequestBody ClientDTO clientDTO) throws Exception {
        log.debug("REST request to update Client : {}", clientDTO);
        if (clientDTO.getId() == null) {
            throw new Exception("Invalid id"+ENTITY_NAME+ "idnull");
        }
        ClientDTO result = clientService.save(clientDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false,ENTITY_NAME, clientDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /clients} : get all the clients.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of clients in body.
     */
/*
    @GetMapping("/clients")
    public ResponseEntity<List<ClientDTO>> getAllClients(Pageable pageable) {
        log.debug("REST request to get a page of Clients");
        Page<ClientDTO> page = clientService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
*/
    @GetMapping("/clients/all")
    public ListResponse<ClientDTO> getAllClients(Pageable pageable) {
        Pageable wholePage = Pageable.unpaged();
        return new ListResponse<>(clientService.findAll(wholePage).stream()
                .map(client -> modelMapper.map(client, ClientDTO.class)).collect(Collectors.toList()));
    }


    @GetMapping("/clients")
    public ListResponse<ClientDTO> getClientsByUserId(@PathParam("userId") Long userId) {
        return new ListResponse<>(clientService.getClientsByUserId(userId));
    }

    /**
     * {@code GET  /clients/:id} : get the "id" client.
     *
     * @param id the id of the clientDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the clientDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/clients/{id}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable Long id) {
        log.debug("REST request to get Client : {}", id);
        Optional<ClientDTO> clientDTO = clientService.findOne(id);
        return ResponseUtil.wrapOrNotFound(clientDTO);
    }

    /**
     * {@code DELETE  /clients/:id} : delete the "id" clients.
     *
     * @param id the id of the clientDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        log.debug("REST request to delete Client : {}", id);
        clientService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false,ENTITY_NAME, id.toString())).build();
    }
}
