package com.party.partymangement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.party.partymangement.dao.BookingDao;
import com.party.partymangement.model.BookingModel;
import com.party.partymangement.model.BookingScheduleModel;
import com.party.partymangement.model.ScheduleModel;

@Service
public class BookingService {

	@Autowired
	private BookingDao bookingDao;

	public int addBooking(BookingModel booking) {
		if (this.bookingDao.addBooking(booking)) {
			return this.bookingDao.getBookingId();
		}
		return 0;
	}

	public boolean approveBooking(BookingModel booking) {
		if (this.bookingDao.approveBooking(booking)) {
			return this.bookingDao.removeBooking(booking);
		}
		return false;
	}

	public List<BookingModel> getAllTempBookings() {
		return this.bookingDao.getAllTempBookings();
	}

	public List<BookingModel> getAllConfirmedBookings() {
		return this.bookingDao.getAllConfirmedBookings();
	}

	public List<BookingScheduleModel> getAllBookingSchedules() {
		return this.bookingDao.getAllBookingScheduleModels();
	}

	public List<BookingScheduleModel> getAllBookingSchedulesByDate(ScheduleModel schedule) {
		return this.bookingDao.getAllBookingScheduleModelsByDate(schedule);
	}
}
