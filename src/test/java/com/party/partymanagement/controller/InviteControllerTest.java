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
import com.party.partymangement.model.InviteModel;
import com.party.partymangement.model.RegisterModel;
import com.party.partymangement.model.VenueModel;
import com.party.partymangement.service.InviteService;
import com.party.partymangement.service.RegisterService;
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
public class InviteControllerTest {

	/** The web application context. */
	@Autowired
	private WebApplicationContext webApplicationContext;

	/** The mock mvc. */
	private MockMvc mvc;

	/** The venue service. */
	@MockBean
	private InviteService inviteService;

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
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testGet() throws Exception {

		InviteModel Im1 = new InviteModel("IN001", "Welcomepic", "Welcome!!!");
		InviteModel Im2 = new InviteModel("IN002", "Welcomepic", "Welcome!!!");
		
		List<InviteModel> Im = new ArrayList<>(Arrays.asList(Im1, Im2));
		Mockito.when(inviteService.getAllInvites()).thenReturn(Im);
		mvc.perform(get("/getInvites").content(asJsonString(Im)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}

	/**
	 * As json string.
	 *
	 * @param obj
	 *            the obj
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
	 * Postt uploadphoto.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void posttUploadphoto() throws Exception {

		String originalFileName = "u_Ak200.png";
		String contentType = "multipart/form-data";
		byte[] content = null;

		MockMultipartFile photo = new MockMultipartFile("photo", originalFileName, contentType, content);
		Mockito.when(inviteService.addInvite(Mockito.any(MultipartFile.class), Mockito.any(InviteModel.class)))
				.thenReturn(true);
		MockMultipartHttpServletRequestBuilder builder = MockMvcRequestBuilders.multipart("/addInvite");
		builder.with(new RequestPostProcessor() {

			@Override
			public MockHttpServletRequest postProcessRequest(MockHttpServletRequest request) {
				request.setMethod("POST");
				return request;
			}
		});
		mvc.perform(builder.file(photo).param("inviteText","Welcome!!!")).andDo(print()).andExpect(status().isCreated());

	}
	
	

}
