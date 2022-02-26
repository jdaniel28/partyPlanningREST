package com.party.partymangement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.party.partymangement.dao.UserContactDao;
import com.party.partymangement.model.UserContactModel;

// TODO: Auto-generated Javadoc
/**
 * The Class UserContactService.
 */
@Service
public class UserContactService {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(UserContactService.class);

	/** The user contact dao. */
	@Autowired
	private UserContactDao userContactDao;

	/**
	 * Post user contact.
	 *
	 * @param userContact the user contact
	 * @return true, if successful
	 */
	public boolean postUserContact(UserContactModel userContact) {
		LOGGER.info("Inside postUserContact");
		return userContactDao.insertUserContact(userContact);
	}

	/**
	 * Gets the all user contact list.
	 *
	 * @return the all user contact list
	 */
	public List<UserContactModel> getAllUserContactList() {
		LOGGER.info("Inside getAllUserContactList");
		return this.userContactDao.getAllUserContactList();
	}

	/**
	 * Update user.
	 *
	 * @param userContact the user contact
	 * @return true, if successful
	 */
	public boolean updateUser(UserContactModel userContact) {
		LOGGER.info("Inside updateUser");
		return this.userContactDao.updateUserContact(userContact);
	}

	/**
	 * Delete user.
	 *
	 * @param contactId the contact id
	 * @return true, if successful
	 */
	public boolean deleteUser(String contactId) {
		LOGGER.info("Inside deleteUser");
		return this.userContactDao.deleteUserContact(contactId);
	}
}
