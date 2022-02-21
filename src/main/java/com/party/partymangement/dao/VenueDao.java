package com.party.partymangement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.party.partymangement.mapper.VenueMapper;
import com.party.partymangement.model.VenueModel;

@Repository
public class VenueDao {

	private final String GET_VENUE = "select * from venue where venueId = ?";
	private final String GET_ALL_VENUES = "select * from venue";
	private final String INSERT_VENUE = "insert into venue (venueId,venueName,venueType,venueDesc,photoName) values(?,?,?,?,?);";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean insertVenue(VenueModel venue) {
		if (jdbcTemplate.update(INSERT_VENUE, venue.getVenueId(), venue.getVenueName(), venue.getVenueType(),
				venue.getVenueDescription(), venue.getPhotoName()) != 0) {
			return true;
		}
		return false;
	}

	public VenueModel getVenue(String venueId) {
		return jdbcTemplate.queryForObject(GET_VENUE, new VenueMapper(), venueId);
	}

	public List<VenueModel> getAllVenues() {
		return this.jdbcTemplate.query(GET_ALL_VENUES, new VenueMapper());
	}

}
