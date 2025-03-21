package com.codea.eccomerce.infrastructure.entity;

import com.codea.eccomerce.domain.Auditable;
import com.codea.eccomerce.infrastructure.configuration.AuditingEntityListener;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "stock")
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class StockEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer unitIn;
    private Integer unitOut;
    private String description;
    private Integer balance;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ProductEntity productEntity;
}

