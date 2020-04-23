package com.demo.ui.base.page;

import com.demo.shared.exceptions.UIException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
        waitForLoad();
    }

    // indicate is page presented or not
    public boolean isOpened() {
        throw new UIException("Not implemented for page");
    }

    // lock page object interaction until method finish or throw an error, should be not overridden
    public void waitForLoad() {
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void wait(int seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
