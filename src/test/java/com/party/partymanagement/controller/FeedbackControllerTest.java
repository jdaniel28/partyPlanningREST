package com.party.partymanagement.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.party.partymangement.PartymangementApplication;
import com.party.partymangement.model.FeedbackModel;
import com.party.partymangement.service.FeedbackService;

// TODO: Auto-generated Javadoc
/**
 * The Class FeedbackControllerTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PartymangementApplication.class)
public class FeedbackControllerTest {
	/** The web application context. */
	@Autowired
	private WebApplicationContext webApplicationContext;

	/** The mvc. */
	private MockMvc mvc;

	/** The register service. */
	@MockBean
	private FeedbackService feedbackService;

	/**
	 * Setup.
	 */
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	/**
	 * Test post.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testPost() throws Exception {

		FeedbackModel Fm = new FeedbackModel("FB001", "ak200", 01, "EXCELENT", "GOOD", "BAD", "4.5", 001);

		Mockito.when(feedbackService.postFeedback(Mockito.any(FeedbackModel.class))).thenReturn(true);

		mvc.perform(post("/UserFeedback").content(asJsonString(Fm)).contentType(MediaType.APPLICATION_JSON)
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
	 * Test get.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testGet() throws Exception {

		FeedbackModel Fm1 = new FeedbackModel("FB001", "ak200", 01, "EXCELENT", "GOOD", "BAD", "4.5", 001);
		FeedbackModel Fm2 = new FeedbackModel("FB002", "ak200", 02, "EXCELENT", "GOOD", "BAD", "4.5", 001);

		List<FeedbackModel> feedbackModel = new ArrayList<>(Arrays.asList(Fm1, Fm2));
		Mockito.when(feedbackService.getAllFeedback()).thenReturn(feedbackModel);
		mvc.perform(get("/getFeedback").content(asJsonString(feedbackModel)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}

}