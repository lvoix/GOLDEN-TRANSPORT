package com.golden.transport.service.mapper;


import com.golden.transport.domain.Entite;
import com.golden.transport.service.dto.EntiteDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link entite} and its DTO {@link EntiteDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EntiteMapper extends EntityMapper<EntiteDTO, Entite> {


    @Mapping(target = "conducteurs", ignore = true)
    Entite toEntity(EntiteDTO entiteDTO);

    default Entite fromId(Long id) {
        if (id == null) {
            return null;
        }
        Entite entite = new Entite();
        entite.setId(id);
        return entite;
    }
}
