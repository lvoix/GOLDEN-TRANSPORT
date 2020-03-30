package com.golden.transport.service.mapper;


import com.golden.transport.domain.Operation;
import com.golden.transport.service.dto.OperationDTO;

import org.mapstruct.*;

import java.util.Set;

/**
 * Mapper for the entity {@link Operation} and its DTO {@link OperationDTO}.
 */
@Mapper(componentModel = "spring", uses = {TargetMapper.class, BeneficiaireMapper.class, OperationLineConMapper.class, OperationLineVehMapper.class})
public interface OperationMapper extends EntityMapper<OperationDTO, Operation> {


      @Mapping(source = "id", target = "id")
    //@Mapping(source = "beneficiaire", target = "beneficiaire")
    //@Mapping(source = "conducteurs", target = "conducteurs")
    //@Mapping(source = "vehicules", target = "vehicules")
    //@Mapping(source = "target", target = "target")
    //Set<OperationDTO> toDto(Set<Operation> operation);
      OperationDTO toDto(Operation operation);

      @Mapping(source = "id", target = "id")
    //@Mapping(source = "beneficiaire", target = "beneficiaire")
   // @Mapping(source = "conducteurs", target = "conducteurs")
    //@Mapping(source = "vehicules", target = "vehicules")
    //@Mapping(source = "target", target = "target")
   // Set<Operation> toEntity(Set<OperationDTO> operationDTO);
     Operation toEntity(OperationDTO operationDTO);

    default Operation fromId(Long id) {
        if (id == null) {
            return null;
        }
        Operation operation = new Operation();
        operation.setId(id);
        return operation;
    }
}
