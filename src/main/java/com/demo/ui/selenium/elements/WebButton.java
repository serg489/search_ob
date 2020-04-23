package com.demo.ui.selenium.elements;


import com.demo.shared.exceptions.UIException;
import com.demo.ui.selenium.util.SeleniumUtils;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebButton extends WebBaseElement {

    private static final Logger LOG = LoggerFactory.getLogger(WebButton.class);

    public WebButton(WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void click() {
        click(3);
    }

    public void click(int retryCount) {
        for (int retry; retryCount > 0; retryCount--) {
            try {
                super.click();
                return;
            } catch (Exception ex) {
                //some logging, retry logic
                SeleniumUtils.sleep(500);
                LOG.warn("Click was not happen due to: " + ex);

            }
        }
        throw new UIException("Item was no clicked");
    }
}

