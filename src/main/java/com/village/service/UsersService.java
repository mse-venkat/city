package com.village.service;

import com.village.entity.Users;

public interface UsersService {
	void save(Users user);

    Users findByEmail(String email);
}
