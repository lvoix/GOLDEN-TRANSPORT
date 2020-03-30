package com.golden.transport.service.mapper;


import com.golden.transport.domain.OperationLineVehicules;
import com.golden.transport.service.dto.OperLineVehDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity {@link OperationLineVehicules} and its DTO {@link OperLineVehDTO}.
 */
@Mapper(componentModel = "spring", uses = { OperationMapper.class, VehiculeMapper.class})
public interface OperationLineVehMapper extends EntityMapper<OperLineVehDTO, OperationLineVehicules> {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "operations", target = "operations")
        /*  @Mapping(source = "vehicules", target = "vehicules")*/
    OperLineVehDTO toDto(OperationLineVehicules operationLineVehicules);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "operations", target = "operations")
        /*  @Mapping(source = "vehicules", target = "vehicules")*/
    OperationLineVehicules toEntity(OperLineVehDTO operLineVehDTO);

    default OperationLineVehicules fromId(Long id) {
        if (id == null) {
            return null;
        }
        OperationLineVehicules operationLineVehicules = new OperationLineVehicules();
        operationLineVehicules.setId(id);
        return operationLineVehicules;
    }
}
