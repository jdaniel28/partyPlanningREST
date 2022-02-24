package com.party.partymangement.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.party.partymangement.mapper.ContactsMapper;
import com.party.partymangement.model.ContactsModel;

@Repository
public class ContactsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final static Logger LOGGER = LoggerFactory.getLogger(ContactsDao.class);

	private static final String GET_CONTACTS = "select * from contacts where userId = ?";

	public List<ContactsModel> getContactsForUser(String userId) {
		LOGGER.debug("Start - getContactsForUser");
		List<ContactsModel> contacts = new ArrayList<ContactsModel>();
		try {
			contacts = this.jdbcTemplate.query(GET_CONTACTS, new ContactsMapper(), userId);
		} catch (Exception e) {
		}
		LOGGER.debug("End - getContactsForUser");
		return contacts;
	}

}
