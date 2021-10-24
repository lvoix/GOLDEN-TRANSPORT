package com.golden.transport.service.mapper;


import com.golden.transport.domain.Client;
import com.golden.transport.service.dto.ClientDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Client} and its DTO {@link ClientDTO}.
 */
@Mapper(componentModel = "spring", uses = { AddressMapper.class})
public interface ClientMapper extends EntityMapper<ClientDTO, Client> {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
   // @Mapping(source = "address", target = "address")
    ClientDTO toDto(Client client);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
   // @Mapping(source = "address", target = "address")
    Client toEntity(ClientDTO clientDTO);

    default Client fromId(Long id) {
        if (id == null) {
            return null;
        }
        Client client = new Client();
        client.setId(id);
        return client;
    }
}
