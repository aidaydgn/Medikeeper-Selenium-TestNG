package com.medikeeper.tests;

import com.medikeeper.utilities.ConfigurationReader;
import com.medikeeper.utilities.Driver;

import org.testng.annotations.*;



public abstract class TestBase {

    @BeforeTest
    public void setupTest(){
        System.out.println("::: Starting Automation:::");
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();

    }

    @AfterTest
    public void teardownTest() {
      Driver.closeDriver();
        System.out.println("::: End of the Execution:::");

    }


    }

