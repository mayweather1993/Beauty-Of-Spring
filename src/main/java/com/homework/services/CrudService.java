package com.homework.services;

import java.util.UUID;

public interface CrudService<T> {
    T create(final T entity);

    T findById(final UUID id);
}
