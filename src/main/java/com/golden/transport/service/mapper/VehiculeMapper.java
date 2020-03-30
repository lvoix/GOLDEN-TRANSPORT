package com.golden.transport.service.mapper;


import com.golden.transport.domain.Vehicule;
import com.golden.transport.service.dto.VehiculeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Vehicule} and its DTO {@link VehiculeDTO}.
 */
@Mapper(componentModel = "spring", uses = {TargetMapper.class})
public interface VehiculeMapper extends EntityMapper<VehiculeDTO, Vehicule> {

    @Mapping(source = "id", target = "id")
    VehiculeDTO toDto(Vehicule vehicule);

    @Mapping(source = "id", target = "id")
    Vehicule toEntity(VehiculeDTO vehiculeDTO);

    default Vehicule fromId(Long id) {
        if (id == null) {
            return null;
        }
        Vehicule vehicule = new Vehicule();
        vehicule.setId(id);
        return vehicule;
    }
}
