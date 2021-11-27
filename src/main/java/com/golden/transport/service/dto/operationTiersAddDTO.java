package com.golden.transport.service.dto;

import java.io.Serializable;

public class operationTiersAddDTO implements Serializable {

    private Long id;

    private operationCouplageDTO operationCouplage;
    private operationDirectionDTO operationDirection;
    private operationGeneralDetailsDTO operationGeneralDetails;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public operationCouplageDTO getOperationCouplage() {
        return operationCouplage;
    }

    public void setOperationCouplage(operationCouplageDTO operationCouplage) {
        this.operationCouplage = operationCouplage;
    }

    public operationDirectionDTO getOperationDirection() {
        return operationDirection;
    }

    public void setOperationDirection(operationDirectionDTO operationDirection) {
        this.operationDirection = operationDirection;
    }

    public operationGeneralDetailsDTO getOperationGeneralDetails() {
        return operationGeneralDetails;
    }

    public void setOperationGeneralDetails(operationGeneralDetailsDTO operationGeneralDetails) {
        this.operationGeneralDetails = operationGeneralDetails;
    }


}
