package com.zakaria.khobizi.service.mapper;


import com.zakaria.khobizi.domain.*;
import com.zakaria.khobizi.service.dto.VehiculeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Vehicule} and its DTO {@link VehiculeDTO}.
 */
@Mapper(componentModel = "spring", uses = {TragetMapper.class})
public interface VehiculeMapper extends EntityMapper<VehiculeDTO, Vehicule> {

    @Mapping(source = "vehicules.id", target = "vehiculesId")
    VehiculeDTO toDto(Vehicule vehicule);

    @Mapping(target = "chauffeurs", ignore = true)
    @Mapping(target = "removeChauffeur", ignore = true)
    @Mapping(source = "vehiculesId", target = "vehicules")
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
