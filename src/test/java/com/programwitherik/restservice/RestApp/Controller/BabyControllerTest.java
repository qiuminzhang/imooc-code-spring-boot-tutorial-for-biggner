package com.programwitherik.restservice.RestApp.Controller;

//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.asset.EmptyAsset;
//import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/** Test Controller*/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc // If test API
public class BabyControllerTest {

    @Autowired
    private MockMvc mcv;

    // Test what post/get request would return
    // The return could be status or content which depends on what method you call
    // .status() or .content()
    @Test
    public void babyList() throws Exception {
        mcv.perform(MockMvcRequestBuilders.get("/babies"))
                .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("abc"));
        // .string("abc") means we want to see if the content matches "abc"
    }
}
