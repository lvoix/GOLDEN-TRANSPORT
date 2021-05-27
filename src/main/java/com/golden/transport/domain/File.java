package com.golden.transport.domain;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by BARGUACH on 24/08/2020.
 */

@Entity
@Table(name = "ARCHIVE_FILE")
public class File {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FILE_ID")
    private Long id;
    @Column(name = "FILE_PATH")
    private String path;
    @Column(name = "FILE_URL")
    private String url;
    @Column(name = "FILE_NAME")
    private String name;
    @Column(name = "FILE_ENTITY_TYPE", length = 255, nullable = false)
    private String entityType;
    @Column(name = "FILE_SIZE")
    private Double size;
    @Column(name = "FILE_EXT_TYPE")
    private String extention;
    @Column(name = "FILE_ENTITY_ID", nullable = false)
    private Long entityId;
    @Column(name = "FILE_CREATION_DATE")
    private Date creationDate = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
