package com.demo.ui.base.test;

import com.demo.ui.selenium.elements.WebBaseElement;
import com.demo.ui.selenium.util.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseUITest {

    private static final Logger LOG = LoggerFactory.getLogger(WebBaseElement.class);

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        this.driver = DriverFactory.getDriver();
        LOG.info("Selenium initialization done");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.releaseDriver();
        LOG.info("Selenium shut-down finished");
    }
}
