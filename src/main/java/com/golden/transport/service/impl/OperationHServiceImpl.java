package com.golden.transport.service.impl;

import com.golden.transport.domain.*;
import com.golden.transport.enumeration.OperationStatus;
import com.golden.transport.repository.OperationRepository;
import com.golden.transport.repository.Operation_HRepository;
import com.golden.transport.service.DepencesService;
import com.golden.transport.service.OperationHService;
import com.golden.transport.service.OperationService;
import com.golden.transport.service.dto.*;
import com.golden.transport.service.mapper.*;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional
public class OperationHServiceImpl implements OperationHService  {

    private final Logger log = LoggerFactory.getLogger(OperationHServiceImpl.class);

    private final OperationRepository operationRepository;
    private final Operation_HRepository  operation_HRepository;
    private final OperationADDMapper operationADDMapper;
    private final OperationTiersAddMapper operationTiersAddMapper;

    private final OperationMapper operationMapper;

    private final AddressMapper addressMapper;
    private final StationMapper stationMapper;
    private final DepencesMapper  depencesMapper;
    private final DepencesAddMapper  depencesAddMapper;

    private ModelMapper modelMapper = new ModelMapper();

    private final DepencesService depencesService;


    @Autowired(required = true)
    public OperationHServiceImpl(OperationRepository operationRepository, OperationMapper operationMapper, OperationADDMapper operationADDMapper, AddressMapper addressMapper,
                                 StationMapper stationMapper, DepencesService depencesService,
                                 DepencesMapper  depencesMapper, OperationTiersAddMapper operationTiersAddMapper,
                                 DepencesAddMapper  depencesAddMapper,
                                 Operation_HRepository  operation_HRepository) {
        this.operationRepository = operationRepository;
        this.operation_HRepository = operation_HRepository;
        this.operationMapper = operationMapper;
        this.operationADDMapper = operationADDMapper;
        this.operationTiersAddMapper = operationTiersAddMapper;
        this.addressMapper = addressMapper;
        this.stationMapper = stationMapper;
        this.depencesService = depencesService;
        this.depencesMapper = depencesMapper;
        this.depencesAddMapper = depencesAddMapper;

    }

    /**
     * Save a operation.
     *
     * @param
     * @return the persisted entity.
     */

    @Override
    public Operation_H save(Operation_H operation) {
        log.debug("Request to save Operation_H : {}", operation);
        Operation_H opeResult = operation_HRepository.save(operation);
        return opeResult;
    }

    @Override
    public OperationDTO saveNormal(OperationDTO operationDTO) {

        log.debug("Request to save operation : {}", operationDTO);

        Operation operationN = preSaveNormal(operationDTO);

        return operationMapper.toDto(operationN);
    }

    private Operation preparerOperation(operationTiersAddDTO operationDTO){
      Operation ope = new Operation();
       Client cl = new Client();
       cl.setId(Long.valueOf(operationDTO.getOperationCouplage().getClient()).longValue());
       ope.setClient(cl);
       ope.setStatus(OperationStatus.CREATE);
       ope.setMotifClient(operationDTO.getOperationCouplage().getMotifClient());
       ope.setDatedepart(operationDTO.getOperationCouplage().getDateDepart());
       ope.setDateFin(operationDTO.getOperationCouplage().getDateArrive());
       ope.setDateArrive(operationDTO.getOperationCouplage().getDateArrive());
       ope.setDateLivraison(operationDTO.getOperationCouplage().getDateLivraison());
       ope.setTypeMarchandises(operationDTO.getOperationGeneralDetails().getNatureMarchandises());
       ope.setRefChargement(operationDTO.getOperationGeneralDetails().getRefchargement());
       ope.setOperationtype(operationDTO.getOperationCouplage().getTypeoperation());
       ope.setMotifClient(operationDTO.getOperationCouplage().getMotifClient());
       ope.setModeEmbarquement(operationDTO.getOperationGeneralDetails().getModeEmbarquement());
       ope.setExtensionGeo(operationDTO.getOperationGeneralDetails().getExtensionGeo());
       ope.setMontantOpe(operationDTO.getOperationGeneralDetails().getMontantOpe());
       ope.setDeviseOpe(operationDTO.getOperationGeneralDetails().getDeviseOpe());
       ope.setOthers(operationDTO.getOperationGeneralDetails().getOthers());
       ope.setNatureVehicule1(operationDTO.getOperationCouplage().getNatureVehicule1());
       ope.setNatureVehicule2(operationDTO.getOperationCouplage().getNatureVehicule2());

       return ope;
    }

