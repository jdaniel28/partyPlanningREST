package com.party.partymanagement.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.party.partymangement.model.RegisterModel;
import com.party.partymangement.service.RegisterService;

@WebMvcTest
public class ControllerTest {

	 @Autowired
	 private MockMvc mockMvc;

	  @MockBean
	 private RegisterService resgisterService;

	  private static ObjectMapper mapper = new ObjectMapper();

	  @Test
	 public void testGetExample() throws Exception {
	 List<RegisterModel> rm = new ArrayList<>();
	 RegisterModel user = new RegisterModel();
	 user.setFirstName("sathvik");
	 user.setLastName("Shetty");
	 String sDate1 = "1999/06/21";
	 Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(sDate1);
	 user.setDob(date1);
	 user.setGender("male");
	 user.setContactNumber("9930069742");
	 user.setUserId("Sath22");
	 user.setPassword("sathvik");
	 rm.add(user);
	 Mockito.when(resgisterService.getAllUser()).thenReturn(rm);
	 mockMvc.perform(get("/User")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
	 .andExpect(jsonPath("$[0].firstName", Matchers.equalTo("sathvik"))).andExpect
	 (jsonPath("$[0].lastName", Matchers.equalTo("Shetty"))).andExpect
	 (jsonPath("$[0].dob", Matchers.equalTo("1999-06-20T18:30:00.000+00:00"))).andExpect
	 (jsonPath("$[0].gender", Matchers.equalTo("male"))).andExpect
	 (jsonPath("$[0].contactNumber", Matchers.equalTo("9930069742"))).andExpect
	 (jsonPath("$[0].userId", Matchers.equalTo("Sath22"))).andExpect
	 (jsonPath("$[0].password", Matchers.equalTo("sathvik")));
	 }

	  /*
	 * @Test public void testPostExample() throws Exception { Student student = new
	 * Student(); student.setId(1); student.setName("Arun");
	 * Mockito.when(studentService.saveStudent(ArgumentMatchers.any())).thenReturn(
	 * student); String json = mapper.writeValueAsString(student);
	 * mockMvc.perform(post("/postMapping").contentType(MediaType.APPLICATION_JSON).
	 * characterEncoding("utf-8")
	 * .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().
	 * isCreated()) .andExpect(jsonPath("$.id", Matchers.equalTo(1)))
	 * .andExpect(jsonPath("$.name", Matchers.equalTo("Arun"))); }
	 *
	 * @Test public void testPutExample() throws Exception { Student student = new
	 * Student(); student.setId(2); student.setName("John");
	 * Mockito.when(studentService.updateStudent(ArgumentMatchers.any())).thenReturn
	 * (student); String json = mapper.writeValueAsString(student);
	 * mockMvc.perform(put("/putMapping").contentType(MediaType.APPLICATION_JSON).
	 * characterEncoding("utf-8")
	 * .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
	 * .andExpect(jsonPath("$.id", Matchers.equalTo(2)))
	 * .andExpect(jsonPath("$.name", Matchers.equalTo("John"))); }
	 *
	 * @Test public void testDeleteExample() throws Exception {
	 * Mockito.when(studentService.deleteStudent(ArgumentMatchers.anyString())).
	 * thenReturn("Student is deleted"); MvcResult requestResult =
	 * mockMvc.perform(delete("/deleteMapping").param("student-id", "1"))
	 * .andExpect(status().isOk()).andExpect(status().isOk()).andReturn(); String
	 * result = requestResult.getResponse().getContentAsString();
	 * assertEquals(result, "Student is deleted"); }
	 */
}


}