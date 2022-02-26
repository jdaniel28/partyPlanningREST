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
import com.party.partymangement.model.InviteeDetailsModel;
import com.party.partymangement.model.InviteeModel;
import com.party.partymangement.model.RegisterModel;
import com.party.partymangement.model.ScheduleModel;
import com.party.partymangement.model.VenueModel;
import com.party.partymangement.model.VenueScheduleModel;
import com.party.partymangement.service.InviteeService;
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
public class InviteeControllerTest {

	/** The web application context. */
	@Autowired
	private WebApplicationContext webApplicationContext;

	/** The mock mvc. */
	private MockMvc mvc;

	/** The venue service. */
	@MockBean
	private InviteeService inviteeService;

	/**
	 * Setup.
	 */
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testPost() throws Exception {

		
		InviteeModel Inviteemodel = new InviteeModel(001, 01, 01, "IN001");

		Mockito.when(inviteeService.addInvitee(Mockito.any(InviteeModel.class))).thenReturn(true);

		mvc.perform(post("/addInvitee").content(asJsonString(Inviteemodel)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
				//.andExpect(content().contentType("application/json"));
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

		InviteeModel Im1 = new InviteeModel(001, 01, 01, "IN001");
		InviteeModel Im2 = new InviteeModel(002, 02, 02, "IN002");
		
		List<InviteeModel> Inviteemodel = new ArrayList<>(Arrays.asList(Im1, Im2));
		Mockito.when(inviteeService.getInvitedForBookingId(01)).thenReturn(Inviteemodel);
		mvc.perform(get("/getInvitees/01").content(asJsonString(Inviteemodel)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}

	@Test
	public void testGetAllInviteeDetails() throws Exception {

		
		InviteeDetailsModel Idm1 = new InviteeDetailsModel(01, 01, "Welcome!!!","Ahamed");
		InviteeDetailsModel Idm2 = new InviteeDetailsModel(02, 02, "Hi!!!","DeviSri");
		List<InviteeDetailsModel> inviteeDetailsModel = new ArrayList<>(Arrays.asList(Idm1, Idm2));
		Mockito.when(inviteeService.getAllInviteeDetails(Mockito.any())).thenReturn(inviteeDetailsModel);
		mvc.perform(get("/getInviteeDetails/ak200").content(asJsonString(inviteeDetailsModel)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}

	

}
