package com.golden.transport.service.mapper;


import com.golden.transport.domain.Beneficiaire;
import com.golden.transport.service.dto.BeneficiaireDTO_ID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {})
public interface Entite_IDMapper extends EntityMapper<BeneficiaireDTO_ID, Beneficiaire> {

    @Mapping(source = "id", target = "id")
    BeneficiaireDTO_ID toDto(Beneficiaire beneficiaire);

    @Mapping(source = "id", target = "id")
    Beneficiaire toEntity(BeneficiaireDTO_ID BeneficiaireDTO_ID);


    default Beneficiaire fromId(Long id) {
        if (id == null) {
            return null;
        }
        Beneficiaire beneficiaire = new Beneficiaire();
        beneficiaire.setId(id);
        return beneficiaire;
    }
}
