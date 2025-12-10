package com.turnos.agendadoc.repositories;

import com.turnos.agendadoc.entities.User;
import com.turnos.agendadoc.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User,Long> {
}