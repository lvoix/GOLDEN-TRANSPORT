package com.zakaria.khobizi.service.mapper;


import com.zakaria.khobizi.domain.*;
import com.zakaria.khobizi.service.dto.SocieteDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Societe} and its DTO {@link SocieteDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SocieteMapper extends EntityMapper<SocieteDTO, Societe> {


    @Mapping(target = "chauffeurs", ignore = true)
    @Mapping(target = "removeChauffeur", ignore = true)
    Societe toEntity(SocieteDTO societeDTO);

    default Societe fromId(Long id) {
        if (id == null) {
            return null;
        }
        Societe societe = new Societe();
        societe.setId(id);
        return societe;
    }
}
