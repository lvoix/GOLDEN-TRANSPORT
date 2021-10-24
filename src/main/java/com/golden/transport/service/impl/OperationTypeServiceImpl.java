package com.golden.transport.service.impl;

import com.golden.transport.domain.OperationType;
import com.golden.transport.repository.OperationTypeRepository;
import com.golden.transport.service.dto.OperationTypeDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OperationTypeServiceImpl {

    private final OperationTypeRepository operationTypeRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public OperationTypeDTO getOperationType(Long OperationTypeId) {
        OperationType OperationType = operationTypeRepository.findById(OperationTypeId)
                .orElseThrow( () -> new ResourceNotFoundException("OperationType not exist id: " + OperationTypeId));
        return modelMapper.map(OperationType, OperationTypeDTO.class);
    }

    public List<OperationTypeDTO> getAllOperationTypes() {
        return operationTypeRepository.findAll().stream()
                .map(OperationType -> modelMapper.map(OperationType, OperationTypeDTO.class)).collect(Collectors.toList());
    }
}
