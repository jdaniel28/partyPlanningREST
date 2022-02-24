package com.party.partymangement.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.party.partymangement.mapper.InviteMapper;
import com.party.partymangement.model.InviteModel;

@Repository
public class InviteDao {

	private final static Logger LOGGER = LoggerFactory.getLogger(InviteDao.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final static String ADD_INVITE = "insert into invitation (photoName,inviteText) values(?,?)";
	private final static String GET_LAST_ID = "select max(inviteId) from invitation;";
	private final static String GET_ALL_INV = "select * from invitation";

	public boolean addInvite(InviteModel invite) {
		LOGGER.debug("Start - addInvite");
		boolean status;
		try {
			status = this.jdbcTemplate.update(ADD_INVITE, invite.getPhotoName(), invite.getInviteText()) != 0;
		} catch (Exception e) {
			status = false;
		}
		LOGGER.debug("End - addInvite");
		return status;
	}

	public int getLastId() {
		LOGGER.debug("Start - getLastId");
		int id = 0;
		try {
			id = this.jdbcTemplate.queryForObject(GET_LAST_ID, Integer.class);
		} catch (Exception e) {
		}
		LOGGER.debug("End - getLastId");
		return id;
	}

	public List<InviteModel> getAllInvites() {
		LOGGER.debug("Inside getAllInvites");
		return this.jdbcTemplate.query(GET_ALL_INV, new InviteMapper());

	}
}
