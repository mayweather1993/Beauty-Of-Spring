package com.homework.services;

import com.homework.models.AppUser;

public interface UsersService extends CrudService<AppUser> {

    AppUser findByEmail(final String email);

    boolean exist(final String email);

}
