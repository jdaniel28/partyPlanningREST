package com.party.partymangement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.party.partymangement.mapper.RegisterMapper;
import com.party.partymangement.model.RegisterModel;

@Repository
public class RegisterDao {

	private final String SELECT = "select * from User where userId = ?;";
	private final String LOGIN = "select password from user where userId = ? ";
	// private final String INSERT = "insert into User
	// (firstName,lastName,dOB,gender,contactNumber,userId,password)
	// values(?,?,?,?,?,?,?);";
	private final String USERID = "select userid from Forget_User where ans1 =? and ans2=? and ans3=? ";
	private final String FORGOT_PASSWORD = "select userid from Forget_User where userId = ? and ans1 = ? and ans2 = ? and ans3 = ?;";
	private final String INSERT = "insert into User (firstName,lastName,dOB,gender,contactNumber,userId,password, role) values(?,?,?,?,?,?,?,?);";
	private final String INSERT_ANS = "insert into Forget_User (userid,ans1,ans2,ans3) values(?,?,?,?);";
	private final String UPDATE_PASSWORD = "update User set password=? where userId=? ";
	private final String GET_ROLE = "select role from User where userId = ?";
	private final String UPDATE_PHOTO = "update User set photoName = ? where userId = ?";
	private final String UPDATE_USER = "update User set firstName = ?, lastName=?,dOB=?,gender=?,contactNumber=? where userId=?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public RegisterModel getUser(String userId) {
		return jdbcTemplate.queryForObject(SELECT, new RegisterMapper(), new Object[] { userId });
	}

//	public boolean insertUser(RegisterModel user) {
//		java.sql.Date date = new java.sql.Date(user.getDob().getTime());
//		if (jdbcTemplate.update(INSERT, user.getFirstName(), user.getLastName(), date, user.getGender(),
//				user.getContactNumber(), user.getUserId(), user.getPassword()) != 0) {
//			return true;
//		}
//		return false;
//	}

	public boolean updatePassword(RegisterModel user) {
		if (jdbcTemplate.update(UPDATE_PASSWORD, user.getPassword(), user.getUserId()) != 0) {
			return true;
		}
		return false;
	}

	public boolean insertUser(RegisterModel user) {
		java.sql.Date date = new java.sql.Date(user.getDob().getTime());
		boolean user_table = (jdbcTemplate.update(INSERT, user.getFirstName(), user.getLastName(), date,
				user.getGender(), user.getContactNumber(), user.getUserId(), user.getPassword(), "user") != 0);
		boolean user_security_ans = (jdbcTemplate.update(INSERT_ANS, user.getUserId(), user.getAns1(), user.getAns2(),
				user.getAns3()) != 0);
		if (user_table && user_security_ans) {
			return true;
		}
		return false;
	}

	public String checkLogin(RegisterModel user) {
		String loginStatus;
		try {
			String password = this.jdbcTemplate.queryForObject(LOGIN, String.class, new Object[] { user.getUserId() });
			if (password.equals(user.getPassword())) {
				loginStatus = "Logged In";
				String role = this.jdbcTemplate.queryForObject(GET_ROLE, String.class,
						new Object[] { user.getUserId() });
				loginStatus += role;
				System.out.println(loginStatus);
			} else {
				loginStatus = "Password";
			}
		} catch (Exception e) {
			loginStatus = "UserId";
		}
		return loginStatus;
	}

	public String userId(RegisterModel user) {
		String userId = "";
		try {
			userId = this.jdbcTemplate.queryForObject(USERID, String.class,
					new Object[] { user.getAns1(), user.getAns2(), user.getAns3() });
		} catch (Exception e) {

		}

		return userId;
	}

	public boolean forgotPassword(RegisterModel user) {
		boolean status;
		try {
			this.jdbcTemplate.queryForObject(FORGOT_PASSWORD, String.class,
					new Object[] { user.getUserId(), user.getAns1(), user.getAns2(), user.getAns3() });
			status = true;
		} catch (Exception e) {
			status = false;
		}
		return status;
	}

	public boolean uploadPhotoUser(RegisterModel user) {
		return this.jdbcTemplate.update(UPDATE_PHOTO, user.getPhotoName(), user.getUserId()) != 0;
	}

	public boolean updateUser(RegisterModel user) {
		return this.jdbcTemplate.update(UPDATE_USER,user.getFirstName(),user.getLastName(),user.getDob(),user.getGender(),user.getContactNumber(),user.getUserId()) !=0;
	}
	
}