package com.golden.transport.service.mapper;


import com.golden.transport.domain.User;
import com.golden.transport.domain.UsersG;
import com.golden.transport.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;




@Mapper(componentModel = "spring", uses = { AddressMapper.class})
public interface UserMapper extends EntityMapper<UserDTO, UsersG> {

    @Mapping(source = "id", target = "id")
    UserDTO toDto(UsersG User);


    @Mapping(source = "id", target = "id")
    UsersG toEntity(UserDTO UserDTO);

    default UsersG fromId(Long id) {
        if (id == null) {
            return null;
        }
        UsersG User = new UsersG();
        User.setId(id);
        return User;
    }
}
