package com.golden.transport.service.mapper;


import com.golden.transport.domain.Operation;
import com.golden.transport.domain.Operation_H;
import com.golden.transport.util.IDHistorique;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {TargetMapper.class, ClientMapper.class, OperationLineConMapper.class, OperationLineVehMapper.class})
public interface OperationHMapper extends EntityMapper<Operation, Operation_H> {


      @Mapping(source = "id", target = "id")
      //@Mapping(source = "beneficiaire", target = "beneficiaire")
   //   @Mapping(source = "conducteurs", target = "conducteurs")
      //@Mapping(source = "vehicules", target = "vehicules")
      //@Mapping(source = "target", target = "target")
    //Set<OperationDTO> toDto(Set<Operation> operation);
      Operation toDto(Operation_H operationH);

      @Mapping(source = "id", target = "id")
      //@Mapping(source = "beneficiaire", target = "beneficiaire")
    //  @Mapping(source = "conducteurs", target = "conducteurs")
     // @Mapping(source = "vehicules", target = "vehicules")
     // @Mapping(source = "target", target = "target")
   // Set<Operation> toEntity(Set<OperationDTO> operationDTO);
      Operation_H toEntity(Operation operation);

    default Operation_H fromId(IDHistorique id) {
        if (id == null) {
            return null;
        }
        Operation_H operationH = new Operation_H();
        operationH.setIdop(id);
        return operationH;
    }
}
