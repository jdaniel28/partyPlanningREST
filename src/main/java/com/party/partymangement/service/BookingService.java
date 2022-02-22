package com.party.partymangement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.party.partymangement.dao.BookingDao;
import com.party.partymangement.model.BookingModel;

@Service
public class BookingService {

	@Autowired
	private BookingDao bookingDao;

	public boolean addBooking(BookingModel booking) {
		return this.bookingDao.addBooking(booking);
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
}
