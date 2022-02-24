package com.party.partymangement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.party.partymangement.dao.UserContactDao;
import com.party.partymangement.model.UserContactModel;

@Service
public class UserContactService {

	@Autowired
	private UserContactDao userContactDao;

	public boolean postUserContact(UserContactModel userContact) {
		return userContactDao.insertUserContact(userContact);
	}

	public List<UserContactModel> getAllUserContactList() {
		return this.userContactDao.getAllUserContactList();
	}

	public boolean updateUser(UserContactModel userContact) {
		return this.userContactDao.updateUserContact(userContact);
	}

	public boolean deleteUser(String contactId) {
		return this.userContactDao.deleteUserContact(contactId);
	}
}
