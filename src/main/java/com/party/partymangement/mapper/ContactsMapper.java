package com.party.partymangement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.party.partymangement.model.ContactsModel;

public class ContactsMapper implements RowMapper<ContactsModel> {

	@Override
	public ContactsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		ContactsModel contacts = new ContactsModel();
		contacts.setContactId(rs.getInt("contactId"));
		contacts.setContactNumber(rs.getString("contactNumber"));
		contacts.setEmail(rs.getString("email"));
		contacts.setFirstName(rs.getString("firstName"));
		contacts.setLastName(rs.getString("lastName"));
		contacts.setUserId(rs.getString("userId"));
		return contacts;
	}

}
