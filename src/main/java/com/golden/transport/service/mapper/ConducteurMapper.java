package com.golden.transport.service.mapper;


import com.golden.transport.domain.Conducteur;
import com.golden.transport.service.dto.ConducteurDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Conducteur} and its DTO {@link ConducteurDTO}.
 */
@Mapper(componentModel = "spring", uses = {OperationMapper.class})
public interface ConducteurMapper extends EntityMapper<ConducteurDTO, Conducteur> {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "entite", target = "entite")
    @Mapping(source = "cni", target = "cni")

        //@Mapping(source = "operations", target = "operations")
    ConducteurDTO toDto(Conducteur conducteur);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "cni", target = "cni")
    @Mapping(source = "entite", target = "entite")
        //@Mapping(source = "operations", target = "operations")
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
