package com.apostas.domain.repository;

import com.apostas.domain.user.User;

public interface UserRepository extends Repository<User, Long> {

    User getByEmail(String email);
}
