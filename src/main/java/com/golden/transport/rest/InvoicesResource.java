package com.golden.transport.rest;

import com.golden.transport.domain.Invoice;
import com.golden.transport.repository.InvoiceRepository;
import com.golden.transport.service.InvoicesService;
import com.golden.transport.service.dto.InvoicesDTO;
import com.golden.transport.service.dto.criteresRechercheDTO;
import com.golden.transport.util.HeaderUtil;
import com.golden.transport.util.PaginationUtil;
import com.golden.transport.util.ResponseUtil;
import com.golden.transport.util.service.Utilservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.query.Jpa21Utils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.awt.print.Book;
import java.net.URI;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link }.
 */
@RestController
@RequestMapping("/api")
public class InvoicesResource {

    private final Logger log = LoggerFactory.getLogger(InvoicesResource.class);

    private static final String ENTITY_NAME = "invoices";

    @Value("${clientApp.name}")
    private String applicationName;

    private final InvoicesService invoicesService;

    @Autowired
    protected Utilservice utilService;

    @Autowired
    private final InvoiceRepository invoiceRepository;

    @Autowired(required = true)
    public InvoicesResource(InvoicesService invoicesservice, InvoiceRepository invoiceRepository) {
        this.invoicesService = invoicesservice;
        this.invoiceRepository = invoiceRepository;
    }

