package com.demo.ui.selenium.util;

import com.demo.shared.configuration.Config;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            String driverType = Config.getEnvVariableOrElse("DRIVER_TYPE", "CHROME");
            driver.set(getLocalDriver(DriverManagerType.valueOf(driverType)));
        }
        return driver.get();
    }

    public static void releaseDriver() {
        WebDriver driverToDestroy = driver.get();
        driverToDestroy.quit();
        driver.remove();
    }

    private static WebDriver getLocalDriver(DriverManagerType driver) {
        WebDriverManager.getInstance(driver).setup();
        return new ChromeDriver();
    }

}