    private Operation preSaveNormal(OperationDTO operationDTO){

        Operation operation = operationMapper.toEntity(operationDTO);

        if (operationDTO.getId() == null)
            operation.setDateCreation(new Date());
        else
            operation.setDateUpadte(new Date());

        operation.setFacturer(false);

        operation = operationRepository.save(operation);

        Set<OperationLineConducteurs> operationLineConducteursList = new HashSet<>();


        if ( operationDTO != null  &&  operationDTO.getConducteurs() != null  ) {


        for(AssocaidTOOperLineConDTO opLineCon : operationDTO.getConducteurs()){

            if ( operationDTO != null  &&  operationDTO.getConducteurs() != null  && opLineCon.getConducteurs().getId() != null) {
                OperationLineConducteurs operationLineConducteurs = new OperationLineConducteurs();
                Conducteur con = new Conducteur();
                con.setId(Long.valueOf(opLineCon.getConducteurs().getId()).longValue());

                operationLineConducteurs.setId(Long.valueOf(opLineCon.getId()).longValue());
                operationLineConducteurs.setOperations(operation);
                operationLineConducteurs.setNumerOrder(opLineCon.getNumerOrder());
                operationLineConducteurs.setConducteurs(con);

                operationLineConducteursList.add(operationLineConducteurs);
            }

            operation.getConducteurs().clear();

            operation.getConducteurs().addAll(operationLineConducteursList);

        }
    }

        Set<OperationLineVehicules> operationLineVehiculesList = new HashSet<>();


        if ( operationDTO != null  &&  operationDTO.getVehicules() != null  ) {


            for(AssociadToOperLineVehDTO opLineVeh : operationDTO.getVehicules()){

                if ( operationDTO != null  &&  operationDTO.getVehicules() != null  && opLineVeh.getVehicules().getId() != null) {
                    OperationLineVehicules  operationLineVehicules = new OperationLineVehicules();
                    Vehicule vh = new Vehicule();

                    vh.setId(Long.valueOf(opLineVeh.getVehicules().getId()).longValue());

                    operationLineVehicules.setId(Long.valueOf(opLineVeh.getId()).longValue());
                    operationLineVehicules.setOperations(operation);
                    operationLineVehicules.setNumerOrder(opLineVeh.getNumerOrder());
                    operationLineVehicules.setVehicules(vh);

                    operationLineVehiculesList.add(operationLineVehicules);
                }

                operation.getVehicules().clear();

                operation.getVehicules().addAll(operationLineVehiculesList);

            }
        }

        // edit la listes des adresses de chargements dans operation

        for(StationDTO adrs : operationDTO.getStations()){
            Station station = stationMapper.toEntity(adrs);
            operation.getStations().add(station);
        }

        // edit save des depences all
        for(DepencesDTO depence : operationDTO.getDepences()){
            Depences depe = depencesMapper.toEntity(depence);
            operation.getDepences().add(depe);
        }

        return operationRepository.save(operation);
    }

