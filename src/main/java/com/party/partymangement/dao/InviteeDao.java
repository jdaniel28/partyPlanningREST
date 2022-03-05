package com.party.partymangement.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.party.partymangement.mapper.InviteeDetailsMapper;
import com.party.partymangement.mapper.InviteeMapper;
import com.party.partymangement.model.InviteeDetailsModel;
import com.party.partymangement.model.InviteeModel;
import com.party.partymangement.util.Util;

// TODO: Auto-generated Javadoc
/**
 * The Class InviteeDao.
 */
@Repository
public class InviteeDao {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(InviteeDao.class);

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/** The Constant ADD_INVITEE. */
	private static final String ADD_INVITEE = "insert into invitees(bookingId,contactId,greetingId) values(?,?,?)";

	/** The Constant GET_INVITED. */
	private static final String GET_INVITED = "select * from invitees where bookingId = ?";

	/** The Constant GET_INVITEES. */
	private static final String GET_INVITEES = "select i.bookingId, i.contactId, g.photoName, g.inviteText, c.name from invitees as i join invitation as g on i.greetingId=g.greetingId join contacts as c on c.contactId= i.contactId where c.userId = ?;";

	/**
	 * Adds the invitee.
	 *
	 * @param invitee the invitee
	 * @return true, if successful
	 */
	public boolean addInvitee(InviteeModel invitee) {
		LOGGER.info("Start - addInvitee");
		boolean status;
		try {
			status = this.jdbcTemplate.update(ADD_INVITEE, invitee.getBookingId(), invitee.getContactId(),
					Util.convertIdToInt(invitee.getGreetingId())) != 0;
		} catch (Exception e) {
			status = false;
		}
		LOGGER.info("End - addInvitee");
		return status;
	}

	/**
	 * Gets the invited for booking id.
	 *
	 * @param bookingId the booking id
	 * @return the invited for booking id
	 */
	public List<InviteeModel> getInvitedForBookingId(int bookingId) {
		LOGGER.info("Start - getInvitedForBooking");
		List<InviteeModel> invitees = new ArrayList<InviteeModel>();
		try {
			invitees = this.jdbcTemplate.query(GET_INVITED, new InviteeMapper(), bookingId);
		} catch (Exception e) {
		}
		LOGGER.info("End - getInvitedForBooking");
		return invitees;
	}

	/**
	 * Gets the all invitee details.
	 *
	 * @param userId the user id
	 * @return the all invitee details
	 */
	public List<InviteeDetailsModel> getAllInviteeDetails(String userId) {
		LOGGER.info("Start - getAllInviteeDetails");
		List<InviteeDetailsModel> invitees = new ArrayList<InviteeDetailsModel>();
		try {
			invitees = this.jdbcTemplate.query(GET_INVITEES, new InviteeDetailsMapper(), userId);
		} catch (Exception e) {

		}
		LOGGER.info("End - getAllInviteeDetails");
		return invitees;

	}

}
