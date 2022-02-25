package com.party.partymangement.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.party.partymanagement.util.Util;
import com.party.partymangement.mapper.BookingMapper;
import com.party.partymangement.mapper.BookingScheduleMapper;
import com.party.partymangement.model.BookingModel;
import com.party.partymangement.model.BookingScheduleModel;
import com.party.partymangement.model.ScheduleModel;

@Repository
public class BookingDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final static Logger LOGGER = LoggerFactory.getLogger(BookingDao.class);

	private static final String GET_CONFIRMED = "select * from bookings";
	private static final String GET_BOOKING_SCHEDULES = "select b.bookingId, b.userId, s.scheduleId, s.startDate, s.endDate,s.price from bookings as b join schedule as s on b.scheduleId = s.scheduleId;";
	private static final String GET_BOOKING_SCHEDULES_BY_DATE = "select b.bookingId, b.userId, s.scheduleId, s.startDate, s.endDate,s.price from bookings as b join schedule as s on b.scheduleId = s.scheduleId where s.startDate between ? and ?;";
	private static final String SELECT_TEMP = "select * from temp_bookings";
	private static final String SELECT = "select * from bookings where userId = ?";
	private static final String ADD_BOOKING = "insert into temp_bookings (userId,scheduleId) values(?,?);";
	private static final String REMOVE_TEMP = "delete from temp_bookings where bookingId = ?";
	private static final String APPROVE_BOOKING = "insert into bookings (bookingId,userId,scheduleId ) select * from temp_bookings where bookingId= ?";
	private static final String GET_ID = "select max(bookingId) from temp_bookings";

	public boolean addBooking(BookingModel booking) {
		return this.jdbcTemplate.update(ADD_BOOKING, booking.getUserId(),
				Util.convertIdToInt(booking.getScheduleId())) != 0;
	}

	public boolean removeBooking(BookingModel booking) {
		return this.jdbcTemplate.update(REMOVE_TEMP, booking.getBookingId()) != 0;
	}

	public int getBookingId() {
		return this.jdbcTemplate.queryForObject(GET_ID, Integer.class);
	}

	public boolean approveBooking(BookingModel booking) {
		return this.jdbcTemplate.update(APPROVE_BOOKING, booking.getBookingId()) != 0;
	}

	public List<BookingModel> getAllTempBookings() {
		return this.jdbcTemplate.query(SELECT_TEMP, new BookingMapper());
	}

	public List<BookingModel> getAllConfirmedBookings() {
		return this.jdbcTemplate.query(GET_CONFIRMED, new BookingMapper());
	}

	public List<BookingScheduleModel> getAllBookingScheduleModels() {
		return this.jdbcTemplate.query(GET_BOOKING_SCHEDULES, new BookingScheduleMapper());
	}

	public List<BookingScheduleModel> getAllBookingScheduleModelsByDate(ScheduleModel model) {
		return this.jdbcTemplate.query(GET_BOOKING_SCHEDULES_BY_DATE, new BookingScheduleMapper(), model.getStartDate(),
				model.getEndDate());
	}

}
