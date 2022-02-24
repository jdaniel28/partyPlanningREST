package com.party.partymangement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.party.partymangement.mapper.UserContactMapper;
import com.party.partymangement.model.UserContactModel;

@Repository
public class UserContactDao {

	private final String INSERT_USER_CONTACT = "insert into contacts (userId,name,contactNumber,email) values(?,?,?,?);";
	private final String SELECT_USER_CONTACT = "select * from contacts;";
	private final String EDIT_USER_CONTACT = "update contacts set name = ?,contactNumber = ?,email = ? where contactId = ?";
	private final String DELETE_USER_CONTACT = "delete from contacts where contactId = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean insertUserContact(UserContactModel userContact) {
		if (jdbcTemplate.update(INSERT_USER_CONTACT, userContact.getUserId(), userContact.getName(),
				userContact.getContactNumber(), userContact.getEmail()) != 0) {
			return true;
		}
		return false;
	}

	public List<UserContactModel> getAllUserContactList() {
		return this.jdbcTemplate.query(SELECT_USER_CONTACT, new UserContactMapper());
	}

	public boolean updateUserContact(UserContactModel userContact) {
		boolean status;
		try {
			status = this.jdbcTemplate.update(EDIT_USER_CONTACT, userContact.getName(), userContact.getContactNumber(),
					userContact.getEmail(), userContact.getContactId()) != 0;
		} catch (Exception e) {
			status = false;
		}
		return status;

	}

	public boolean deleteUserContact(String contactId) {
		boolean status;
		try {
			status = this.jdbcTemplate.update(DELETE_USER_CONTACT, contactId) != 0;
		} catch (Exception e) {
			status = false;
		}
		return status;
	}

}
