package com.golden.transport.rest;

import com.golden.transport.domain.Contact;
import com.golden.transport.service.ContactService;
import com.golden.transport.service.dto.ContactDTO;
import com.golden.transport.util.HeaderUtil;
import com.golden.transport.util.PaginationUtil;
import com.golden.transport.util.ResponseUtil;
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

/**
 * REST controller for managing {@link Contact}.
 */
@RestController
@RequestMapping("/api")
public class ContactResource {

    private final Logger log = LoggerFactory.getLogger(ContactResource.class);

    private static final String ENTITY_NAME = "contact";

    @Value("${clientApp.name}")
    private String applicationName;
    
    
    private final  ContactService contactService;

    
    @Autowired(required = true)
	public ContactResource(ContactService contactService) {
        this.contactService = contactService;
    }

    /**
     * {@code POST  /Contacts} : Create a new Contact.
     *
     * @param ContactDTO the ContactDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new ContactDTO, or with status {@code 400 (Bad Request)} if the Contact has already an ID.
     * @throws Exception 
     */
    @PostMapping("/contacts")
    public ResponseEntity<ContactDTO> createContact(@RequestBody ContactDTO contactDTO) throws Exception {
        log.debug("REST request to save Contact : {}", contactDTO);
        if (contactDTO.getId() != null) {
            throw new Exception("A new Contact cannot already have an ID"+ENTITY_NAME+"idexists");
        }
        ContactDTO result = contactService.save(contactDTO);
        return ResponseEntity.created(new URI("/api/contacts/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false,ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /Contacts} : Updates an existing Contact.
     *
     * @param ContactDTO the ContactDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated ContactDTO,
     * or with status {@code 400 (Bad Request)} if the ContactDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the ContactDTO couldn't be updated.
     * @throws Exception 
     */
    @PutMapping("/contacts")
    public ResponseEntity<ContactDTO> updateContact(@RequestBody ContactDTO contactDTO) throws Exception {
        log.debug("REST request to update Contact : {}", contactDTO);
        if (contactDTO.getId() == null) {
            throw new Exception("Invalid id"+ENTITY_NAME+ "idnull");
        }
        ContactDTO result = contactService.save(contactDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false,ENTITY_NAME, contactDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /Contacts} : get all the Contacts.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of Contacts in body.
     */
    @GetMapping("/contacts")
    public ResponseEntity<List<ContactDTO>> getAllContacts(Pageable pageable) {
        log.debug("REST request to get a page of Contacts");
        Page<ContactDTO> page = contactService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /Contacts/:id} : get the "id" Contact.
     *
     * @param id the id of the ContactDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the ContactDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/contacts/{id}")
    public ResponseEntity<ContactDTO> getContact(@PathVariable Long id) {
        log.debug("REST request to get Contact : {}", id);
        Optional<ContactDTO> contactDTO = contactService.findOne(id);
        return ResponseUtil.wrapOrNotFound(contactDTO);
    }

    /**
     * {@code DELETE  /Contacts/:id} : delete the "id" Contact.
     *
     * @param id the id of the ContactDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/contacts/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        log.debug("REST request to delete Contact : {}", id);
        contactService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false,ENTITY_NAME, id.toString())).build();
    }
}
