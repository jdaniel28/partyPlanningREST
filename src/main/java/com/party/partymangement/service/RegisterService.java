package com.party.partymangement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.party.partymangement.dao.RegisterDao;
import com.party.partymangement.model.RegisterModel;

@Service
public class RegisterService {

	@Autowired
	private RegisterDao registerDao;

	public List<RegisterModel> getAllUser() {
		return registerDao.getAllUsers();
	}

	public boolean postUser(RegisterModel user) {
		return registerDao.insertUser(user);
	}

	public String checkLogin(RegisterModel user) {
		return this.registerDao.checkLogin(user);
	}

	public String getUserId(RegisterModel user) {
		return this.registerDao.userId(user);
	}

	public boolean forgotPassword(RegisterModel user) {
		return this.registerDao.forgotPassword(user);
	}

	public boolean postUserPassword(RegisterModel user) {
		return this.registerDao.updatePassword(user);
	}

}
