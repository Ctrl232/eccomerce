package com.codea.eccomerce.infrastructure.configuration;


import com.codea.eccomerce.domain.Auditable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.security.Principal;

public class AuditingEntityListener {

    @PrePersist
    public void setCreatedBy(Auditable auditable) {
        auditable.setCreatedBy(getCurrentUser());
        auditable.setUpdatedBy(getCurrentUser());
    }

    @PreUpdate
    public void setUpdatedBy(Auditable auditable) {
        auditable.setUpdatedBy(getCurrentUser());
    }

    private String getCurrentUser() {

        return "admin";
    }
}
