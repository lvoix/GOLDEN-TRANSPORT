package com.golden.transport.rest;

import com.golden.transport.response.ListResponse;
import com.golden.transport.response.SingleResponse;
import com.golden.transport.service.dto.OperationTypeDTO;
import com.golden.transport.service.impl.OperationTypeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.websocket.server.PathParam;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class OperationTypeResource {
    private final OperationTypeServiceImpl operationTypeService;

    @GetMapping(value = "/operationType/type")
    public SingleResponse<OperationTypeDTO> getOperationType(@PathParam("OperationTypeId") Long OperationTypeId) {
        return new SingleResponse<>(operationTypeService.getOperationType(OperationTypeId));
    }

    @GetMapping(value = "/operationType/all")
    public ListResponse<OperationTypeDTO> getAllOperationTypes() {
        return new ListResponse<>(operationTypeService.getAllOperationTypes());
    }

}

