package com.zakaria.khobizi.service.mapper;


import com.zakaria.khobizi.domain.*;
import com.zakaria.khobizi.service.dto.VehiculeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Vehicule} and its DTO {@link VehiculeDTO}.
 */
<<<<<<< HEAD:src/main/java/com/zakaria/khobizi/service/mapper/VehiculeMapper.java
@Mapper(componentModel = "spring", uses = {TragetMapper.class})
public interface VehiculeMapper extends EntityMapper<VehiculeDTO, Vehicule> {

    @Mapping(source = "vehicules.id", target = "vehiculesId")
    VehiculeDTO toDto(Vehicule vehicule);

    @Mapping(target = "chauffeurs", ignore = true)
    @Mapping(target = "removeChauffeur", ignore = true)
    @Mapping(source = "vehiculesId", target = "vehicules")
=======
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
>>>>>>> lvoix-2020:src/main/java/com/golden/transport/service/mapper/VehiculeMapper.java
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
