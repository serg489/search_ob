package com.demo.example.ui.test;

import com.demo.shared.configuration.Config;
import com.demo.ui.base.test.BaseUITest;
import com.demo.ui.selenium.util.SeleniumUtils;
import org.testng.annotations.BeforeMethod;

public class BaseExampleUITest extends BaseUITest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
        SeleniumUtils.open(Config.getProperty("ui.base_url"));
        driver.manage().window().maximize();
    }
}
