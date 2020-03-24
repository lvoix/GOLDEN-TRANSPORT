package com.zakaria.khobizi.service.mapper;


import com.zakaria.khobizi.domain.*;
import com.zakaria.khobizi.service.dto.TragetDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Traget} and its DTO {@link TragetDTO}.
 */
@Mapper(componentModel = "spring", uses = {StationMapper.class, DepencesMapper.class})
public interface TragetMapper extends EntityMapper<TragetDTO, Traget> {

    @Mapping(source = "stationDepart.id", target = "stationDepartId")
    @Mapping(source = "stationDestination.id", target = "stationDestinationId")
    @Mapping(source = "depence.id", target = "depenceId")
    @Mapping(source = "sousTragets.id", target = "sousTragetsId")
    TragetDTO toDto(Traget traget);

    @Mapping(source = "stationDepartId", target = "stationDepart")
    @Mapping(source = "stationDestinationId", target = "stationDestination")
    @Mapping(source = "depenceId", target = "depence")
    @Mapping(target = "tragets", ignore = true)
    @Mapping(target = "removeTraget", ignore = true)
    @Mapping(target = "vehicules", ignore = true)
    @Mapping(target = "removeVehicule", ignore = true)
    @Mapping(source = "sousTragetsId", target = "sousTragets")
    Traget toEntity(TragetDTO tragetDTO);

    default Traget fromId(Long id) {
        if (id == null) {
            return null;
        }
        Traget traget = new Traget();
        traget.setId(id);
        return traget;
    }
}
