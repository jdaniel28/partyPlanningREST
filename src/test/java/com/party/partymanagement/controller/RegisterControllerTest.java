package com.party.partymanagement.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.party.partymangement.model.RegisterModel;
import com.party.partymangement.service.RegisterService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PartymangementApplication.class)
public class RegisterControllerTest {
	/** The web application context. */
	@Autowired
	private WebApplicationContext webApplicationContext;

	/** The mvc. */
	private MockMvc mvc;

	/** The register service. */
	@MockBean
	private RegisterService registerService;

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

		String sDate1 = "1999/06/22";
		Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(sDate1);
		RegisterModel registerModel = new RegisterModel("Sathvik", "Shetty", date1, "male", "9930069742", "Sath22",
				"sathvik");
		Mockito.when(registerService.getUser(Mockito.any(String.class))).thenReturn(registerModel);
		mvc.perform(get("/User/Sath22").content(asJsonString(registerModel)).contentType(MediaType.APPLICATION_JSON)
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

		String sDate1 = "1999/05/12";
		Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(sDate1);
		RegisterModel registerModel = new RegisterModel("Ahamed", "Kabeer", date1, "male", "9250064542", "Ak200",
				"kabeer");

		Mockito.when(registerService.postUser(Mockito.any(RegisterModel.class))).thenReturn(true);

		mvc.perform(post("/User").content(asJsonString(registerModel)).contentType(MediaType.APPLICATION_JSON)
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
	 * Post login.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void postLogin() throws Exception {

		RegisterModel Registermodel = new RegisterModel();
		Registermodel.setUserId("Sath22");
		Registermodel.setPassword("sathvik");

		Mockito.when(registerService.checkLogin(Mockito.any(RegisterModel.class))).thenReturn("Logged Inadmin");

		mvc.perform(post("/login").content(asJsonString(Registermodel)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}

	/**
	 * Put test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void putTest() throws Exception {

		RegisterModel Registermodel = new RegisterModel();
		Registermodel.setAns1("scooby");
		Registermodel.setAns2("blue");
		Registermodel.setAns3("sat");

		Mockito.when(registerService.getUserId(Mockito.any(RegisterModel.class))).thenReturn("Sath22");

		mvc.perform(put("/forgotUserId").content(asJsonString(Registermodel)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}

	/**
	 * Put test password.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void putTestPassword() throws Exception {

		RegisterModel Registermodel = new RegisterModel();
		Registermodel.setUserId("Ak200");
		Registermodel.setPassword("qwerty");

		Mockito.when(registerService.postUserPassword(Mockito.any(RegisterModel.class))).thenReturn(true);

		mvc.perform(put("/UserPassword").content(asJsonString(Registermodel)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated())
				.andExpect(content().contentType("application/json"));
	}

	/**
	 * Put forgetpassword.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void putForgetpassword() throws Exception {

		RegisterModel Registermodel = new RegisterModel();
		Registermodel.setAns1("scooby");
		Registermodel.setAns2("blue");
		Registermodel.setAns3("sat");
		Registermodel.setUserId("Sath22");

		Mockito.when(registerService.forgotPassword(Mockito.any(RegisterModel.class))).thenReturn(true);

		mvc.perform(put("/forgotPassword").content(asJsonString(Registermodel)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
	}

	/**
	 * Put uploadphoto.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void putUploadphoto() throws Exception {

		String originalFileName = "u_ak200.png";
		String contentType = "multipart/form-data";
		byte[] content = null;
		MockMultipartFile photo = new MockMultipartFile("photo", originalFileName, contentType, content);
		Mockito.when(registerService.uploadPhotoUser(Mockito.any(MultipartFile.class), Mockito.anyString()))
				.thenReturn(true);
		MockMultipartHttpServletRequestBuilder builder = MockMvcRequestBuilders.multipart("/uploadPhoto");
		builder.with(new RequestPostProcessor() {

			@Override
			public MockHttpServletRequest postProcessRequest(MockHttpServletRequest request) {
				request.setMethod("PUT");
				return request;
			}
		});
		mvc.perform(builder.file(photo).param("userId", "ak200")).andDo(print()).andExpect(status().isOk());

	}

	/**
	 * Put updateuser.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void putUpdateuser() throws Exception {

		RegisterModel Registermodel = new RegisterModel();
		Registermodel.setFirstName("kabeer");
		Registermodel.setLastName("ahamed");
		String sDate1 = "1997/05/02";
		Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(sDate1);
		Registermodel.setDob(date1);
		Registermodel.setGender("male");
		Registermodel.setContactNumber("9990064542");
		Registermodel.setUserId("Ak200");

		Mockito.when(registerService.updateUser(Mockito.any(RegisterModel.class))).thenReturn(true);

		mvc.perform(put("/updateUser").content(asJsonString(Registermodel)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
	}

}