package com.golden.transport.service.impl;

import com.golden.transport.domain.*;
import com.golden.transport.repository.InvoiceRepository;
import com.golden.transport.repository.OperationRepository;
import com.golden.transport.service.DepencesService;
import com.golden.transport.service.InvoicesService;
import com.golden.transport.service.OperationService;
import com.golden.transport.service.dto.*;
import com.golden.transport.service.mapper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional
public class InvoicesServiceImpl implements InvoicesService {

    private final Logger log = LoggerFactory.getLogger(InvoicesServiceImpl.class);

    private final InvoiceRepository invoiceRepository;
    private final InvoicesMapper invoicesMapper;

    @Autowired(required = true)
    public InvoicesServiceImpl(InvoiceRepository  invoicerepository, InvoicesMapper invoicesmapper) {
        this.invoiceRepository = invoicerepository;
        this.invoicesMapper = invoicesmapper;
    }
    /**
     * Save a operation.
     *
     * @param invoicesDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public InvoicesDTO save(InvoicesDTO invoicesDTO) {
        log.debug("Request to save invoices : {}", invoicesDTO);
        Invoice invoice = invoicesMapper.toEntity(invoicesDTO);
        invoice = invoiceRepository.save(invoice);
        return invoicesMapper.toDto(invoice);
    }

    /**
     * Get all the Invoices.
     *
     * @param pageable the pagination information.
     * @return the list of Invoices.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<InvoicesDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Invoices");
        return invoiceRepository.findAll(pageable)
            .map(invoicesMapper::toDto);
    }

    @Override
    public Page<InvoicesDTO> findAllByBDates(Date date1, Date date2, Pageable pageable) {
        log.debug("Request to get all Invoices");
        return invoiceRepository.findAllByBDates(date1, date2, pageable)
                .map(invoicesMapper::toDto);
    }

    @Override
    public Page<InvoicesDTO> findAllByCDates(Date date1, Date date2, Pageable pageable) {
        log.debug("Request to get all Invoices");
        return invoiceRepository.findAllByCDates(date1, date2, pageable)
                .map(invoicesMapper::toDto);
    }

 /*   @Override
    public Page<InvoicesDTO> findAllByEntite(Date date1, Date date2, Integer enite, Pageable pageable) {
        return null;
    }
*/
    @Override
    public Page<InvoicesDTO> findByEntite(Integer enite, Pageable pageable) {
        return null;
    }

    @Override
    public Page<InvoicesDTO> findAllByClient(Date date1, Date date2, Integer client, Pageable pageable) {
        return null;
    }

    @Override
    public Page<InvoicesDTO> findByClient(Integer client, Pageable pageable) {
        return null;
    }

    @Override
    public Page<InvoicesDTO> findAllByAll(Date date1, Date date2, Integer client, Integer beneficiaire, Pageable pageable) {
        return null;
    }

    @Override
    public Page<InvoicesDTO> findAllByCB(Integer client, Integer beneficiaire, Pageable pageable) {
        return null;
    }

 /*   @Override
    public Page<InvoicesDTO> findAllByEntite(Integer enite, Pageable pageable) {
        log.debug("Request to get all Invoices by entite");
        return invoiceRepository.findAllByEntite(enite, pageable)
                .map(invoicesMapper::toDto);
    }*/

    @Override
    @Transactional(readOnly = true)
    public Object findAll1() {
        log.debug("Request to get all Invoices");
        return invoiceRepository.findAll();
    }

    /**
     * Get one Invoices by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<InvoicesDTO> findOne(String id) {
        log.debug("Request to get Operation : {}", id);
        return invoiceRepository.findById(id)
            .map(invoicesMapper::toDto);
    }

    /**
     * Delete the Invoices by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete Invoices : {}", id);
        invoiceRepository.deleteById(id);
    }
}
