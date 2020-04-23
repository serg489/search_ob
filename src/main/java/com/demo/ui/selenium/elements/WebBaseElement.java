package com.demo.ui.selenium.elements;

import com.demo.shared.exceptions.UIException;
import com.demo.ui.selenium.util.DriverFactory;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

public class WebBaseElement extends TypifiedElement {

    private static final Logger LOG = LoggerFactory.getLogger(WebBaseElement.class);
    private static final int DEFAULT_WAIT_TIMEOUT = 15;

    public WebBaseElement(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public String getText() {
        return getWrappedElement().getText();
    }

    public String getAttribute(String attributeName) {
        return getWrappedElement().getAttribute(attributeName);
    }

    public void waitForDisappear() {
        waitForDisappear(DEFAULT_WAIT_TIMEOUT);
    }

    public void waitForDisappear(int seconds) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 1);
        long end = System.currentTimeMillis() + seconds * 1000;

        while (System.currentTimeMillis() < end) {
            try {
                wait.until(ExpectedConditions.visibilityOf(getWrappedElement()));
            } catch (WebDriverException ex) {
                return;
            }
        }

        throw new UIException("Element was visible");
    }

    public void waitForVisible() {
        waitForVisible(DEFAULT_WAIT_TIMEOUT);
    }

    public void waitForVisible(int timeout) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), timeout);
        try {
            wait.until(ExpectedConditions.visibilityOf(getWrappedElement()));
            LOG.info("Element is visible");
        } catch (WebDriverException ex) {
            String errorMsg = String.format("Element is unexpectedly not visible after [%d] timeout", timeout);
            LOG.error(errorMsg);
            throw new UIException(errorMsg, ex);
        }
    }


    public boolean isVisible() {
        return isVisible(DEFAULT_WAIT_TIMEOUT);
    }

    public boolean isVisible(int timeout) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), timeout);
        try {
            wait.until(ExpectedConditions.visibilityOf(getWrappedElement()));
            LOG.info("Element is visible");
            return true;
        } catch (WebDriverException ex) {
            LOG.info("Element is not visible");
            return false;
        }
    }

}
