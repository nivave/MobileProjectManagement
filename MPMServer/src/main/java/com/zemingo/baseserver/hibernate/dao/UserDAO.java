package com.zemingo.baseserver.hibernate.dao;

import java.util.List;

import com.zemingo.baseserver.model.User;

public interface UserDAO {
	public void save(User p);

	public List<User> getByNameAndPassword(String userName, String pass);
}
