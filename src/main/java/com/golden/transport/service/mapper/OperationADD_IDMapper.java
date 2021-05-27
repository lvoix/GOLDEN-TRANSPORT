package com.golden.transport.service.mapper;


import com.golden.transport.domain.Operation;
import com.golden.transport.service.dto.OperationDTO_ID;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {TargetMapper.class, ClientMapper.class, OperationLineConMapper.class, OperationLineVehMapper.class})
public interface OperationADD_IDMapper extends EntityMapper<OperationDTO_ID, Operation> {


      //@Mapping(source = "id", target = "id")
      //@Mapping(source = "beneficiaire", target = "beneficiaire")
      //@Mapping(source = "conducteurs", target = "conducteurs")
      //@Mapping(source = "vehicules", target = "vehicules")
      //@Mapping(source = "target", target = "target")
    //Set<OperationDTO> toDto(Set<Operation> operation);
      OperationDTO_ID toDto(Operation operation);

      //@Mapping(source = "id", target = "id")
      //@Mapping(source = "beneficiaire", target = "beneficiaire")
     // @Mapping(source = "conducteurs", target = "conducteurs")
     // @Mapping(source = "vehicules", target = "vehicules")
     // @Mapping(source = "target", target = "target")
   // Set<Operation> toEntity(Set<OperationDTO> operationDTO);
     Operation toEntity(OperationDTO_ID operationDTO);

    default Operation fromId(Long id) {
        if (id == null) {
            return null;
        }
        Operation operation = new Operation();
        operation.setId(id);
        return operation;
    }
}
