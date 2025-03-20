package com.codea.eccomerce.infrastructure.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orderproducts" )
public class OderProductEntity {
    @EmbeddedId
    private OrderProductPK pk;
    private Integer quantity;
}
