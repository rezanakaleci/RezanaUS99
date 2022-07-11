package com.centrilli.step_definitions;

import com.centrilli.pages.CustomerCreatePage;
import com.centrilli.pages.SaleFunctionallityPage;
import com.centrilli.utilities.BrowserUtils;
import com.centrilli.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class CustomerCreated_stepDefinitions {

 CustomerCreatePage customerCreatePage = new CustomerCreatePage();
 SaleFunctionallityPage sale= new SaleFunctionallityPage();
 Faker faker = new Faker();
 String name = faker.name().fullName();

 @When("user clicks on customer button")
 public void user_clicks_on_customer_button() {
  customerCreatePage.customerButton.click();
 }

 @Then("user clicks create button")
 public void user_clicks_create_button() {
  customerCreatePage.createButton.click();
 }

 @Then("user fills all the fields")
 public void user_fills_all_the_fields() {
  //send full name
  customerCreatePage.nameBox.sendKeys(name);
  //address box
  String address = faker.address().fullAddress();
  customerCreatePage.addressBox.sendKeys(address);
  //company box
  // customerCreatePage.selectRandomWebElements

  //enter phone number
  String phone = faker.phoneNumber().cellPhone();
  customerCreatePage.phoneNumber.sendKeys(phone);
  BrowserUtils.sleep(3);

 }

 @Then("user clicks save button")
 public void user_clicks_save_button() {
  customerCreatePage.saveButton.click();
  BrowserUtils.sleep(5);

 }

 @Then("user should see the new created customer from Sale module")
 public void user_should_see_the_new_created_customer_from_sale_module() {
  String expectedtittle = "Odoo";
  Assert.assertEquals(expectedtittle,Driver.getDriver().getTitle());


 }


 // User should be able to change the name of the customer, after creating new customer
 @When("user is on customer data")
 public void userIsOnCustomerData() {
  String expectedtittle = "Odoo";
  Assert.assertEquals(expectedtittle,Driver.getDriver().getTitle());
 }

 @And("user clicks on  edit button")
 public void userClicksOnEditButton() {
  BrowserUtils.sleep(4);
   customerCreatePage.editButton.click();
 }
 @And("user changes customer name")
 public void userChangesCustomerName() {
   customerCreatePage.nameBox.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
 }

 @Then("user should see the customer name is changed")
 public void userShouldSeeTheCustomerNameIsChangers() {
  String expectedTittle="Odoo";
  Assert.assertTrue(customerCreatePage.customerChanged.isDisplayed());

 }


 //User should be able to see created customer is listed after
 //              clicking the Customers module.

 @When("user clicks on customer module")
 public void userClicksOnCustomerModule() {
  customerCreatePage.customerButton.click();
 }


 @Then("user should be able to see new created customer listed")
 public void userShouldBeAbleToSeeNewCreatedCustomerListed() {
   while (!(customerCreatePage.findingCustomer(name).isDisplayed())){
      sale.nextButton.click();
      BrowserUtils.sleep(2);
   }
  System.out.println(customerCreatePage.findingCustomer(name).getText());
   Assert.assertTrue(customerCreatePage.findingCustomer(name).isDisplayed());



 }
 //User should be able to see that the page title changes to customer
 //           name after creating the new customer

 @When("user clicks on costumer module")
 public void userClicksOnCostumerModule() {
  customerCreatePage.customerButton.click();
 }


 @And("user fills minimum requirement field")
 public void userFillsMinimumRequirementField() {
  //send full name
  customerCreatePage.nameBox.sendKeys(name);

 }

 @Then("user should be able to see the title change to customer name")
 public void userShouldBeAbleToSeeTheTitleChangeToCustomerName() {

  String expectedCustomer= name + " - Odoo";
  Assert.assertEquals(expectedCustomer, Driver.getDriver().getTitle());

 }
}