package com.upchain.arch.cucumberdemo.bdd;

import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import com.upchain.arch.cucumberdemo.CucumberDemoApplication;

@SpringBootTest(classes = CucumberDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration
@CucumberContextConfiguration
@AutoConfigureMockMvc
public class CucumberTestContextConfiguration {

    @Before
    public void setup_cucumber_spring_context() {
        // Dummy method so cucumber will recognize this class as glue
        // and use its context configuration.
    }

}