package com.demo.example.ui.page.home;

import com.demo.ui.base.page.BasePage;
import com.demo.ui.selenium.elements.WebInput;
import com.demo.ui.selenium.elements.WebLabel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashBoardPage extends BasePage {

    @FindBy(id = "search-button")
    private WebInput searchInput;
    @FindBy(id = "search-input-mous")
    private WebInput unitSetInput;
    @FindBy(xpath = "//*[@id='observation-panel']//datatable-body-row")
    private List<ObservationItemPage> observationUnits;
    @FindBy(xpath = "//*[contains(@class, 'spinner')]")
    private WebLabel spinner;


    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    public void searchByID(String id) {
        searchInput.click();
        unitSetInput.sendKeys(id);
        spinner.waitForVisible(5); // search begin
        spinner.waitForDisappear(20); // search begin
    }

    public int getObservationUnitsCount() {
        return observationUnits.size();
    }

    public List<ObservationItemPage> getObservations() {
        return observationUnits;
    }

    @Override
    public void waitForLoad() {
        searchInput.waitForVisible();
    }

    @Override
    public boolean isOpened() {
        return searchInput.isVisible();
    }
}
