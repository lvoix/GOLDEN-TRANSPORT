package com.golden.transport.service.mapper;


import com.golden.transport.domain.Beneficiaire;
import com.golden.transport.service.dto.BeneficiaireDTO;

import org.mapstruct.*;


@Mapper(componentModel = "spring", uses = {})
public interface EntiteMapper extends EntityMapper<BeneficiaireDTO, Beneficiaire> {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "abr", target = "abr")
    BeneficiaireDTO toDto(Beneficiaire beneficiaire);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "abr", target = "abr")
    Beneficiaire toEntity(BeneficiaireDTO beneficiaireDTO);


    default Beneficiaire fromId(Long id) {
        if (id == null) {
            return null;
        }
        Beneficiaire beneficiaire = new Beneficiaire();
        beneficiaire.setId(id);
        return beneficiaire;
    }
}
