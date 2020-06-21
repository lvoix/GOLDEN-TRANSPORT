package com.golden.transport.service.mapper;

import com.golden.transport.domain.Address;
import com.golden.transport.service.dto.AddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity {@link Address} and its DTO {@link AddressDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AddressMapper extends EntityMapper<AddressDTO, Address> {

 /*   @Mapping(source = "city", target = "city")
    @Mapping(source = "area", target = "area")
    @Mapping(source = "country", target = "country")*/
    AddressDTO toDto(Address address);

/*    @Mapping(source = "city", target = "city")
    @Mapping(source = "area", target = "area")
    @Mapping(source = "country", target = "country")*/
    Address toEntity(AddressDTO addressDTO);

    default Address fromId(Long id) {
        if (id == null) {
            return null;
        }
        Address address = new Address();
        return address;
    }
}
