package com.party.partymangement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.party.partymangement.mapper.RegisterMapper;
import com.party.partymangement.model.RegisterModel;

@Repository
public class RegisterDao {

	private final String SELECT = "select * from User;";
	private final String LOGIN = "select password from user where userId = ? ";
	private final String INSERT = "insert into User (firstName,lastName,dOB,gender,contactNumber,userId,password) values(?,?,?,?,?,?,?);";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<RegisterModel> getAllUsers() {
		return jdbcTemplate.query(SELECT, new RegisterMapper());
	}

	public boolean insertUser(RegisterModel user) {
		java.sql.Date date = new java.sql.Date(user.getDob().getTime());
		if (jdbcTemplate.update(INSERT, user.getFirstName(), user.getLastName(), date, user.getGender(),
				user.getContactNumber(), user.getUserId(), user.getPassword()) != 0) {
			return true;
		}
		return false;
	}

	public boolean checkLogin(RegisterModel user) {
		boolean loggedIn;
		try {
			String password = this.jdbcTemplate.queryForObject(LOGIN, String.class, new Object[] { user.getUserId() });
			if (password.equals(user.getPassword())) {
				loggedIn = true;
			} else {
				loggedIn = false;
			}
		} catch (Exception e) {
			loggedIn = false;
		}
		return loggedIn;
	}
}