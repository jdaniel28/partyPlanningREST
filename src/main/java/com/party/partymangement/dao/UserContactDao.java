package com.party.partymangement.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.party.partymangement.mapper.UserContactMapper;
import com.party.partymangement.model.UserContactModel;

// TODO: Auto-generated Javadoc
/**
 * The Class UserContactDao.
 */
@Repository
public class UserContactDao {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(UserContactDao.class);

	/** The insert user contact. */
	private final String INSERT_USER_CONTACT = "insert into contacts (userId,name,contactNumber,email) values(?,?,?,?);";

	/** The select user contact. */
	private final String SELECT_USER_CONTACT = "select * from contacts;";

	/** The edit user contact. */
	private final String EDIT_USER_CONTACT = "update contacts set name = ?,contactNumber = ?,email = ? where contactId = ?";

	/** The delete user contact. */
	private final String DELETE_USER_CONTACT = "delete from contacts where contactId = ?";

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Insert user contact.
	 *
	 * @param userContact the user contact
	 * @return true, if successful
	 */
	public boolean insertUserContact(UserContactModel userContact) {
		LOGGER.info("Start - insertUserContact");
		boolean status;
		status = jdbcTemplate.update(INSERT_USER_CONTACT, userContact.getUserId(), userContact.getName(),
				userContact.getContactNumber(), userContact.getEmail()) != 0;
		LOGGER.info("End - insertUserContact");
		return status;
	}

	/**
	 * Gets the all user contact list.
	 *
	 * @return the all user contact list
	 */
	public List<UserContactModel> getAllUserContactList() {
		LOGGER.info("Inside getAllUserContactList");
		return this.jdbcTemplate.query(SELECT_USER_CONTACT, new UserContactMapper());
	}

	/**
	 * Update user contact.
	 *
	 * @param userContact the user contact
	 * @return true, if successful
	 */
	public boolean updateUserContact(UserContactModel userContact) {
		LOGGER.info("Start - updateUserContact");
		boolean status;
		try {
			status = this.jdbcTemplate.update(EDIT_USER_CONTACT, userContact.getName(), userContact.getContactNumber(),
					userContact.getEmail(), userContact.getContactId()) != 0;
		} catch (Exception e) {
			status = false;
		}
		LOGGER.info("End - updateUserContact");
		return status;

	}

	/**
	 * Delete user contact.
	 *
	 * @param contactId the contact id
	 * @return true, if successful
	 */
	public boolean deleteUserContact(String contactId) {
		LOGGER.info("Start - deleteUserContact");
		boolean status;
		try {
			status = this.jdbcTemplate.update(DELETE_USER_CONTACT, contactId) != 0;
		} catch (Exception e) {
			status = false;
		}
		LOGGER.info("End - deleteUserContact");
		return status;
	}

}
