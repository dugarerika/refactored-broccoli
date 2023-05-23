package Steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.Calendar;
import pom.LoginVendor;
import utils.Utilities;

import java.util.List;


public class StepsCalendarVendor {
    static LoginVendor objLogin = new LoginVendor();
    Calendar objCalendar = new Calendar();

    @When("the user clicks on the calendar icon")
    public void theUserClicksOnTheCalendarIcon() {
        objCalendar.btnCalendar();
    }

    @Then("the user has access to the calendar section")
    public void theUserHasAccessToTheCalendarSection() {
        objCalendar.chckMessage("Calendar");
    }

    @And("Close c")
    public void close_b() {
        Utilities.closeExplorer(); Utilities.closeProcess();
    }

    @Then("the New Appointment modal is display")
    public void theNewAppointmentModalIsDisplay() {
        objCalendar.chckModal();
        objCalendar.closeIcon();
    }

    @Given("user is on the calendar page")
    public void userIsOnTheCalendarPage() {
        objCalendar.btnCalendar();
    }

    @And("select category")
    public void selectCategory() {
        objCalendar.SelectCategory();
    }

    @And("the user select category")
    public void theUserSelectCategory() {
        objCalendar.SelectCategory();
    }

    @And("the user selects service")
    public void theUserSelectsService() {
        objCalendar.SelectService();
    }

    @And("click on create button")
    public void clickOnCreateButton() {
        objCalendar.btnCreate();
    }

    @Then("The appointment is created successfully")
    public void theWalkingAppointmentIsCreatedSuccessfully(DataTable tableslots) {
        List<List<String>> data = tableslots.asLists(String.class);
        System.out.println("Time:" + data.get(1).get(1));
        objCalendar.btnTimeSlot(data.get(1).get(0),data.get(1).get(1));
        objCalendar.checkApptBox();
        objCalendar.closeIcon();
    }

    @And("the user select walk in customer")
    public void theUserSelectWalkInCustomer() {
        objCalendar.btnWalkin();
    }


    @When("the user clicks on the calendar time slot")
    public void theUserClicksOnTheCalendarTimeSlot(DataTable tableslots) {
        List<List<String>> data = tableslots.asLists(String.class);
        System.out.println("Time:" + data.get(1).get(1));
        objCalendar.btnTimeSlot(data.get(1).get(0),data.get(1).get(1));
    }

    @And("the user search a customer from the vendor")
    public void theUserSearchACustomerFromTheVendor(DataTable tableuser){
        List<List<String>> datauser0 = tableuser.asLists(String.class);
        System.out.println("First Name:" + datauser0.get(1).get(0));
        System.out.println("Phone Number:" + datauser0.get(1).get(1));
        objCalendar.fillSearchCustomer(datauser0.get(1).get(1));
    }

    @And("the user search a customer by name from the vendor")
    public void theUserSearchACustomerByNameFromTheVendor(DataTable tableuser){
        List<List<String>> datauser = tableuser.asLists(String.class);
        System.out.println("First Name:" + datauser.get(1).get(0));
        System.out.println("Phone Number:" + datauser.get(1).get(1));
        objCalendar.fillSearchCustomer(datauser.get(1).get(0));
    }
}