    /**
     * {@code POST  /operations} : Create a new invoices.
     *
     * @param invoicesDTO the operationDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new operationDTO, or with status {@code 400 (Bad Request)} if the operation has already an ID.
     * @throws Exception if the Location URI syntax is incorrect.
     */
    @PostMapping("/invoices")
    public ResponseEntity<InvoicesDTO> createInvoice(@RequestBody InvoicesDTO invoicesDTO) throws Exception {
        log.debug("REST request to save invoices : {}", invoicesDTO);
       if (invoicesDTO.getId() != null) {
            throw new Exception("A new invoices cannot already have an ID"+ENTITY_NAME+ "idexists");
        }
        if(invoicesDTO.getRef()==null){
            invoicesDTO.setRef(utilService.generateRandomSequence());
        }
        invoicesDTO.setDateCreation(new Date());
        invoicesDTO.setPending(false);
        invoicesDTO.setReceived(false);
        invoicesDTO.setTravelCosts(false);

        InvoicesDTO result = invoicesService.save(invoicesDTO);
        return ResponseEntity.created(new URI("/api/operations/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /invoices} : Updates an existing operation.
     *
     * @param invoicesDTO the invoicesDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated invoicesDTO,
     * or with status {@code 400 (Bad Request)} if the invoicesDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the invoicesDTO couldn't be updated.
     * @throws Exception if the Location URI syntax is incorrect.
     */
    @PutMapping("/invoices")
    public ResponseEntity<InvoicesDTO> updateInvoices(@RequestBody InvoicesDTO invoicesDTO) throws Exception {
        log.debug("REST request to update invoices : {}", invoicesDTO);
        if (invoicesDTO.getId() == null) {
            throw new Exception("Invalid id"+ENTITY_NAME+ "idnull");
        }
        InvoicesDTO result = invoicesService.save(invoicesDTO);

        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, invoicesDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /invoices} : get all the invoices.
     *
     * @param
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of invoices in body.
     */

    @GetMapping("/invoices")
    public ResponseEntity<List<InvoicesDTO>> getAllInvoices(Pageable pageable) {
        log.debug("REST request to get a page of invoices");
        Page <InvoicesDTO> page = invoicesService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        ResponseEntity<List<InvoicesDTO>> res = ResponseEntity.ok().headers(headers).body(page.getContent());
        return res ;
    }
/*    @GetMapping("/invoices/dates")
    public ResponseEntity<List<InvoicesDTO>> getAllInvoicesByDates(@RequestParam(value = "date1") String date1, @RequestParam(value = "date2") String date2,Pageable pageable) {
        log.debug("REST request to get a page of invoices");
        ResponseEntity<List<InvoicesDTO>> res = null;
        try {
            Date cdate1=new SimpleDateFormat("yyyy-MM-dd").parse(date1);
            Date cdate2=new SimpleDateFormat("yyyy-MM-dd").parse(date2);
            Page <InvoicesDTO> page = invoicesService.findAllByDates(cdate1, cdate2,pageable);
            HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
            res = ResponseEntity.ok().headers(headers).body(page.getContent());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return res ;

    }*/
    @PersistenceContext
    EntityManager entityManager;
    @PostMapping("/invoices/criteresRecherche")
    public ResponseEntity<List<InvoicesDTO>> getAllInvoicesByCriteres(@RequestBody criteresRechercheDTO criteresRecherche, Pageable pageable) {
        log.debug("REST request to get a page of invoices");
        ResponseEntity<List<InvoicesDTO>> res = null;
        Page <InvoicesDTO> page = null;
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Invoice> cq = cb.createQuery(Invoice.class);

        Root<Invoice> invoiceRoot = cq.from(Invoice.class);
        Predicate authorNamePredicate = cb.equal(invoiceRoot.get("beneficiaire"),criteresRecherche.getcBeneficiaire() );
       // Predicate titlePredicate = cb.like(book.get("title"), "%" + title + "%");
        cq.where(authorNamePredicate);

        TypedQuery<Invoice> query = entityManager.createQuery(cq);
        List<Invoice> invoices = query.getResultList();
        //Date cdate1=new SimpleDateFormat("yyyy-MM-dd").parse(criteresRecherche.getDateDebut());
        //Date cdate2=new SimpleDateFormat("yyyy-MM-dd").parse(criteresRecherche.getDateFin());
       /* if(criteresRecherche != null && criteresRecherche.getDateDebut() != null && criteresRecherche.getDateFin() != null) {
            if(criteresRecherche.getBolDF() == true) {
                if(criteresRecherche.getcClient()!= null && criteresRecherche.getcBeneficiaire() != null){
                    // all criteres
                    page = invoicesService.findAllByAll(criteresRecherche.getDateDebut(), criteresRecherche.getDateFin(),criteresRecherche.getcClient(),criteresRecherche.getcBeneficiaire(),  pageable);
                }else{
                    if(criteresRecherche.getcClient()!= null || criteresRecherche.getcBeneficiaire() != null){
                        if(criteresRecherche.getcClient()!= null){
                            // all criters sauf le beneficiaire
                            page = invoicesService.findAllByClient(criteresRecherche.getDateDebut(), criteresRecherche.getDateFin(),criteresRecherche.getcClient(), pageable);

                        }else{
                            // all criters sauf le client
                            page = invoicesService.findAllByEntite(criteresRecherche.getDateDebut(), criteresRecherche.getDateFin(), criteresRecherche.getcBeneficiaire(), pageable);
                        }

                    }else{
                        // client null et beneficiaire null
                        page = invoicesService.findAllByBDates(criteresRecherche.getDateDebut(), criteresRecherche.getDateFin(), pageable);
                    }
                }
            }else{
                if(criteresRecherche.getBolDC() == true){
                    page = invoicesService.findAllByCDates(criteresRecherche.getDateDebut(), criteresRecherche.getDateFin(), pageable);
                }
            }

        }else{
            if(criteresRecherche.getcClient()!= null && criteresRecherche.getcBeneficiaire() != null){
                // all criteres
                page = invoicesService.findAllByCB(criteresRecherche.getcClient(),criteresRecherche.getcBeneficiaire(),  pageable);
            }else{
                if(criteresRecherche.getcClient()!= null || criteresRecherche.getcBeneficiaire() != null){
                    if(criteresRecherche.getcClient()!= null){
                        // by le client
                        page = invoicesService.findByClient(criteresRecherche.getcClient(), pageable);

                    }else{
                        // by beneficiare
                        page = invoicesService.findByEntite(criteresRecherche.getcBeneficiaire(), pageable);
                    }

                }else{
                    // all null (client null et beneficiaire null)
                    page = invoicesService.findAll(pageable);
                }
        }*/
        page = invoicesService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        res = ResponseEntity.ok().headers(headers).body(page.getContent());
        return res;
    }


  /*  @GetMapping("/invoices")
    public ResponseEntity<List<Invoice>>getAllInvoices() {
        return ResponseEntity.ok(invoiceRepository.findAll());
    }*/

    /**
     * {@code GET  /invoices/:id} : get the "id" invoices.
     *
     * @param id the id of the invoicesDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the invoicesDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/invoices/{id}")
    public ResponseEntity<InvoicesDTO> getInvoices(@PathVariable String id) {
        log.debug("REST request to get invoices : {}", id);
        Optional<InvoicesDTO> invoicesDTO = invoicesService.findOne(id);
        return ResponseUtil.wrapOrNotFound(invoicesDTO);
    }

    /**
     * {@code DELETE  /invoices/:id} : delete the "id" invoices.
     *
     * @param id the id of the invoicesDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/invoices/{id}")
    public ResponseEntity<Void> deleteInvoices(@PathVariable String id) {
        log.debug("REST request to delete invoices : {}", id);
        invoicesService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
