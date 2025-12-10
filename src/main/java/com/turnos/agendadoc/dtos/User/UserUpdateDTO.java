package com.turnos.agendadoc.dtos.User;

public record UserUpdateDTO(
        String firstName,
        String lastName,
        String phone,
        Boolean isActive
) {}
