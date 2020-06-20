package com.golden.transport.service.impl;

import com.golden.transport.domain.*;
import com.golden.transport.repository.OperationRepository;
import com.golden.transport.service.OperationService;
import com.golden.transport.service.dto.AddressDTO;
import com.golden.transport.service.dto.OperationADDDTO;
import com.golden.transport.service.dto.OperationDTO;
import com.golden.transport.service.dto.StationDTO;
import com.golden.transport.service.mapper.AddressMapper;
import com.golden.transport.service.mapper.OperationADDMapper;
import com.golden.transport.service.mapper.OperationMapper;
import com.golden.transport.service.mapper.StationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Service Implementation for managing {@link Operation}.
 */
@Service
@Transactional
public class OperationServiceImpl implements OperationService {

    private final Logger log = LoggerFactory.getLogger(OperationServiceImpl.class);

    private final OperationRepository operationRepository;

    private final OperationADDMapper operationADDMapper;
    private final OperationMapper operationMapper;
    private final AddressMapper addressMapper;
    private final StationMapper stationMapper;

    @Autowired(required = true)
    public OperationServiceImpl(OperationRepository operationRepository, OperationMapper operationMapper,OperationADDMapper operationADDMapper, AddressMapper addressMapper, StationMapper stationMapper) {
        this.operationRepository = operationRepository;
        this.operationMapper = operationMapper;
        this.operationADDMapper = operationADDMapper;
        this.addressMapper = addressMapper;
        this.stationMapper = stationMapper;
    }

    /**
     * Save a operation.
     *
     * @param operationDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public OperationDTO save(OperationADDDTO operationDTO) {
        log.debug("Request to save Operation : {}", operationDTO);
        Operation operation = preSave(operationDTO);
        OperationDTO ok = operationMapper.toDto(operation);
        return ok;
    }
    private Operation preSave(OperationADDDTO operationDTO){
        Operation operation = operationADDMapper.toEntity(operationDTO);
        operation.setDateCreation(new Date());
        operation = operationRepository.save(operation);

        //preparer ajoute conducteur 1

        OperationLineConducteurs operationLineConducteurs1 = new OperationLineConducteurs();
        OperationLineConducteurs operationLineConducteurs2 = new OperationLineConducteurs();
         Conducteur con1 = new Conducteur();
         Conducteur con2 = new Conducteur();

        if ( operationDTO != null  &&  operationDTO.getLineC1() != null &&  operationDTO.getLineC1().getId() != null  ) {
            //if ( operationDTO.getLineC2().getId() != null ) {
                operationLineConducteurs1.setId(operationDTO.getLineC1().getId());
                operationLineConducteurs2.setId(operationDTO.getLineC2().getId());
                con1.setId(operationDTO.getLineC1().getConducteurs().getId());
                operationLineConducteurs1.setConducteurs(con1);
                con2.setId(operationDTO.getLineC2().getConducteurs().getId());
                operationLineConducteurs2.setConducteurs(con2);
            //}
        }
        if ( operationDTO != null && operationDTO.getLineC1() == null) {
                operationLineConducteurs1.setConducteurs(operationDTO.getConducteurs1());
                operationLineConducteurs2.setConducteurs(operationDTO.getConducteurs2());
        }

        operationLineConducteurs1.setOperations(operation);
        operationLineConducteurs2.setOperations(operation);

        // ajoute les deux conducteurs dans operation
        Set<OperationLineConducteurs> operationLineConducteurs = new HashSet<>();
        operationLineConducteurs.add(operationLineConducteurs1);
        operationLineConducteurs.add(operationLineConducteurs2);

        operation.getConducteurs().clear();

        //operation.setConducteurs(operationLineConducteurs);
        operation.getConducteurs().addAll(operationLineConducteurs);

        OperationLineVehicules  operationLineVehicules1 = new OperationLineVehicules();
        OperationLineVehicules  operationLineVehicules2 = new OperationLineVehicules();
        Vehicule vh1 = new Vehicule();
        Vehicule vh2 = new Vehicule();

        if(operationDTO != null && operationDTO.getLineV1() != null && operationDTO.getLineV1().getId() != null){
           // if(operationDTO.getLineV2().getId() != null){
                operationLineVehicules1.setId(operationDTO.getLineV1().getId());
                operationLineVehicules2.setId(operationDTO.getLineV2().getId());
                vh1.setId(operationDTO.getLineV1().getVehicules().getId());
                operationLineVehicules1.setVehicules(vh1);
                vh2.setId(operationDTO.getLineV2().getVehicules().getId());
                operationLineVehicules2.setVehicules(vh2);
          //  }
        } else{
            operationLineVehicules1.setVehicules(operationDTO.getTracteurs());
            operationLineVehicules2.setVehicules(operationDTO.getRemorques());
        }
            operationLineVehicules1.setOperations(operation);
            operationLineVehicules2.setOperations(operation);

        // ajoute les deux vehicule dans operation
        Set<OperationLineVehicules> operationLineVehicules = new HashSet<>();
        operationLineVehicules.add(operationLineVehicules1);
        operationLineVehicules.add(operationLineVehicules2);


        operation.getVehicules().clear();
        //operation.setVehicules(operationLineVehicules);
        operation.getVehicules().addAll(operationLineVehicules);

        // ajoute la listes des adresses de chargements dans operation
        for(StationDTO adrs : operationDTO.getAdressesLoad()){
            //if(adrs != null)
           // Station station = new Station();
            Station station = stationMapper.toEntity(adrs);
            station.setOperations(operation);
            //Address adr = addressMapper.toEntity(adrs.getAddress());
          //  station.setAddress(adrs.getAddress());
            operation.getStations().add(station);

        }
        // ajoute la listes des adresses de livraison dans operation
        for(StationDTO adrs : operationDTO.getAdressesLivraison()){

             //   Station station = new Station();
                  Station station = stationMapper.toEntity(adrs);
                  station.setOperations(operation);                //Address adr = addressMapper.toEntity(adrs.getAddress());
              //  station.setAddress(adrs.getAddress());
                operation.getStations().add(station);

            }


        return operationRepository.save(operation);

    }
    /**
     * Get all the operations.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<OperationDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Operations");
        return operationRepository.findAll(pageable)
            .map(operationMapper::toDto);
    }

    /**
     * Get one operation by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<OperationDTO> findOne(Long id) {
        log.debug("Request to get Operation : {}", id);
        return operationRepository.findById(id)
            .map(operationMapper::toDto);
    }

    /**
     * Delete the operation by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Operation : {}", id);
        operationRepository.deleteById(id);
    }
}
