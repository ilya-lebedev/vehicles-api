package com.udacity.pricing;

import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Implements testing of the pricing service.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PricingServiceTests {

    @Autowired
    private MockMvc mvc;

    /**
     * Tests the read operation for a single price by ID.
     * @throws Exception if the read operation for a single price fails
     */
    @Test
    public void findCar() throws Exception {
        mvc.perform(get("/prices/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/hal+json;charset=UTF-8"))
                .andExpect(jsonPath("$.price", greaterThan(0.0)))
                .andExpect(jsonPath("$.vehicleId", greaterThan(0)));
    }

}
