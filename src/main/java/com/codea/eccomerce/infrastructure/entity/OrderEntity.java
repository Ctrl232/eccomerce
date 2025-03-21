package com.codea.eccomerce.infrastructure.entity;

import com.codea.eccomerce.domain.Auditable;
import com.codea.eccomerce.infrastructure.configuration.AuditingEntityListener;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
@EntityListeners(AuditingEntityListener.class)
public class OrderEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
