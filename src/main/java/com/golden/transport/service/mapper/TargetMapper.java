package com.golden.transport.service.mapper;


import com.golden.transport.domain.Target;
import com.golden.transport.service.dto.TargetDTO;

import org.mapstruct.*;


@Mapper(componentModel = "spring", uses = {StationMapper.class, DepencesMapper.class})
public interface TargetMapper extends EntityMapper<TargetDTO, Target> {

/*    @Mapping(source = "stationDepart.id", target = "stationDepart")
    @Mapping(source = "stationDestination.id", target = "stationDestination")
    @Mapping(source = "depence.id", target = "depenceId")
    @Mapping(source = "sousTargets.id", target = "id")
    TargetDTO toDto(Target target);

    @Mapping(source = "stationDepartId", target = "stationDepart")
    @Mapping(source = "stationDestinationId", target = "stationDestination")
    @Mapping(source = "depenceId", target = "depence")
    @Mapping(target = "targets", ignore = true)
    @Mapping(target = "vehicules", ignore = true)
    @Mapping(source = "sousTargetsId", target = "sousTargets")
    Target toEntity(TargetDTO targetDTO);*/

    default Target fromId(Long id) {
        if (id == null) {
            return null;
        }
        Target target = new Target();
        target.setId(id);
        return target;
    }
}
