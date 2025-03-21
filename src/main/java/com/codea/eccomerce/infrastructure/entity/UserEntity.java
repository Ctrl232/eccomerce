package com.codea.eccomerce.infrastructure.entity;

import com.codea.eccomerce.domain.Auditable;
import com.codea.eccomerce.domain.UserType;
import com.codea.eccomerce.infrastructure.configuration.AuditingEntityListener;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class UserEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String cellphone;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserType userType;
}

