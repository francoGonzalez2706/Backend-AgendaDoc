package com.turnos.agendadoc.dtos.User;

public record UserCreateDTO(
        String email,
        String password,
        String firstName,
        String lastName,
        String phone
) {}
