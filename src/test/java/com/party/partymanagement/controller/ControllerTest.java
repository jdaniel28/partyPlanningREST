package com.party.partymanagement.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.party.partymangement.PartymangementApplication;
import com.party.partymangement.model.RegisterModel;
import com.party.partymangement.service.RegisterService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PartymangementApplication.class)
public class ControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mvc;

	@MockBean
	RegisterService registerService;

	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getAll() throws Exception {
		String sDate1 = "1999/06/22";
		Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(sDate1);
		RegisterModel emp = new RegisterModel("Sathvik", "Shetty", date1, "male", "9930069742", "Sath22", "sathvik");
		Mockito.when(registerService.getUser(Mockito.any(String.class))).thenReturn(emp);
		mvc.perform(get("/User/Sath22").accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Sathvik"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Shetty"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.dob").value("1999-06-21T18:30:00.000+00:00"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.gender").value("male"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.contactNumber").value("9930069742"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.userId").value("Sath22"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.password").value("sathvik"));
	}

	/*
	 * @Test public void createEmployeeAPI() throws Exception { String sDate1 =
	 * "1999/05/12"; Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(sDate1);
	 * mvc.perform(post("/User") .content(asJsonString(new
	 * RegisterModel("Ahamed","Kabeer",date1, "male", "9250064542",
	 * "Ak200","kabeer"))) .contentType(MediaType.APPLICATION_JSON)
	 * .accept(MediaType.APPLICATION_JSON)) .andDo(print())
	 * .andExpect(status().isCreated())
	 * .andExpect(MockMvcResultMatchers.jsonPath("$.Ak200").exists());
	 * .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").exists())
	 * .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").exists())
	 * .andExpect(MockMvcResultMatchers.jsonPath("$.dob").exists())
	 * .andExpect(MockMvcResultMatchers.jsonPath("$.gender").exists())
	 * .andExpect(MockMvcResultMatchers.jsonPath("$.contactNumber").exists())
	 * .andExpect(MockMvcResultMatchers.jsonPath("$.userId").exists())
	 * .andExpect(MockMvcResultMatchers.jsonPath("$.password").exists());
	 * .andExpect(MockMvcResultMatchers.jsonPath("$.photoName").value(null)); }
	 * public static String asJsonString(final Object obj) { try { return new
	 * ObjectMapper().writeValueAsString(obj); } catch (Exception e) { throw new
	 * RuntimeException(e); } }
	 */

	@Test
	public void postAll() throws Exception {

		String sDate1 = "1999/05/12";
		Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(sDate1);
		RegisterModel emp = new RegisterModel("Ahamed", "Kabeer", date1, "male", "9250064542", "Ak200", "kabeer");

		Mockito.when(registerService.postUser(Mockito.any(RegisterModel.class))).thenReturn(true);

		mvc.perform(post("/User").content(asJsonString(emp)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated())
				.andExpect(content().contentType("application/json"));
	}

	@Test
	public void putUploadphoto() throws Exception {

		Path path = Paths.get("C:\\Users\\sjose\\Downloads\\u_Ak200.png");
		String name = "ak_200.png";
		String originalFileName = "u_Ak200.png";
		String contentType = "multipart/form-data";
		byte[] content = null;
		try {
			content = Files.readAllBytes(path);
		} catch (final IOException e) {
		}
		MockMultipartFile photo = new MockMultipartFile(name, originalFileName, contentType, content);
		HashMap<String, String> contentTypeParams = new HashMap<String, String>();
		contentTypeParams.put("boundary", "265001916915724");
		MediaType mediaType = new MediaType("multipart", "form-data", contentTypeParams);
		Mockito.when(registerService.uploadPhotoUser(Mockito.any(MultipartFile.class), Mockito.anyString()))
				.thenReturn(true);
		mvc.perform(put("/uploadPhoto").content(photo.getBytes()).param("userId", "Ak200").contentType(mediaType))
				.andExpect(status().isOk());

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}