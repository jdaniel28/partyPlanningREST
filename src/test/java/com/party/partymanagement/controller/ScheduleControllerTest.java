package com.party.partymanagement.controller;

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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.party.partymangement.PartymangementApplication;
import com.party.partymangement.model.RegisterModel;
import com.party.partymangement.model.ScheduleModel;
import com.party.partymangement.model.VenueModel;
import com.party.partymangement.model.VenueScheduleModel;
import com.party.partymangement.service.RegisterService;
import com.party.partymangement.service.ScheduleService;
import com.party.partymangement.service.VenueService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class VenueTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PartymangementApplication.class)
public class ScheduleControllerTest {

	/** The web application context. */
	@Autowired
	private WebApplicationContext webApplicationContext;

	/** The mock mvc. */
	private MockMvc mvc;

	/** The venue service. */
	@MockBean
	private ScheduleService scheduleService;

	/**
	 * Setup.
	 */
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testPost() throws Exception {

		String sDate = "2020/05/01";
		String eDate = "2020/05/03";
		Date sdate = new SimpleDateFormat("yyyy/MM/dd").parse(sDate);
		Date edate = new SimpleDateFormat("yyyy/MM/dd").parse(eDate);
		ScheduleModel scheduleModel = new ScheduleModel("V001", "S001", sdate, edate, "All facilities available", 100,
				1000.00);

		Mockito.when(scheduleService.postSchedule(Mockito.any(ScheduleModel.class))).thenReturn(true);

		mvc.perform(post("/Schedule").content(asJsonString(scheduleModel)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated())
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
	public void testGet() throws Exception {

		String sDate = "2020/05/01";
		String eDate = "2020/05/03";
		Date sdate = new SimpleDateFormat("yyyy/MM/dd").parse(sDate);
		Date edate = new SimpleDateFormat("yyyy/MM/dd").parse(eDate);
		ScheduleModel sm1 = new ScheduleModel("V001", "S001", sdate, edate, "All facilities available", 100, 1000.00);
		ScheduleModel sm2 = new ScheduleModel("V002", "S002", sdate, edate, "All facilities available", 100, 1000.00);

		List<ScheduleModel> scheduleModel = new ArrayList<>(Arrays.asList(sm1, sm2));
		Mockito.when(scheduleService.getAllSchedules()).thenReturn(scheduleModel);
		mvc.perform(get("/Schedules").content(asJsonString(scheduleModel)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}

	@Test
	public void testGetVenueschedule() throws Exception {

		String sDate = "2020/05/01";
		String eDate = "2020/05/03";
		Date sdate = new SimpleDateFormat("yyyy/MM/dd").parse(sDate);
		Date edate = new SimpleDateFormat("yyyy/MM/dd").parse(eDate);
		String sDate1 = "2020/05/05";
		String eDate1 = "2020/05/07";
		Date sdate1 = new SimpleDateFormat("yyyy/MM/dd").parse(sDate1);
		Date edate1 = new SimpleDateFormat("yyyy/MM/dd").parse(eDate1);
		ScheduleModel sm1 = new ScheduleModel("V001", "S001", sdate, edate, "All facilities available", 100, 1000.00);
		ScheduleModel sm2 = new ScheduleModel("V002", "S002", sdate1, edate1, "All facilities available", 100, 1000.00);

		List<ScheduleModel> scheduleModel = new ArrayList<>(Arrays.asList(sm1, sm2));
		Mockito.when(scheduleService.getAllSchedules()).thenReturn(scheduleModel);
		mvc.perform(get("/VenueSchedules").content(asJsonString(scheduleModel)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}

	@Test
	public void testPostSchedule() throws Exception {

		String sDate = "2020/05/01";
		String eDate = "2020/05/03";
		Date sdate = new SimpleDateFormat("yyyy/MM/dd").parse(sDate);
		Date edate = new SimpleDateFormat("yyyy/MM/dd").parse(eDate);
		String sDate1 = "2020/05/05";
		String eDate1 = "2020/05/07";
		Date sdate1 = new SimpleDateFormat("yyyy/MM/dd").parse(sDate1);
		Date edate1 = new SimpleDateFormat("yyyy/MM/dd").parse(eDate1);
		VenueScheduleModel sm1 = new VenueScheduleModel("V001", "Marvel",
				"occupation of 100 peoples and disco available", "PartyHall", "S001", sdate, edate,
				"All facilities available", 100, 1000.00);
		VenueScheduleModel sm2 = new VenueScheduleModel("V002", "DC", "occupation of 200 peoples and DJ", "Auditorium",
				"S002", sdate1, edate1, "All facilities available", 100, 1000.00);
		sm1.setStartDate(sdate);
		sm1.setEndDate(edate);
		sm2.setStartDate(sdate1);
		sm2.setEndDate(edate1);

		List<VenueScheduleModel> schedules = new ArrayList<>(Arrays.asList(sm1, sm2));
		Mockito.when(scheduleService.getSchedulesByDate(Mockito.any())).thenReturn(schedules);
		mvc.perform(post("/schedulesByDate").content(asJsonString(sm2)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));

	}

}
