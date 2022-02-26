package com.party.partymangement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.party.partymangement.dao.InviteeDao;
import com.party.partymangement.model.InviteeDetailsModel;
import com.party.partymangement.model.InviteeModel;

// TODO: Auto-generated Javadoc
/**
 * The Class InviteeService.
 */
@Service
public class InviteeService {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(FeedbackService.class);

	/** The invitee dao. */
	@Autowired
	private InviteeDao inviteeDao;

	/**
	 * Adds the invitee.
	 *
	 * @param invitee the invitee
	 * @return true, if successful
	 */
	public boolean addInvitee(InviteeModel invitee) {
		LOGGER.info("Inside addInvitee");
		return this.inviteeDao.addInvitee(invitee);
	}

	/**
	 * Gets the invited for booking id.
	 *
	 * @param bookingId the booking id
	 * @return the invited for booking id
	 */
	public List<InviteeModel> getInvitedForBookingId(int bookingId) {
		LOGGER.info("Inside getInvitedForBookingId");
		return this.inviteeDao.getInvitedForBookingId(bookingId);
	}

	/**
	 * Gets the all invitee details.
	 *
	 * @param userId the user id
	 * @return the all invitee details
	 */
	public List<InviteeDetailsModel> getAllInviteeDetails(String userId) {
		LOGGER.info("Inside getAllInviteeDetails");
		return this.inviteeDao.getAllInviteeDetails(userId);
	}
}
