package com.upchain.arch.cucumberdemo.bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        plugin = {"pretty",
        "json:target/cucumber-report.json", "junit:target/cucumber-report.xml"})
public class CucumberTests {

}