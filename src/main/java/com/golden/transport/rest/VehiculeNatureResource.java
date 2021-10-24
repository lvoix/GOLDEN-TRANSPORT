package com.golden.transport.rest;

import com.golden.transport.response.ListResponse;
import com.golden.transport.response.SingleResponse;
import com.golden.transport.service.dto.OperationTypeDTO;
import com.golden.transport.service.dto.VehiculeNatureDTO;
import com.golden.transport.service.impl.OperationTypeServiceImpl;
import com.golden.transport.service.impl.VehiculeNatureServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class VehiculeNatureResource {
    private final VehiculeNatureServiceImpl vehiculeNatureService;

    @GetMapping(value = "/vehiculeNature/id")
    public SingleResponse<VehiculeNatureDTO> getVehiculeNature(@RequestParam(defaultValue = "id")  String id) {
        long idvn = Long.valueOf(id).longValue();
        return new SingleResponse<>(vehiculeNatureService.getVehiculeNature(idvn));
    }

    @GetMapping(value = "/vehiculeNature/all")
    public ListResponse<VehiculeNatureDTO> getAllVehiculeNatures() {
        return new ListResponse<>(vehiculeNatureService.getAllVehiculeNatures());
    }

}

