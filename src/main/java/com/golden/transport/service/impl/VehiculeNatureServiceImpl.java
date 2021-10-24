package com.golden.transport.service.impl;

import com.golden.transport.domain.VehiculeNature;
import com.golden.transport.repository.VehiculeNatureRepository;
import com.golden.transport.service.dto.VehiculeNatureDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehiculeNatureServiceImpl {

    private final VehiculeNatureRepository vehiculeNatureRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public VehiculeNatureDTO getVehiculeNature(Long vehiculeNatureId) {
        VehiculeNature vehiculeNature = vehiculeNatureRepository.findById(vehiculeNatureId)
                .orElseThrow( () -> new ResourceNotFoundException("VehiculeNature not exist id: " + vehiculeNatureId));
        return modelMapper.map(vehiculeNature, VehiculeNatureDTO.class);
    }

    public List<VehiculeNatureDTO> getAllVehiculeNatures() {
        return vehiculeNatureRepository.findAll().stream()
                .map(vehiculeNature -> modelMapper.map(vehiculeNature, VehiculeNatureDTO.class)).collect(Collectors.toList());
    }
}
