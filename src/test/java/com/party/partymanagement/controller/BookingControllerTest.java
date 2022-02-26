package com.party.partymanagement.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.party.partymangement.PartymangementApplication;
import com.party.partymangement.model.BookingModel;
import com.party.partymangement.model.BookingScheduleModel;
import com.party.partymangement.model.RegisterModel;
import com.party.partymangement.model.ScheduleModel;
import com.party.partymangement.service.BookingService;
import com.party.partymangement.service.RegisterService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PartymangementApplication.class)
public class BookingControllerTest {
	/** The web application context. */
	@Autowired
	private WebApplicationContext webApplicationContext;

	/** The mvc. */
	private MockMvc mvc;

	/** The register service. */
	@MockBean
	private BookingService bookingService;

	/**
	 * Setup.
	 */
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	/**
	 * Test get.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testGet() throws Exception {

		BookingModel Bm1 = new BookingModel(01, "ak200", "S001", 100);
		BookingModel Bm2 = new BookingModel(02, "Sath200", "S002", 100);
		List<BookingModel> Bm = new ArrayList<>(Arrays.asList(Bm1, Bm2));
		Mockito.when(bookingService.getAllTempBookings()).thenReturn(Bm);
		mvc.perform(get("/tempBookings").content(asJsonString(Bm)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
	@Test
	public void testPost() throws Exception {

		
		BookingModel Bm1 = new BookingModel(03, "ak200", "S003", 50);

		Mockito.when(bookingService.addBooking(Mockito.any(BookingModel.class))).thenReturn(03);

		mvc.perform(post("/addBooking").content(asJsonString(Bm1)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated());
				//.andExpect(content().contentType("application/json"));
	}
	
	@Test
	public void testPostApproved() throws Exception {

		
		BookingModel Bm1 = new BookingModel(03, "ak200", "S003", 50);

		Mockito.when(bookingService.approveBooking(Mockito.any(BookingModel.class))).thenReturn(true);

		mvc.perform(post("/approveBooking").content(asJsonString(Bm1)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated());
				//.andExpect(content().contentType("application/json"));
	}
	
	@Test
	public void testGetAllConfirmedBookings() throws Exception {

		BookingModel Bm1 = new BookingModel(01, "ak200", "S001", 100);
		BookingModel Bm2 = new BookingModel(02, "Sath200", "S002", 100);
		List<BookingModel> Bm = new ArrayList<>(Arrays.asList(Bm1, Bm2));
		Mockito.when(bookingService.getAllConfirmedBookings()).thenReturn(Bm);
		mvc.perform(get("/confirmedBookings").content(asJsonString(Bm)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}
	
	@Test
	public void testGetAllBookingSchedules() throws Exception {

		
		String sDate = "2020/05/01";
		String eDate = "2020/05/03";
		Date sdate = new SimpleDateFormat("yyyy/MM/dd").parse(sDate);
		Date edate = new SimpleDateFormat("yyyy/MM/dd").parse(eDate);
		String sDate1 = "2020/05/05";
		String eDate1 = "2020/05/07";
		Date sdate1 = new SimpleDateFormat("yyyy/MM/dd").parse(sDate1);
		Date edate1 = new SimpleDateFormat("yyyy/MM/dd").parse(eDate1);
		BookingScheduleModel Bm1 = new BookingScheduleModel(01, "ak200", "S001",sdate,edate, 1000.00);
		BookingScheduleModel Bm2 = new BookingScheduleModel(02, "Sath200", "S002", sdate1, edate1, 1000.00);
		List<BookingScheduleModel> Bm = new ArrayList<>(Arrays.asList(Bm1, Bm2));
		Mockito.when(bookingService.getAllBookingSchedules()).thenReturn(Bm);
		mvc.perform(get("/getBookingSchedules").content(asJsonString(Bm)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}
	
	@Test
	public void testPostBookingSchedulesByDate() throws Exception {

		String sDate = "2020/05/01";
		String eDate = "2020/05/03";
		Date sdate = new SimpleDateFormat("yyyy/MM/dd").parse(sDate);
		Date edate = new SimpleDateFormat("yyyy/MM/dd").parse(eDate);
		String sDate1 = "2020/05/05";
		String eDate1 = "2020/05/07";
		Date sdate1 = new SimpleDateFormat("yyyy/MM/dd").parse(sDate1);
		Date edate1 = new SimpleDateFormat("yyyy/MM/dd").parse(eDate1);
		BookingScheduleModel Bm1 = new BookingScheduleModel(01, "ak200", "S001",sdate,edate, 1000.00);
		BookingScheduleModel Bm2 = new BookingScheduleModel(02, "Sath200", "S002", sdate1, edate1, 1000.00);
		Bm1.setStartDate(sdate);
		Bm1.setEndDate(edate);
		Bm2.setStartDate(sdate1);
		Bm2.setEndDate(edate1);
		List<BookingScheduleModel> Bm = new ArrayList<>(Arrays.asList(Bm1, Bm2));

		Mockito.when(bookingService.getAllBookingSchedulesByDate(Mockito.any(ScheduleModel.class))).thenReturn(Bm);

		mvc.perform(post("/bookingSchedules").content(asJsonString(Bm1)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}
}