package com.codea.eccomerce.infrastructure.entity;

import com.codea.eccomerce.domain.Auditable;
import com.codea.eccomerce.infrastructure.configuration.AuditingEntityListener;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orderproducts" )
@EntityListeners(AuditingEntityListener.class)
public class OderProductEntity extends Auditable {
    @EmbeddedId
    private OrderProductPK pk;
    private Integer quantity;
}
