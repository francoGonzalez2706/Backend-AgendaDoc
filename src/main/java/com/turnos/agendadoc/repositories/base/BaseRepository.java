package com.turnos.agendadoc.repositories.base;

import com.turnos.agendadoc.entities.base.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<E extends Base, ID> extends JpaRepository<E,ID> {
    List<E> findAllByDeletedFalse();

    public default List<E> findAll(){
        return findAllByDeletedFalse();
    }
    public default void deleteById(ID id){
        E e = getById(id);
        e.setDeleted(true);
        save(e);
    }

    public Optional<E> findByIdAndDeletedFalse(ID id);

    public default E getById(ID id){
        return findByIdAndDeletedFalse(id).orElseThrow(() -> new NullPointerException("No se encontro o esta eliminada la entidad con id " + id));
    }

}
