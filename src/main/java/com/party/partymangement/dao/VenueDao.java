package com.party.partymangement.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.party.partymangement.mapper.VenueMapper;
import com.party.partymangement.model.VenueModel;

@Repository
public class VenueDao {

	
	private final String INSERTVENUE = "insert into venue (venueId,venueName,venueType) values(?,?,?);";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean insertVenue(VenueModel venue) {
		if (jdbcTemplate.update(INSERTVENUE, venue.getVenueId(), venue.getVenueName(), venue.getVenueType()) != 0) {
			return true;
		}
		return false;
	}
	
}
