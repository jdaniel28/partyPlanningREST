package com.party.partymangement.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.party.partymangement.mapper.VenueMapper;
import com.party.partymangement.model.VenueModel;

@Repository
public class VenueDao {

	private final static Logger LOGGER = LoggerFactory.getLogger(VenueDao.class);

	private final String GET_LAST_ID = "select max(venueId) from venue;";
	private final String GET_VENUE = "select * from venue where venueId = ?";
	private final String GET_ALL_VENUES = "select * from venue";
	private final String INSERT_VENUE = "insert into venue (venueName,venueType,venueDesc,photoName) values(?,?,?,?);";

	@Autowired
	private JdbcTemplate jdbcTemplate;

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

	public VenueModel getVenue(int venueId) {
		LOGGER.info("Inside getVenue");
		return jdbcTemplate.queryForObject(GET_VENUE, new VenueMapper(), venueId);
	}

	public List<VenueModel> getAllVenues() {
		LOGGER.info("Inside getAllVenues");
		return this.jdbcTemplate.query(GET_ALL_VENUES, new VenueMapper());
	}

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
