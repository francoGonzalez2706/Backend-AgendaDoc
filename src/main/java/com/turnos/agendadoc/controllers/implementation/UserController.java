package com.turnos.agendadoc.controllers.implementation;

import com.turnos.agendadoc.controllers.base.BaseController;
import com.turnos.agendadoc.dtos.User.UserCreateDTO;
import com.turnos.agendadoc.dtos.User.UserDto;
import com.turnos.agendadoc.dtos.User.UserUpdateDTO;
import com.turnos.agendadoc.services.implementation.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController extends BaseController<UserDto, UserCreateDTO, UserUpdateDTO,Long> {

    public UserController(UserService userService) {
        super(userService);
    }
}

