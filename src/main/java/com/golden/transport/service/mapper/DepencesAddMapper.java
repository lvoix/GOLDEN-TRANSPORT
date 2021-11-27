package com.golden.transport.service.mapper;


import com.golden.transport.domain.Depences;
import com.golden.transport.service.dto.DepencesAddDTO;
import com.golden.transport.service.dto.DepencesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {})
public interface DepencesAddMapper extends EntityMapper<DepencesAddDTO, Depences> {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "depenceId", target = "depenceId")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "operations", target = "operations")
    DepencesAddDTO toDto(Depences depences);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "depenceId", target = "depenceId")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "operations", target = "operations")
    Depences toEntity(DepencesAddDTO depencesDTO);

    default Depences fromId(Long id) {
        if (id == null) {
            return null;
        }
        Depences depences = new Depences();
        depences.setId(id);
        return depences;
    }
}
