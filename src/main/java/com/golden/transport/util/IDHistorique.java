package com.golden.transport.util;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class IDHistorique implements Serializable {

    @Column(name = "Idop", nullable = false)
    private Long idop;

    @Column(name = "Version", nullable = false)
    private int version;

    public Long getIdop() {
        return idop;
    }

    public void setIdop(Long idop) {
        this.idop = idop;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
