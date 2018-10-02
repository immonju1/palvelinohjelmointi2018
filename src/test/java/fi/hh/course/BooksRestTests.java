package fi.hh.course;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BooksRestTests {

	@Autowired
	private WebApplicationContext webAppContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp () {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}
	
	@Test
	public void statusOk() throws Exception {
		mockMvc.perform(get("/books"))
			.andExpect(status().isOk());
	}
	
	@Test
	public void responseTypeApplicationJson() throws Exception {
		mockMvc.perform(get("/books"))
			.andExpect(content().contentType(MediaType.APPLICATION_JSON.APPLICATION_JSON_UTF8));
	}
	
}
