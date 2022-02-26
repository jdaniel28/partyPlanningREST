package com.party.partymangement.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.party.partymangement.dao.RegisterDao;
import com.party.partymangement.model.RegisterModel;

// TODO: Auto-generated Javadoc
/**
 * The Class RegisterService.
 */
@Service
public class RegisterService {

	/** The register dao. */
	@Autowired
	private RegisterDao registerDao;

	/** The storage service. */
	@Autowired
	private StorageService storageService;

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(RegisterService.class);

	/**
	 * Gets the user.
	 *
	 * @param userId the user id
	 * @return the user
	 */
	public RegisterModel getUser(String userId) {
		LOGGER.info("Inside - getUser");
		return registerDao.getUser(userId);
	}

	/**
	 * Post user.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	public boolean postUser(RegisterModel user) {
		LOGGER.info("Inside - postUser");
		return registerDao.insertUser(user);
	}

	/**
	 * Check login.
	 *
	 * @param user the user
	 * @return the string
	 */
	public String checkLogin(RegisterModel user) {
		LOGGER.info("Inside - checkLogin");
		return this.registerDao.checkLogin(user);
	}

	/**
	 * Gets the user id.
	 *
	 * @param user the user
	 * @return the user id
	 */
	public String getUserId(RegisterModel user) {
		LOGGER.info("Inside - getUserId");
		return this.registerDao.userId(user);
	}

	/**
	 * Forgot password.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	public boolean forgotPassword(RegisterModel user) {
		LOGGER.info("Inside - forgotPassword");
		return this.registerDao.forgotPassword(user);
	}

	/**
	 * Post user password.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	public boolean postUserPassword(RegisterModel user) {
		LOGGER.info("Inside - postUserPassword");
		return this.registerDao.updatePassword(user);
	}

	/**
	 * Upload photo user.
	 *
	 * @param file   the file
	 * @param userId the user id
	 * @return true, if successful
	 */
	public boolean uploadPhotoUser(MultipartFile file, String userId) {
		LOGGER.info("Start - uploadPhotoUser");
		boolean status;
		String fileName = file.getOriginalFilename();
		int i;
		for (i = 0; i < fileName.length(); i++) {
			if (fileName.charAt(i) == '.') {
				break;
			}
		}
		String fileExtenstion = fileName.substring(i, fileName.length());
		String actualFileName = "u_" + userId + fileExtenstion;

		RegisterModel user = new RegisterModel();
		user.setUserId(userId);
		user.setPhotoName(actualFileName);
		if (this.registerDao.uploadPhotoUser(user)) {
			this.storageService.uploadFile(file, actualFileName);
			status = true;
		} else {
			status = false;
		}
		LOGGER.info("End - uploadPhotoUser");
		return status;
	}

	/**
	 * Update user.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	public boolean updateUser(RegisterModel user) {
		LOGGER.info("Inside - updateUser");
		return this.registerDao.updateUser(user);
	}

}
