package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Slf4j
public class Google_StepDefinitions {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

   // Logger log= LogManager.getLogger(this.getClass());
   // Logger log= LoggerFactory.getLogger(this.getClass());
    @Given("user is on the Google search page")
    public void user_is_on_the_google_search_page() {
        log.info("navigating to https://www.google.com");
        Driver.getDriver().get("https://www.google.com");
        //googleSearchPage.rejectCookieButton.click();
        BrowserUtils.sleep(1);
    }

    @When("user enters {string} in the Google search box")
    public void userEntersInTheGoogleSearchBox(String searchKey) {
        log.info("send word to search box");
        googleSearchPage.searchBox.sendKeys(searchKey);
        BrowserUtils.sleep(1);
    }

    @Then("user clicks on the search button")
    public void userClicksOnTheSearchButton() {
        log.info("clicking search box");
        googleSearchPage.searchBox.click();
        googleSearchPage.searchBox.sendKeys(Keys.ENTER);
        BrowserUtils.sleep(1);
    }

    @Then("user should see {string} in the title")
    public void userShouldSeeInTheTitle(String expectedTitle) {
        BrowserUtils.verifyTitleContains(expectedTitle);
    }

}
