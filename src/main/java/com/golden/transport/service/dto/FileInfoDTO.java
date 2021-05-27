package com.golden.transport.service.dto;

public class FileInfoDTO {

    private Long id;
    private String result;
    private Long entityId;
    private String entityType;
    private String name;
    private String url;
    private String path;
    private Double size;
    private String extention;

    public FileInfoDTO() {
    }

    public FileInfoDTO(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public FileInfoDTO(Long id, String result, Long entityId, String entityType, String name, String url, String path, String extention, Double size) {
        this.id = id;
        this.result = result;
        this.entityId = entityId;
        this.entityType = entityType;
        this.name = name;
        this.url = url;
        this.path = path;
        this.size = size;
        this.extention = extention;


    }

    public String getPath() {
        return path;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getExtention() {
        return extention;
    }

    public void setExtention(String extention) {
        this.extention = extention;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    @Override
    public String toString() {
        return "FileInfoDTO{" +
                "id=" + id +
                ", result='" + result + '\'' +
                ", entityId=" + entityId +
                ", entityType='" + entityType + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }


}
