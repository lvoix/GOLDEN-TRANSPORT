/*
package com.golden.transport.service.mapper;


import com.golden.transport.domain.Role;
import com.golden.transport.service.dto.RoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

*/
/**
 * Mapper for the entity {@link Role} and its DTO {@link RoleDTO}.
 *//*

@Mapper(componentModel = "spring", uses = { })
public interface RoleMapper extends EntityMapper<RoleDTO, Role> {

    @Mapping(source = "id", target = "id")
    RoleDTO toDto(Role Role);


    @Mapping(source = "id", target = "id")
    Role toEntity(RoleDTO roleDTO);

    default Role fromId(Long id) {
        if (id == null) {
            return null;
        }
        Role Role = new Role();
        Role.setId(id);
        return Role;
    }
}
*/
