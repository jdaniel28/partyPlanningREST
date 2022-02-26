package com.party.partymangement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.party.partymangement.dao.BookingDao;
import com.party.partymangement.model.BookingModel;
import com.party.partymangement.model.BookingScheduleModel;
import com.party.partymangement.model.ScheduleModel;

// TODO: Auto-generated Javadoc
/**
 * The Class BookingService.
 */
@Service
public class BookingService {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(BookingService.class);

	/** The booking dao. */
	@Autowired
	private BookingDao bookingDao;

	/**
	 * Adds the booking.
	 *
	 * @param booking the booking
	 * @return the int
	 */
	public int addBooking(BookingModel booking) {
		LOGGER.info("Start - addBooking");
		int val = 0;
		if (this.bookingDao.addBooking(booking)) {
			val = this.bookingDao.getBookingId();
		}
		LOGGER.info("End - addBooking");
		return val;
	}

	/**
	 * Approve booking.
	 *
	 * @param booking the booking
	 * @return true, if successful
	 */
	public boolean approveBooking(BookingModel booking) {
		LOGGER.info("Start - approveBooking");
		boolean status;
		if (this.bookingDao.approveBooking(booking)) {
			status = this.bookingDao.removeBooking(booking);
		} else {
			status = false;
		}
		LOGGER.info("End - approveBooking");
		return status;
	}

	/**
	 * Gets the all temp bookings.
	 *
	 * @return the all temp bookings
	 */
	public List<BookingModel> getAllTempBookings() {
		LOGGER.info("Inside getAllTempBookings");
		return this.bookingDao.getAllTempBookings();
	}

	/**
	 * Gets the all confirmed bookings.
	 *
	 * @return the all confirmed bookings
	 */
	public List<BookingModel> getAllConfirmedBookings() {
		LOGGER.info("Inside getAllConfirmedBookings");
		return this.bookingDao.getAllConfirmedBookings();
	}

	/**
	 * Gets the all booking schedules.
	 *
	 * @return the all booking schedules
	 */
	public List<BookingScheduleModel> getAllBookingSchedules() {
		LOGGER.info("Inside getAllBookingSchedules");
		return this.bookingDao.getAllBookingScheduleModels();
	}

	/**
	 * Gets the all booking schedules by date.
	 *
	 * @param schedule the schedule
	 * @return the all booking schedules by date
	 */
	public List<BookingScheduleModel> getAllBookingSchedulesByDate(ScheduleModel schedule) {
		LOGGER.info("Inside getAllBookingSchedulesByDate");
		return this.bookingDao.getAllBookingScheduleModelsByDate(schedule);
	}
}
