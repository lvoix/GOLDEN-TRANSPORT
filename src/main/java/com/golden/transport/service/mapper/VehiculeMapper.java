package com.golden.transport.service.mapper;


import com.golden.transport.domain.Vehicule;
import com.golden.transport.service.dto.VehiculeDTO;

import org.mapstruct.*;


@Mapper(componentModel = "spring", uses = {OperationMapper.class, EntiteMapper.class})
public interface VehiculeMapper extends EntityMapper<VehiculeDTO, Vehicule> {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "matricule", target = "matricule")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "beneficiaires", target = "beneficiaires")
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
    @Mapping(source = "beneficiaires", target = "beneficiaires")

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
