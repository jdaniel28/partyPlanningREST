package com.party.partymangement.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.party.partymangement.mapper.VenueMapper;
import com.party.partymangement.model.FeedbackModel;
import com.party.partymangement.model.VenueModel;

@Repository
public class FeedbackDao {

	
	private final String INSERTFEEDBACK = "insert into feedback(userId,venueId, ans1,ans2,ans3,rating) values(?,?,?,?,?,?);";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//remove user-id and venueId and add bookingId
	public boolean insertFeedback(FeedbackModel feedback) {
		if (jdbcTemplate.update(INSERTFEEDBACK,"Sath22","v02", feedback.getAns1(),feedback.getAns2(),feedback.getAns3(),feedback.getRating()) != 0) {
			return true;
		}
		return false;
	}
	
}
