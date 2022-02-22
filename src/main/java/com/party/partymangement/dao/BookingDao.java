package com.party.partymangement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.party.partymangement.mapper.BookingMapper;
import com.party.partymangement.model.BookingModel;

@Repository
public class BookingDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SELECT_TEMP = "select * from temp_bookings";
	private static final String SELECT = "select * from bookings where userId = ?";
	private static final String ADD_BOOKING = "insert into temp_bookings (userId,scheduleId,numSeats) values(?,?,?);";
	private static final String REMOVE_TEMP = "delete from temp_bookings where bookingId = ?";
	private static final String APPROVE_BOOKING = "insert into bookings (bookingId,userId,scheduleId,numSeats,inviteId ) select * from temp_bookings where bookingId= ?";

	public boolean addBooking(BookingModel booking) {
		return this.jdbcTemplate.update(ADD_BOOKING, booking.getUserId(), booking.getScheduleId(),
				booking.getNumSeats()) != 0;
	}

	public boolean removeBooking(BookingModel booking) {
		return this.jdbcTemplate.update(REMOVE_TEMP, booking.getBookingId()) != 0;
	}

	public boolean approveBooking(BookingModel booking) {
		return this.jdbcTemplate.update(APPROVE_BOOKING, booking.getBookingId()) != 0;
	}

	public List<BookingModel> getAllTempBookings() {
		return this.jdbcTemplate.query(SELECT_TEMP, new BookingMapper());
	}

}
