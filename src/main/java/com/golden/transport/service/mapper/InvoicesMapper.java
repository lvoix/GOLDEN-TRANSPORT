package com.golden.transport.service.mapper;


import com.golden.transport.domain.Invoice;
import com.golden.transport.service.dto.InvoicesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity {@link Invoice} and its DTO {@link InvoicesDTO}.
 */
@Mapper(componentModel = "spring", uses = { })
public interface InvoicesMapper extends EntityMapper<InvoicesDTO, Invoice> {

    @Mapping(source = "id", target = "id")
    InvoicesDTO toDto(Invoice invoice);


    @Mapping(source = "id", target = "id")
    Invoice toEntity(InvoicesDTO invoicesDTO);

    default Invoice fromId(String id) {
        if (id == null) {
            return null;
        }
        Invoice invoice = new Invoice();
        invoice.setId(id);
        return invoice;
    }
}
