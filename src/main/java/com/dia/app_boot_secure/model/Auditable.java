package com.dia.app_boot_secure.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;

import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;
import static org.springframework.data.jpa.domain.AbstractAuditable_.lastModifiedBy;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable <U> {
    @CreatedBy
    protected U createdBy;

    @CreatedDate
    @Temporal(TIMESTAMP)
    protected U createdDate;

    @LastModifiedBy
    protected U lastModifiedDate;

    @LastModifiedBy
    @Temporal(TIMESTAMP)
    protected Date lastModifiedBy;

    public U getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(U createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return (Date) createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = (U) createdDate;
    }

    public U getLastModifiedBy() {
        return (U) lastModifiedBy;
    }

    public void setLastModifiedBy(U lastModifiedBy) {
        this.lastModifiedBy = (Date) lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return (Date) lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = (U) lastModifiedDate;
    }
}
