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

	public boolean checkLogin(RegisterModel user) {
		if (this.registerDao.checkLogin(user)) {
			return true;
		}
		return false;
	}

}
