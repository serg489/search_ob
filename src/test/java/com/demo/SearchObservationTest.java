package com.demo;

import com.demo.example.ui.page.home.DashBoardPage;
import com.demo.example.ui.test.BaseExampleUITest;
import com.demo.shared.configuration.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchObservationTest extends BaseExampleUITest {

    private static final Logger LOG = LoggerFactory.getLogger(SearchObservationTest.class);
    private static final String OBSERVATION_ID = Config.getEnvVariableOrElse("OBSERVATION_ID","uid://A002/X639a2a/X2a");

    @Test(description = "Search observation by ID")
    public void byObservationId() {
        LOG.info("Step 1: Set filter by observation id");
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.searchByID(OBSERVATION_ID);

        LOG.info("Step 2: Check that observation count is more then zero");
        assertThat(dashBoardPage.getObservationUnitsCount()).as("Observation count was not grater then 0").
                isGreaterThan(0);
        String observationMemberOid = dashBoardPage.getObservations().get(0).getMembersOid();
        assertThat(observationMemberOid).as("Wrong observation in search output").
                isEqualToIgnoringCase(OBSERVATION_ID);
    }
}
