package com.golden.transport.service.mapper;


import com.golden.transport.domain.Contact;
import com.golden.transport.service.dto.ContactDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link contact} and its DTO {@link contactDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ContactMapper extends EntityMapper<ContactDTO, Contact> {


    default Contact fromId(Long id) {
        if (id == null) {
            return null;
        }
        Contact contact = new Contact();
        contact.setId(id);
        return contact;
    }
}
