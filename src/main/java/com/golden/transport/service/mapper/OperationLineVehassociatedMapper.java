/*
package com.golden.transport.service.mapper;


import com.golden.transport.domain.Vehicule;
import com.golden.transport.service.dto.AssociadToVehiculeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

*/
/**
 * Mapper for the entity {@link OperationLineVehicules} and its DTO {@link OperLineVehDTO}.
 *//*

@Mapper(componentModel = "spring", uses = { VehiculeMapper.class})
public interface OperationLineVehassociatedMapper extends EntityMapper<Vehicule, AssociadToVehiculeDTO> {

    @Mapping(source = "id", target = "id")
    //@Mapping(source = "operations", target = "operations")
    //@Mapping(source = "vehicules", target = "vehicules")
    AssociadToVehiculeDTO toDto(Vehicule vehicule);


    @Mapping(source = "id", target = "id")
  //  @Mapping(source = "operations", target = "operations")
    //@Mapping(source = "vehicules", target = "vehicules")
    Vehicule toEntity(AssociadToVehiculeDTO associadTovehiculeDTO);

    default Vehicule fromId(Long id) {
        if (id == null) {
            return null;
        }
        Vehicule vehicule = new Vehicule();
        vehicule.setId(id);
        return vehicule;
    }
}
*/
