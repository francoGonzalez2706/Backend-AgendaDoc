package com.turnos.agendadoc.services.implementation;

import com.turnos.agendadoc.dtos.User.UserCreateDTO;
import com.turnos.agendadoc.dtos.User.UserDto;
import com.turnos.agendadoc.dtos.User.UserUpdateDTO;
import com.turnos.agendadoc.mapper.UserMapper;
import com.turnos.agendadoc.entities.User;
import com.turnos.agendadoc.repositories.UserRepository;
import com.turnos.agendadoc.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements BaseService<UserDto, UserCreateDTO, UserUpdateDTO, Long> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto save(UserCreateDTO userCreateDTO) {
        User user = userMapper.toEntity(userCreateDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    public UserDto findById(Long id) {
        User user = userRepository.getById(id);
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto update(Long id, UserUpdateDTO userUpdateDTO) {
        User user = userRepository.getById(id);

        if (userUpdateDTO.firstName() != null) {
            user.setFirstName(userUpdateDTO.firstName());
        }
        if (userUpdateDTO.lastName() != null) {
            user.setLastName(userUpdateDTO.lastName());
        }
        if (userUpdateDTO.phone() != null) {
            user.setPhone(userUpdateDTO.phone());
        }
        if (userUpdateDTO.isActive() != null) {
            user.setIsActive(userUpdateDTO.isActive());
        }

        User updatedUser = userRepository.save(user);
        return userMapper.toDto(updatedUser);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
