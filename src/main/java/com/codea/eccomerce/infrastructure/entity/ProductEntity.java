package com.codea.eccomerce.infrastructure.entity;

import com.codea.eccomerce.domain.Auditable;
import com.codea.eccomerce.infrastructure.configuration.AuditingEntityListener;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ProductEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String name;
    private String description;
    private String image;
    private BigDecimal price;

    @ManyToOne
    private UserEntity userEntity;
}

