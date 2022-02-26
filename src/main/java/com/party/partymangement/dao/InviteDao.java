package com.party.partymangement.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.party.partymangement.mapper.InviteMapper;
import com.party.partymangement.model.InviteModel;

// TODO: Auto-generated Javadoc
/**
 * The Class InviteDao.
 */
@Repository
public class InviteDao {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(InviteDao.class);

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/** The Constant ADD_INVITE. */
	private final static String ADD_INVITE = "insert into invitation (photoName,inviteText) values(?,?)";

	/** The Constant GET_LAST_ID. */
	private final static String GET_LAST_ID = "select max(greetingId) from invitation;";

	/** The Constant GET_ALL_INV. */
	private final static String GET_ALL_INV = "select * from invitation";

	/**
	 * Adds the invite.
	 *
	 * @param invite the invite
	 * @return true, if successful
	 */
	public boolean addInvite(InviteModel invite) {
		LOGGER.info("Start - addInvite");
		boolean status;
		try {
			status = this.jdbcTemplate.update(ADD_INVITE, invite.getPhotoName(), invite.getInviteText()) != 0;
		} catch (Exception e) {
			status = false;
		}
		LOGGER.info("End - addInvite");
		return status;
	}

	/**
	 * Gets the last id.
	 *
	 * @return the last id
	 */
	public int getLastId() {
		LOGGER.info("Start - getLastId");
		int id = 0;
		try {
			id = this.jdbcTemplate.queryForObject(GET_LAST_ID, Integer.class);
		} catch (Exception e) {
		}
		LOGGER.info("End - getLastId");
		return id;
	}

	/**
	 * Gets the all invites.
	 *
	 * @return the all invites
	 */
	public List<InviteModel> getAllInvites() {
		LOGGER.info("Inside getAllInvites");
		return this.jdbcTemplate.query(GET_ALL_INV, new InviteMapper());

	}
}
