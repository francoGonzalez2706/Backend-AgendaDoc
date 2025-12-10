package com.turnos.agendadoc.mapper.Base;


public interface BaseMapper<E, DC, D> {

    public E toEntity(DC d);

    public D toDto(E e);

}