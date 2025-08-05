package com.openclassrooms.api_with_spring_boot;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;

import com.openclassrooms.api_with_spring_boot.service.EmployeeService;

@SpringBootTest
@AutoConfigureMockMvc
class ApiWithSpringBootApplicationTests {

    @Autowired
    private MockMvc mockMvc;

	@MockBean
    private EmployeeService employeeService;

	@Test
    public void testGetEmployees() throws Exception {
		System.out.println("Mock retour : " + employeeService.getEmployees());
        mockMvc.perform(get("/employees")).andExpect(status().isOk()).andExpect(jsonPath("$[0].firstName", is("Laurent")));
    }

	@Test
	void contextLoads() {
	}

	@TestConfiguration
    static class MockServiceConfig {
        @Bean
        public EmployeeService employeeService() {
            return Mockito.mock(EmployeeService.class);
        }
    }

}
