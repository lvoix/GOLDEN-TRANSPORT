package com.golden.transport.service.mapper;


import com.golden.transport.domain.Conducteur;
import com.golden.transport.service.dto.ConducteurDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Conducteur} and its DTO {@link ConducteurDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ConducteurMapper extends EntityMapper<ConducteurDTO, Conducteur> {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "cin", target = "cin")
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "prenom", target = "prenom")
    @Mapping(source = "npasseport", target = "npasseport")
    ConducteurDTO toDto(Conducteur conducteur);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "cin", target = "cin")
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "prenom", target = "prenom")
    Conducteur toEntity(ConducteurDTO conducteurDTO);

    default Conducteur fromId(Long id) {
        if (id == null) {
            return null;
        }
        Conducteur conducteur = new Conducteur();
        conducteur.setId(id);
        return conducteur;
    }
}
