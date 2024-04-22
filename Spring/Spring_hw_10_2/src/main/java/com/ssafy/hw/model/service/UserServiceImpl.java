package com.ssafy.hw.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hw.model.dao.UserDao;
import com.ssafy.hw.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@Autowired
	public void setUserRepo(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserDao getUserRepo() {
		return this.userDao;
	}

	@Override
	public int insert(User user) {
		return userDao.insert(user);
	}

	@Override
	public User searchById(String id) {
		return userDao.searchById(id);
	}

	@Override
	public List<User> selectAll() {
		return userDao.selectAll();
	}

	@Override
	public User searchByName(String Name) {
		return userDao.searchByName(Name);
	}
}