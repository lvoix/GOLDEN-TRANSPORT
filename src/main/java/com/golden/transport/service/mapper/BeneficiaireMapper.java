package com.golden.transport.service.mapper;


import com.golden.transport.domain.Address;
import com.golden.transport.domain.Beneficiaire;
import com.golden.transport.service.dto.AddressDTO;
import com.golden.transport.service.dto.BeneficiaireDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Beneficiaire} and its DTO {@link BeneficiaireDTO}.
 */
@Mapper(componentModel = "spring", uses = { AddressMapper.class})
public interface BeneficiaireMapper extends EntityMapper<BeneficiaireDTO, Beneficiaire> {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    BeneficiaireDTO toDto(Beneficiaire beneficiaire);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
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
