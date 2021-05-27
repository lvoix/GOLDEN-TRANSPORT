package com.golden.transport.service.mapper;


import com.golden.transport.domain.OperationLineConducteurs;
import com.golden.transport.service.dto.OperLineConDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = { OperationMapper.class, ConducteurMapper.class})
public interface OperationLineConMapper extends EntityMapper<OperLineConDTO, OperationLineConducteurs> {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "operations", target = "operations")
    //@Mapping(source = "conducteurs", target = "conducteurs")
    OperLineConDTO toDto(OperationLineConducteurs operationLineConducteurs);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "operations", target = "operations")
    //@Mapping(source = "conducteurs", target = "conducteurs")
    OperationLineConducteurs toEntity(OperLineConDTO operLineConDTO);

    default OperationLineConducteurs fromId(Long id) {
        if (id == null) {
            return null;
        }
        OperationLineConducteurs operationLineConducteurs = new OperationLineConducteurs();
        operationLineConducteurs.setId(id);
        return operationLineConducteurs;
    }
}
