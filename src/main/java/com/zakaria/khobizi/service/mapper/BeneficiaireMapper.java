package com.zakaria.khobizi.service.mapper;


import com.zakaria.khobizi.domain.*;
import com.zakaria.khobizi.service.dto.BeneficiaireDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Beneficiaire} and its DTO {@link BeneficiaireDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BeneficiaireMapper extends EntityMapper<BeneficiaireDTO, Beneficiaire> {



    default Beneficiaire fromId(Long id) {
        if (id == null) {
            return null;
        }
        Beneficiaire beneficiaire = new Beneficiaire();
        beneficiaire.setId(id);
        return beneficiaire;
    }
}
