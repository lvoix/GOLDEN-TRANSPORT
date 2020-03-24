package com.zakaria.khobizi.service.mapper;


import com.zakaria.khobizi.domain.*;
import com.zakaria.khobizi.service.dto.DepencesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Depences} and its DTO {@link DepencesDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DepencesMapper extends EntityMapper<DepencesDTO, Depences> {



    default Depences fromId(Long id) {
        if (id == null) {
            return null;
        }
        Depences depences = new Depences();
        depences.setId(id);
        return depences;
    }
}
