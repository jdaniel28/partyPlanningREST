package com.party.partymangement.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.party.partymangement.mapper.VenueMapper;
import com.party.partymangement.model.VenueModel;

// TODO: Auto-generated Javadoc
/**
 * The Class VenueDao.
 */
@Repository
public class VenueDao {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(VenueDao.class);

	/** The get last id. */
	private final String GET_LAST_ID = "select max(venueId) from venue;";

	/** The get venue. */
	private final String GET_VENUE = "select * from venue where venueId = ?";

	/** The get all venues. */
	private final String GET_ALL_VENUES = "select * from venue";

	/** The insert venue. */
	private final String INSERT_VENUE = "insert into venue (venueName,venueType,venueDesc,photoName) values(?,?,?,?);";

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Insert venue.
	 *
	 * @param venue the venue
	 * @return true, if successful
	 */
	public boolean insertVenue(VenueModel venue) {
		LOGGER.info("Start - insertVenue");
		boolean status;
		if (jdbcTemplate.update(INSERT_VENUE, venue.getVenueName(), venue.getVenueType(), venue.getVenueDescription(),
				venue.getPhotoName()) != 0) {
			status = true;
		} else {
			status = false;
		}
		LOGGER.info("End - insertVenue");
		return status;
	}

	/**
	 * Gets the venue.
	 *
	 * @param venueId the venue id
	 * @return the venue
	 */
	public VenueModel getVenue(int venueId) {
		LOGGER.info("Inside getVenue");
		return jdbcTemplate.queryForObject(GET_VENUE, new VenueMapper(), venueId);
	}

	/**
	 * Gets the all venues.
	 *
	 * @return the all venues
	 */
	public List<VenueModel> getAllVenues() {
		LOGGER.info("Inside getAllVenues");
		return this.jdbcTemplate.query(GET_ALL_VENUES, new VenueMapper());
	}

	/**
	 * Gets the last id.
	 *
	 * @return the last id
	 */
	public int getLastId() {
		LOGGER.info("Start - getLastId");
		int index = 0;
		try {
			index = this.jdbcTemplate.queryForObject(GET_LAST_ID, Integer.class);
		} catch (Exception e) {
		}
		LOGGER.info("End - getLastId");
		return index;
	}

}
