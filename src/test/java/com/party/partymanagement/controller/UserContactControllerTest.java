package com.party.partymanagement.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
import com.party.partymangement.model.RegisterModel;
import com.party.partymangement.model.UserContactModel;
import com.party.partymangement.service.RegisterService;
import com.party.partymangement.service.UserContactService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PartymangementApplication.class)
public class UserContactControllerTest {
	/** The web application context. */
	@Autowired
	private WebApplicationContext webApplicationContext;

	/** The mvc. */
	private MockMvc mvc;

	/** The register service. */
	@MockBean
	private UserContactService usercontactService;

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

		UserContactModel UCM1 = new UserContactModel(01, "ak001", "ahamed", "9250064542","kabeer@gmail.com");
		UserContactModel UCM2 = new UserContactModel(02, "ak002", "kabeer", "9261064541","ahamed@gmail.com");
		List<UserContactModel> UCM = new ArrayList<>(Arrays.asList(UCM1, UCM2));
		
		Mockito.when(usercontactService.getAllUserContactList()).thenReturn(UCM);
		mvc.perform(get("/UserContactList").content(asJsonString(UCM)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}

	/**
	 * Test post.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testPost() throws Exception {

		
		UserContactModel userContactModel = new UserContactModel(01, "ak001", "ahamed", "9250064542","kabeer@gmail.co");

		Mockito.when(usercontactService.postUserContact(Mockito.any(UserContactModel.class))).thenReturn(true);

		mvc.perform(post("/UserContact").content(asJsonString(userContactModel)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated())
				.andExpect(content().contentType("application/json"));
	}

	/**
	 * As json string.
	 *
	 * @param obj the obj
	 * @return the string
	 */
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * Put test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void putTest() throws Exception {

		UserContactModel UserContactModel = new UserContactModel();
		UserContactModel.setContactId(01);
		UserContactModel.setName("ahamed");
		UserContactModel.setContactNumber("9250064542");
		UserContactModel.setEmail("kabeer@gmail.com");

		Mockito.when(usercontactService.updateUser(Mockito.any(UserContactModel.class))).thenReturn(true);

		mvc.perform(put("/updateUserContact").content(asJsonString(UserContactModel)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
				//.andExpect(content().contentType("application/json"));
	}
	
	@Test
	public void deleteTest() throws Exception {


		UserContactModel userContactModel = new UserContactModel(01, "ak001", "ahamed", "9250064542","kabeer@gmail.co");
		Mockito.when(usercontactService.deleteUser(Mockito.any(String.class))).thenReturn(true);

		mvc.perform(delete("/deleteUserContact/01").content(asJsonString(userContactModel)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
				//.andExpect(content().contentType("application/json"));
	}

}