    private Operation preSave(operationTiersAddDTO operationDTO){

        Operation operation = operationTiersAddMapper.toEntity(operationDTO);

        operation = preparerOperation(operationDTO);

        operation.setDateCreation(new Date());
        operation.setFacturer(false);

        operation = operationRepository.save(operation);

        //preparer ajoute conducteur 1

        OperationLineConducteurs operationLineConducteurs1 = new OperationLineConducteurs();
        OperationLineConducteurs operationLineConducteurs2 = new OperationLineConducteurs();
        OperationLineConducteurs operationLineConducteurs3 = new OperationLineConducteurs();

        Conducteur con1 = new Conducteur();
        Conducteur con2 = new Conducteur();
        Conducteur con3 = new Conducteur();

    /*    if ( operationDTO != null  &&  operationDTO.getLineC1() != null &&  operationDTO.getLineC1().getId() != null  ) {
            //if ( operationDTO.getLineC2().getId() != null ) {
                operationLineConducteurs1.setId(operationDTO.getLineC1().getId());
                operationLineConducteurs2.setId(operationDTO.getLineC2().getId());
                con1.setId(operationDTO.getLineC1().getConducteurs().getId());
                operationLineConducteurs1.setConducteurs(con1);
                con2.setId(operationDTO.getLineC2().getConducteurs().getId());
                operationLineConducteurs2.setConducteurs(con2);
            //}
        }*/
        if ( operationDTO != null) {
                 con1.setId( Long.valueOf(operationDTO.getOperationCouplage().getConducteurs1()).longValue());
                 con2.setId( Long.valueOf(operationDTO.getOperationCouplage().getConducteurs2()).longValue());
                 con3.setId( Long.valueOf(operationDTO.getOperationCouplage().getConducteurs3()).longValue());

            operationLineConducteurs1.setConducteurs(con1);
            operationLineConducteurs2.setConducteurs(con2);
            operationLineConducteurs3.setConducteurs(con3);

        }

        operationLineConducteurs1.setOperations(operation);
        operationLineConducteurs1.setNumerOrder(Long.valueOf(1));
        operationLineConducteurs2.setOperations(operation);
        operationLineConducteurs2.setNumerOrder(Long.valueOf(2));
        operationLineConducteurs3.setOperations(operation);
        operationLineConducteurs3.setNumerOrder(Long.valueOf(3));


        // ajoute les deux conducteurs dans operation
        Set<OperationLineConducteurs> operationLineConducteurs = new HashSet<>();
        operationLineConducteurs.add(operationLineConducteurs1);
        operationLineConducteurs.add(operationLineConducteurs2);
        operationLineConducteurs.add(operationLineConducteurs3);

        operation.getConducteurs().clear();

        //operation.setConducteurs(operationLineConducteurs);
        operation.getConducteurs().addAll(operationLineConducteurs);

        OperationLineVehicules  operationLineVehicules1 = new OperationLineVehicules();
        OperationLineVehicules  operationLineVehicules2 = new OperationLineVehicules();
        Vehicule vh1 = new Vehicule();
        Vehicule vh2 = new Vehicule();

/*        if(operationDTO != null && operationDTO.getLineV1() != null && operationDTO.getLineV1().getId() != null){
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
        }*/

        if ( operationDTO != null) {
            vh1.setId( Long.valueOf(operationDTO.getOperationCouplage().getVehicule1()).longValue());
            vh2.setId( Long.valueOf(operationDTO.getOperationCouplage().getVehicule2()).longValue());
            operationLineVehicules1.setVehicules(vh1);
            operationLineVehicules2.setVehicules(vh2);
        }
            operationLineVehicules1.setOperations(operation);
            operationLineVehicules1.setNumerOrder(Long.valueOf(1));
            operationLineVehicules2.setOperations(operation);
            operationLineVehicules2.setNumerOrder(Long.valueOf(2));


        // ajoute les deux vehicule dans operation
        Set<OperationLineVehicules> operationLineVehicules = new HashSet<>();
        operationLineVehicules.add(operationLineVehicules1);
        operationLineVehicules.add(operationLineVehicules2);


        operation.getVehicules().clear();
        //operation.setVehicules(operationLineVehicules);
        operation.getVehicules().addAll(operationLineVehicules);

        // ajoute la listes des adresses de chargements dans operation
        int ordreC = 0;
        for(StationDTO adrs : operationDTO.getOperationDirection().getAdressesChargement()){
            //if(adrs != null)
           // Station station = new Station();
            ordreC ++;
            Station station = stationMapper.toEntity(adrs);
            station.setOperations(operation);
            station.setTypeStation("C");
            station.setOrdere(ordreC);
            //Address adr = addressMapper.toEntity(adrs.getAddress());
          //  station.setAddress(adrs.getAddress());
            operation.getStations().add(station);

        }
        int ordreL = 0;
        // ajoute la listes des adresses de livraison dans operation
        for(StationDTO adrs : operationDTO.getOperationDirection().getAdressesDechargement()){
            ordreL ++;
             //   Station station = new Station();
                  Station station = stationMapper.toEntity(adrs);
                  station.setOperations(operation);                //Address adr = addressMapper.toEntity(adrs.getAddress());
                  station.setTypeStation("L");
                  station.setOrdere(ordreL);
            //  station.setAddress(adrs.getAddress());
                operation.getStations().add(station);

            }
             // save des depences all
        for(DepencesAddDTO depence : operationDTO.getOperationGeneralDetails().getDepencesAlls()){
            Depences depe = depencesAddMapper.toEntity(depence);
            depe.setOperations(operation);
            depe.setEtat(true);
            operation.getDepences().add(depe);
        }
            //Operation op = saveDepenceOp(operationDTO.getDepences(), operation);

        return operationRepository.save(operation);

    }

  public Operation saveDepenceOp(List<DepencesDTO> depences, Operation op){
        for(DepencesDTO depence : depences){
                   Depences depe = depencesMapper.toEntity(depence);
                   depe.setOperations(op);
                   depe.setEtat(true);
                   op.getDepences().add(depe);
           }
      return op;
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

    @Override
    public OperationDTO getOperation1(Long operationId) {

            Operation operation = operationRepository.findById(operationId)
                    .orElseThrow(() -> new ResourceNotFoundException("Operation not exist id = " + operationId));

            return modelMapper.map(operation, OperationDTO.class);

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
