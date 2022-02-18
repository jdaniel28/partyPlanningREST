package com.party.partymangement.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.party.partymangement.dao.RegisterDao;
import com.party.partymangement.model.RegisterModel;

@Service
public class RegisterService {

	@Autowired
	private RegisterDao registerDao;
	
	@Autowired
	private StorageService storageService;

	public RegisterModel getUser(String userId) {
		return registerDao.getUser(userId);
	}

	public boolean postUser(RegisterModel user) {
		return registerDao.insertUser(user);
	}

	public String checkLogin(RegisterModel user) {
		return this.registerDao.checkLogin(user);
	}

	public String getUserId(RegisterModel user) {
		return this.registerDao.userId(user);
	}

	public boolean forgotPassword(RegisterModel user) {
		return this.registerDao.forgotPassword(user);
	}

	public boolean postUserPassword(RegisterModel user) {
		return this.registerDao.updatePassword(user);
	}

	public boolean uploadPhotoUser(MultipartFile file,  String userId) {
		String fileName = file.getOriginalFilename();
		int i;
		for (i = 0; i < fileName.length(); i++) {
			if (fileName.charAt(i) == '.') {
				break;
			}
		}
		String fileExtenstion = fileName.substring(i, fileName.length());
		String actualFileName = "u_"+userId + fileExtenstion;
		
		
		RegisterModel user = new RegisterModel();
		user.setUserId(userId);
		user.setPhotoName(actualFileName);
		if(this.registerDao.uploadPhotoUser(user)) {
			this.storageService.uploadFile(file, actualFileName);
			return true;
		}
		
		
		return false;
	}
	
	public boolean updateUser(RegisterModel user) {
		return this.registerDao.updateUser(user);
	}

}
