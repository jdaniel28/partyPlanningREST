package com.party.partymangement.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.party.partymangement.mapper.RegisterMapper;
import com.party.partymangement.model.RegisterModel;

// TODO: Auto-generated Javadoc
/**
 * The Class RegisterDao.
 */
@Repository
public class RegisterDao {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(RegisterDao.class);

	/** The select. */
	private final String SELECT = "select * from User where userId = ?;";

	/** The login. */
	private final String LOGIN = "select password from user where userId = ? ";
	// private final String INSERT = "insert into User
	// (firstName,lastName,dOB,gender,contactNumber,userId,password)
	/** The userid. */
	// values(?,?,?,?,?,?,?);";
	private final String USERID = "select userid from Forget_User where ans1 =? and ans2=? and ans3=? ";

	/** The forgot password. */
	private final String FORGOT_PASSWORD = "select userid from Forget_User where userId = ? and ans1 = ? and ans2 = ? and ans3 = ?;";

	/** The insert. */
	private final String INSERT = "insert into User (firstName,lastName,dOB,gender,contactNumber,userId,password, role) values(?,?,?,?,?,?,?,?);";

	/** The insert ans. */
	private final String INSERT_ANS = "insert into Forget_User (userid,ans1,ans2,ans3) values(?,?,?,?);";

	/** The update password. */
	private final String UPDATE_PASSWORD = "update User set password=? where userId=? ";

	/** The get role. */
	private final String GET_ROLE = "select role from User where userId = ?";

	/** The update photo. */
	private final String UPDATE_PHOTO = "update User set photoName = ? where userId = ?";

	/** The update user. */
	private final String UPDATE_USER = "update User set firstName = ?, lastName=?,dOB=?,gender=?,contactNumber=? where userId=?";

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Gets the user.
	 *
	 * @param userId the user id
	 * @return the user
	 */
	public RegisterModel getUser(String userId) {
		LOGGER.info("Inside - getUser");
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

	/**
	 * Update password.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	public boolean updatePassword(RegisterModel user) {
		LOGGER.info("Start - updatePassword");
		boolean status;
		if (jdbcTemplate.update(UPDATE_PASSWORD, user.getPassword(), user.getUserId()) != 0) {
			status = true;
		} else {
			status = false;
		}
		LOGGER.info("End - updatePassword");
		return status;
	}

	/**
	 * Insert user.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	public boolean insertUser(RegisterModel user) {
		LOGGER.info("Start - insertUser");
		boolean status;
		java.sql.Date date = new java.sql.Date(user.getDob().getTime());
		boolean user_table = (jdbcTemplate.update(INSERT, user.getFirstName(), user.getLastName(), date,
				user.getGender(), user.getContactNumber(), user.getUserId(), user.getPassword(), "user") != 0);
		boolean user_security_ans = (jdbcTemplate.update(INSERT_ANS, user.getUserId(), user.getAns1(), user.getAns2(),
				user.getAns3()) != 0);
		if (user_table && user_security_ans) {
			status = true;
		} else {
			status = false;
		}
		LOGGER.info("End - updatePassword");
		return status;
	}

	/**
	 * Check login.
	 *
	 * @param user the user
	 * @return the string
	 */
	public String checkLogin(RegisterModel user) {
		LOGGER.info("Start - checkLogin");
		String loginStatus;
		try {
			String password = this.jdbcTemplate.queryForObject(LOGIN, String.class, new Object[] { user.getUserId() });
			if (password.equals(user.getPassword())) {
				loginStatus = "Logged In";
				String role = this.jdbcTemplate.queryForObject(GET_ROLE, String.class,
						new Object[] { user.getUserId() });
				loginStatus += role;
			} else {
				loginStatus = "Password";
			}
		} catch (Exception e) {
			loginStatus = "UserId";
		}
		LOGGER.info("End - checkLogin");
		return loginStatus;
	}

	/**
	 * User id.
	 *
	 * @param user the user
	 * @return the string
	 */
	public String userId(RegisterModel user) {
		LOGGER.info("Start - userId");
		String userId = "";
		try {
			userId = this.jdbcTemplate.queryForObject(USERID, String.class,
					new Object[] { user.getAns1(), user.getAns2(), user.getAns3() });
		} catch (Exception e) {

		}
		LOGGER.info("End - userId");
		return userId;
	}

	/**
	 * Forgot password.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	public boolean forgotPassword(RegisterModel user) {
		LOGGER.info("Start - forgotPassword");
		boolean status;
		try {
			this.jdbcTemplate.queryForObject(FORGOT_PASSWORD, String.class,
					new Object[] { user.getUserId(), user.getAns1(), user.getAns2(), user.getAns3() });
			status = true;
		} catch (Exception e) {
			status = false;
		}
		LOGGER.info("End - forgotPassword");
		return status;
	}

	/**
	 * Upload photo user.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	public boolean uploadPhotoUser(RegisterModel user) {
		LOGGER.info("Inside - uploadPhotoUser");
		return this.jdbcTemplate.update(UPDATE_PHOTO, user.getPhotoName(), user.getUserId()) != 0;
	}

	/**
	 * Update user.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	public boolean updateUser(RegisterModel user) {
		LOGGER.info("Inside - updateUser");
		return this.jdbcTemplate.update(UPDATE_USER, user.getFirstName(), user.getLastName(), user.getDob(),
				user.getGender(), user.getContactNumber(), user.getUserId()) != 0;
	}

}