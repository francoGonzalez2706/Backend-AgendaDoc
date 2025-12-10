package com.turnos.agendadoc.services.base;

import java.util.List;

public interface BaseService <D, DC, DE, ID>{
    public D save (DC dc);
    public D findById(ID id);
    public List<D> findAll();
    public D update(ID id,DE de);
    public void deleteById(ID id);
}

