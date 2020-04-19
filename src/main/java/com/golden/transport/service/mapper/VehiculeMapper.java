package com.golden.transport.service.mapper;


import com.golden.transport.domain.Vehicule;
import com.golden.transport.service.dto.VehiculeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Vehicule} and its DTO {@link VehiculeDTO}.
 */
@Mapper(componentModel = "spring", uses = {OperationMapper.class, EntiteMapper.class})
public interface VehiculeMapper extends EntityMapper<VehiculeDTO, Vehicule> {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "matricule", target = "matricule")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "entites", target = "entites")
    @Mapping(source = "updateDateTime", target = "updateDateTime")
    @Mapping(source = "miseCirculation", target = "miseCirculation")
    @Mapping(source = "dateMiseCirculation", target = "dateMiseCirculation")


        //@Mapping(source = "lineoperations", target = "lineoperations")
    VehiculeDTO toDto(Vehicule vehicule);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "matricule", target = "matricule")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "updateDateTime", target = "updateDateTime")
    @Mapping(source = "miseCirculation", target = "miseCirculation")
    @Mapping(source = "dateMiseCirculation", target = "dateMiseCirculation")
    @Mapping(source = "entites", target = "entites")
        //@Mapping(source = "lineoperations", target = "lineoperations")
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
