package com.golden.transport.service.mapper;


import com.golden.transport.domain.Operation;
import com.golden.transport.service.dto.operationTiersAddDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {TargetMapper.class, ClientMapper.class, OperationLineConMapper.class, OperationLineVehMapper.class})
public interface OperationTiersAddMapper extends EntityMapper<operationTiersAddDTO, Operation> {


      //@Mapping(source = "id", target = "id")
      //@Mapping(source = "beneficiaire", target = "beneficiaire")
      //@Mapping(source = "conducteurs", target = "conducteurs")
      //@Mapping(source = "vehicules", target = "vehicules")
      //@Mapping(source = "target", target = "target")
    //Set<OperationDTO> toDto(Set<Operation> operation);
      operationTiersAddDTO toDto(Operation operation);

      //@Mapping(source = "id", target = "id")
      //@Mapping(source = "beneficiaire", target = "beneficiaire")
     // @Mapping(source = "conducteurs", target = "conducteurs")
     // @Mapping(source = "vehicules", target = "vehicules")
     // @Mapping(source = "target", target = "target")
   // Set<Operation> toEntity(Set<OperationDTO> operationDTO);
     Operation toEntity(operationTiersAddDTO operationDTO);

    default Operation fromId(Long id) {
        if (id == null) {
            return null;
        }
        Operation operation = new Operation();
        operation.setId(id);
        return operation;
    }
}
