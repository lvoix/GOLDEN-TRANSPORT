package com.golden.transport.service.mapper;


import com.golden.transport.domain.Station;
import com.golden.transport.service.dto.StationDTO;

import org.mapstruct.*;


@Mapper(componentModel = "spring", uses = {})
public interface StationMapper extends EntityMapper<StationDTO, Station> {

    StationDTO toDto(Station station);


    Station toEntity(StationDTO stationDTO);

    default Station fromId(Long id) {
        if (id == null) {
            return null;
        }
        Station station = new Station();
        station.setId(id);
        return station;
    }
}
