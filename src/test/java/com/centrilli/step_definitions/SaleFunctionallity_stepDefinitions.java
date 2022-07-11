package com.centrilli.step_definitions;

import com.centrilli.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.centrilli.pages.SaleFunctionallityPage;
import com.centrilli.utilities.ConfigurationReader;
import com.centrilli.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class SaleFunctionallity_stepDefinitions {
    SaleFunctionallityPage sale = new SaleFunctionallityPage();


    @Given("user is on the centrilli login page")
    public void userIsOnTheCentrilliLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @Given("user enters username and password")
    public void userEntersUsernameAndPassword() {
        sale.emailInput.sendKeys(ConfigurationReader.getProperty("email"));
       sale.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
       sale.btnButton.click();

    }

    @Given("user clicks on sale module")
    public void userClicksOnSaleModule() {
        BrowserUtils.sleep(2);
        sale.getSaleButton.click();
    }

    @Given("user is on {string} dashboard")
    public void user_is_on_dashboard(String string) {
        BrowserUtils.sleep(5);
        String expectedTitle = "Quotations - Odoo";
        Assert.assertEquals(expectedTitle,Driver.getDriver().getTitle());

    }
    @Given("user clicks on list button")
    public void user_clicks_on_list_button() {
        sale.listButton.click();

    }

    @Then("user should be able to see listed customers")
    public void user_should_be_able_to_see_listed_customers() {
        BrowserUtils.sleep(5);
        Assert.assertTrue(sale.listDisplayed.isDisplayed());
    }
    @Then("user clicks on kanban button")
    public void user_clicks_on_kanban_button() {
     sale.kanbanButton.click();
    }

    @Then("user clicks on forward and backward button")
    public void user_clicks_on_forward_and_backward_button() {
       sale.nextButton.click();
        BrowserUtils.sleep(5);
        sale.kanbanButton.click();
    }
    @Then("user click on search input box")
    public void user_click_on_search_input_box() {
       sale.getSearchBox.click();
    }

    @Then("user search for {string} and presses enter")
    public void user_search_for_and_presses_enter(String string) {

    sale.getSearchBox.sendKeys(string + Keys.ENTER);
    }

    @Then("user should be able to se Anna customer listed")
    public void user_should_be_able_to_se_anna_customer_listed() {
        BrowserUtils.sleep(2);
        Assert.assertTrue(sale.AnnaCreatedCustomer.getText().contains("Anna"));

    }


    @Given("user is on customer dashboard")
    public void userIsOnCustomerDashboard() {

    }

    @When("user clicks import button")
    public void userClicksImportButton() {
      // sale.importButton.click();

    }

    @And("user clicks load a file button")
    public void userClicksLoadAFileButton() {
       // sale.loadFileButton.click();

    }

    @And("user chooses the file to import")
    public void userChoosesTheFileToImport() {

    }

    @Then("user should see the file is imported")
    public void userShouldSeeTheFileIsImported() {
      //  sale.importButton.click();


    }
}




