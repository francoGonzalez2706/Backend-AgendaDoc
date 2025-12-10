package com.turnos.agendadoc.entities;

import com.turnos.agendadoc.entities.base.Base;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends Base {
    
    @NotBlank
    @Email
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    
    @NotBlank
    @Column(name = "password", nullable = false)
    private String password;
    
    @NotBlank
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @NotBlank
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @NotBlank
    @Column(name = "phone", nullable = false)
    private String phone;
    
    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
}

