package com.codea.eccomerce.infrastructure.dto;

import com.codea.eccomerce.domain.User;
import com.codea.eccomerce.domain.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {
    private String username;
    @NotBlank (message = "Nombre es requerido")
    private String firstName;
    @NotBlank (message = "Apellido es requerido")
    private String lastName;
    @Email(message = "Debe ingresar un email valido")
    private String email;
    @NotBlank (message = "Dirección es requerida")
    private String address;
    @NotBlank (message = "Telefono es requerido")
    private String cellphone;
    @NotBlank (message = "Clave es requerida")
    private String password;

    public User userDto() {
        return new User(null,this.getEmail(), this.getFirstName(), this.getLastName(), this.getEmail(), this.getAddress(), this.getCellphone(), this.getPassword(), UserType.USER, LocalDateTime.now());
    }
}
