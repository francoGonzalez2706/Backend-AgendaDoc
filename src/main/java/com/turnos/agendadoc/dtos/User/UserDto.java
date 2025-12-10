package com.turnos.agendadoc.dtos.User;

public record UserDto(
        Long id,
        String email,
        String firstName,
        String lastName,
        String phone,
        Boolean isActive
) {}