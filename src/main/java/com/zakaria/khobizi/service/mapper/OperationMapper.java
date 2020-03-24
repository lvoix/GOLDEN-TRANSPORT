package com.zakaria.khobizi.service.mapper;


import com.zakaria.khobizi.domain.*;
import com.zakaria.khobizi.service.dto.OperationDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Operation} and its DTO {@link OperationDTO}.
 */
@Mapper(componentModel = "spring", uses = {TragetMapper.class, SocieteMapper.class, BeneficiaireMapper.class})
public interface OperationMapper extends EntityMapper<OperationDTO, Operation> {

    @Mapping(source = "traget.id", target = "tragetId")
    @Mapping(source = "societe.id", target = "societeId")
    @Mapping(source = "beneficiaire.id", target = "beneficiaireId")
    OperationDTO toDto(Operation operation);

    @Mapping(source = "tragetId", target = "traget")
    @Mapping(source = "societeId", target = "societe")
    @Mapping(source = "beneficiaireId", target = "beneficiaire")
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
