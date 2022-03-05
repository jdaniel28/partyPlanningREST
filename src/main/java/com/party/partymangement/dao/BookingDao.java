package com.party.partymangement.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.party.partymangement.mapper.BookingMapper;
import com.party.partymangement.mapper.BookingScheduleMapper;
import com.party.partymangement.model.BookingModel;
import com.party.partymangement.model.BookingScheduleModel;
import com.party.partymangement.model.ScheduleModel;
import com.party.partymangement.util.Util;

// TODO: Auto-generated Javadoc
/**
 * The Class BookingDao.
 */
@Repository
public class BookingDao {

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(BookingDao.class);

	/** The Constant GET_CONFIRMED. */
	private static final String GET_CONFIRMED = "select * from bookings";

	/** The Constant GET_BOOKING_SCHEDULES. */
	private static final String GET_BOOKING_SCHEDULES = "select b.bookingId, b.userId, s.scheduleId, s.startDate, s.endDate,s.price from bookings as b join schedule as s on b.scheduleId = s.scheduleId;";

	/** The Constant GET_BOOKING_SCHEDULES_BY_DATE. */
	private static final String GET_BOOKING_SCHEDULES_BY_DATE = "select b.bookingId, b.userId, s.scheduleId, s.startDate, s.endDate,s.price from bookings as b join schedule as s on b.scheduleId = s.scheduleId where s.startDate between ? and ?;";

	/** The Constant SELECT_TEMP. */
	private static final String SELECT_TEMP = "select * from temp_bookings";

	/** The Constant SELECT. */
	private static final String SELECT = "select * from bookings where userId = ?";

	/** The Constant ADD_BOOKING. */
	private static final String ADD_BOOKING = "insert into temp_bookings (userId,scheduleId) values(?,?);";

	/** The Constant REMOVE_TEMP. */
	private static final String REMOVE_TEMP = "delete from temp_bookings where bookingId = ?";

	/** The Constant APPROVE_BOOKING. */
	private static final String APPROVE_BOOKING = "insert into bookings (bookingId,userId,scheduleId ) select bookingId,userId,scheduleId from temp_bookings where bookingId= ?";

	/** The Constant GET_ID. */
	private static final String GET_ID = "select max(bookingId) from temp_bookings";

	/**
	 * Adds the booking.
	 *
	 * @param booking the booking
	 * @return true, if successful
	 */
	public boolean addBooking(BookingModel booking) {
		LOGGER.info("Inside addBooking");
		return this.jdbcTemplate.update(ADD_BOOKING, booking.getUserId(),
				Util.convertIdToInt(booking.getScheduleId())) != 0;
	}

	/**
	 * Removes the booking.
	 *
	 * @param booking the booking
	 * @return true, if successful
	 */
	public boolean removeBooking(BookingModel booking) {
		LOGGER.info("Inside removeBooking");
		return this.jdbcTemplate.update(REMOVE_TEMP, booking.getBookingId()) != 0;
	}

	/**
	 * Gets the booking id.
	 *
	 * @return the booking id
	 */
	public int getBookingId() {
		LOGGER.info("Inside getBookingId");
		return this.jdbcTemplate.queryForObject(GET_ID, Integer.class);
	}

	/**
	 * Approve booking.
	 *
	 * @param booking the booking
	 * @return true, if successful
	 */
	public boolean approveBooking(BookingModel booking) {
		LOGGER.info("Inside approveBooking");
		return this.jdbcTemplate.update(APPROVE_BOOKING, booking.getBookingId()) != 0;
	}

	/**
	 * Gets the all temp bookings.
	 *
	 * @return the all temp bookings
	 */
	public List<BookingModel> getAllTempBookings() {
		LOGGER.info("Inside getAllTempBookings");
		return this.jdbcTemplate.query(SELECT_TEMP, new BookingMapper());
	}

	/**
	 * Gets the all confirmed bookings.
	 *
	 * @return the all confirmed bookings
	 */
	public List<BookingModel> getAllConfirmedBookings() {
		LOGGER.info("Inside getAllConfirmedBookings");
		return this.jdbcTemplate.query(GET_CONFIRMED, new BookingMapper());
	}

	/**
	 * Gets the all booking schedule models.
	 *
	 * @return the all booking schedule models
	 */
	public List<BookingScheduleModel> getAllBookingScheduleModels() {
		LOGGER.info("Inside getAllBookingScheduleModels");
		return this.jdbcTemplate.query(GET_BOOKING_SCHEDULES, new BookingScheduleMapper());
	}

	/**
	 * Gets the all booking schedule models by date.
	 *
	 * @param model the model
	 * @return the all booking schedule models by date
	 */
	public List<BookingScheduleModel> getAllBookingScheduleModelsByDate(ScheduleModel model) {
		LOGGER.info("Inside getAllBookingScheduleModelsByDate");
		return this.jdbcTemplate.query(GET_BOOKING_SCHEDULES_BY_DATE, new BookingScheduleMapper(), model.getStartDate(),
				model.getEndDate());
	}

}
