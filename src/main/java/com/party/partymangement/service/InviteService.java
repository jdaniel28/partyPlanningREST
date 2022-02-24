package com.party.partymangement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.party.partymangement.dao.InviteDao;
import com.party.partymangement.model.InviteModel;

@Service
public class InviteService {

	private final static Logger LOGGER = LoggerFactory.getLogger(InviteService.class);

	@Autowired
	private InviteDao inviteDao;

	@Autowired
	private StorageService storageService;

	public boolean addInvite(MultipartFile file, InviteModel invite) {
		LOGGER.info("Start - addInvite");
		String fileName = file.getOriginalFilename();
		int i;
		for (i = 0; i < fileName.length(); i++) {
			if (fileName.charAt(i) == '.') {
				break;
			}
		}
		String fileExtenstion = fileName.substring(i, fileName.length());
		String actualFileName = "i_";
		int lastId = this.inviteDao.getLastId();
		++lastId;
		String idString = String.valueOf(lastId);
		actualFileName += idString + fileExtenstion;
		invite.setPhotoName(actualFileName);

		boolean status = this.inviteDao.addInvite(invite);
		this.storageService.uploadFile(file, actualFileName);
		LOGGER.info("End - addInvite");
		return status;
	}

	public List<InviteModel> getAllInvites() {
		LOGGER.info("Inside getAllInvites");
		return this.inviteDao.getAllInvites();
	}

}
