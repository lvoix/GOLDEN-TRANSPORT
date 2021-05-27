package com.golden.transport.service;

import com.golden.transport.service.dto.InvoicesDTO;
import com.golden.transport.service.dto.OperationADDDTO;
import com.golden.transport.service.dto.OperationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.Optional;


public interface InvoicesService {

    /**
     * Save a Invoices.
     *
     * @return the persisted entity.
     */
    InvoicesDTO save(InvoicesDTO invoicesDTO);

    /**
     * Get all the Invoices.
     *
     * @return the list of Invoices.
     */
    Page<InvoicesDTO> findAll(Pageable pageable);


    Page<InvoicesDTO> findAllByBDates(Date date1, Date date2, Pageable pageable);

    Page<InvoicesDTO> findAllByCDates(Date date1, Date date2, Pageable pageable);

    //Page<InvoicesDTO> findAllByEntite(Date date1, Date date2, Integer enite, Pageable pageable);

    Page<InvoicesDTO> findByEntite(Integer enite, Pageable pageable);

    Page<InvoicesDTO> findAllByClient(Date date1, Date date2, Integer client, Pageable pageable);

    Page<InvoicesDTO> findByClient(Integer client, Pageable pageable);

    Page<InvoicesDTO> findAllByAll(Date date1, Date date2, Integer client, Integer beneficiaire, Pageable pageable);

    Page<InvoicesDTO> findAllByCB(Integer client, Integer beneficiaire, Pageable pageable);



    /**
     * Get the "id" Invoices.
     *
     * @param id the id of the Invoices.
     * @return the Invoices.
     */
    Optional<InvoicesDTO> findOne(String id);

    /**
     * Delete the "id" Invoices.
     *
     * @param id the id of the Invoices.
     */
    void delete(String id);

    Object findAll1();
}
