package com.fyzapps.springmvc.services;

import java.util.List;

public interface CRUDService<T> {

    List<?> getAll();

    T getById(Integer id);

    T saveOrUpdate(T domainObject);

    void delete(Integer id);
}
