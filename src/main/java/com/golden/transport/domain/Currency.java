package com.golden.transport.domain;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



@Entity
@Table(name = "CURRENCY")
public class Currency implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NAME", length = 255)
    private String name;
    @Column(name = "SYMBOLE", length = 255)
    private String symbole;
    @Column(name = "CODE", length = 255)
    private String code;

    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date dateCreation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", symbole='" + symbole + '\'' +
                ", code='" + code + '\'' +
                ", dateCreation=" + dateCreation +
                '}';
    }
}

