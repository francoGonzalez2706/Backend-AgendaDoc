package com.turnos.agendadoc.mapper;

import com.turnos.agendadoc.dtos.User.UserCreateDTO;
import com.turnos.agendadoc.dtos.User.UserDto;
import com.turnos.agendadoc.mapper.Base.BaseMapper;
import com.turnos.agendadoc.entities.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements BaseMapper<User, UserCreateDTO, UserDto> {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public User toEntity(UserCreateDTO source) {
        if (source == null) return null;

        User user = new User();
        user.setFirstName(source.firstName());
        user.setLastName(source.lastName());
        user.setEmail(source.email());
        user.setPassword(passwordEncoder.encode(source.password()));
        user.setPhone(source.phone());
        return user;
    }

    @Override
    public UserDto toDto(User user) {
        if (user == null) return null;

        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhone(),
                user.getIsActive()
        );
    }
}
