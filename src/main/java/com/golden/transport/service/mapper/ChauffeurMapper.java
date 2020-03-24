package com.golden.transport.service.mapper;


import com.golden.transport.domain.Chauffeur;
import com.golden.transport.service.dto.ChauffeurDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Chauffeur} and its DTO {@link ChauffeurDTO}.
 */
@Mapper(componentModel = "spring", uses = {SocieteMapper.class, VehiculeMapper.class})
public interface ChauffeurMapper extends EntityMapper<ChauffeurDTO, Chauffeur> {

    @Mapping(source = "societes.id", target = "societesId")
    @Mapping(source = "vehicules.id", target = "vehiculesId")
    ChauffeurDTO toDto(Chauffeur chauffeur);

    @Mapping(source = "societesId", target = "societes")
    @Mapping(source = "vehiculesId", target = "vehicules")
    Chauffeur toEntity(ChauffeurDTO chauffeurDTO);

    default Chauffeur fromId(Long id) {
        if (id == null) {
            return null;
        }
        Chauffeur chauffeur = new Chauffeur();
        chauffeur.setId(id);
        return chauffeur;
    }
}
