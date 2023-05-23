package Steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.LoginVendor;
import utils.Utilities;

import java.util.List;

public class StepsLogInVendor {

    LoginVendor objLogin = new LoginVendor();

//    @Given("user is on the vendor login page ([^\"]*)$")
//    public void user_is_on_the_vendor_login_page() {
//        Utilities.openUrl("https://vendor.bookr.co");
//        System.out.println("The vendor admin login page is displayed");
//    }

    @And("hits SIGN IN")
    public void hits_SIGN_IN() {
        objLogin.btnlogInVendor();
        System.out.println("The user clicked on SIGN IN");
    }
    @Then("the user should be logged successfully")
    public void the_user_should_be_logged_successfully() {
        System.out.println("The user is logged in");
    }

    @Then("error messages are displayed")
    public void error_messages_are_displayed() {
        objLogin.chckMessageVendor("username address is required","Password is required");
    }
 
    @And("Close browser")
    public void close_browser() {
        Utilities.closeExplorer(); Utilities.closeProcess();
    }

    @Then("An error message is displayed")
    public void anErrorMessageIsDisplayed() {
        objLogin.chckMessageError("['The email and password combination is incorrect']");
    }
    @When("the user left credentials empty")
    public void theUserLeftCredentialsEmpty() {
        System.out.println("Email and password credentials left empty");
    }

    @Then("error message username address is required is displayed")
    public void errorMessageUsernameAddressIsRequiredIsDisplayed() {
        objLogin.chckMessageVendor("username address is required"," ");
    }

    @Then("error message Password is required displayed")
    public void errorMessagePasswordIsRequiredDisplayed() {
        objLogin.chckMessageVendor(" ","Password is required");
    }
    @When("the user enters credentials ([^\"]*) and ([^\"]*) and ([^\"]*)$")
    public void theUserEntersCredentialsRoleEmailPassword(String Role, String Email, String Password) throws Throwable{
        System.out.println("Role:" + Role);
        if (Email == null) objLogin.fillLogin("", Password);
        else if (Password == null)  objLogin.fillLogin(Email, "");
        else objLogin.fillLogin(Email, Password);
    }

    @Given("the user login into the vendor with ([^\"]*) and ([^\"]*) from ([^\"]*) credentials$")
    public void theUserLoginIntoTheVendorWithEmailAndPasswordFromRoleCredentials(String Email, String Password, String Role) throws Throwable{
        System.out.println("Role:" + Role);
        if(Email == null) objLogin.fillLogin("", Password);
        else if (Password == null)  objLogin.fillLogin(Email, "");
        else objLogin.fillLogin(Email, Password);
    }

    @When("the user enters credentials")
    public void theUserEntersCredentials(DataTable table) {
        List<List<String>> data = table.asLists(String.class);
        System.out.print(data.get(1).get(0));
        System.out.print(data.get(1).get(1));
        if(data.get(1).get(0) == null) objLogin.fillLogin("", data.get(1).get(1));
        else if (data.get(1).get(1) == null)  objLogin.fillLogin(data.get(1).get(0), "");
        else objLogin.fillLogin(data.get(1).get(0), data.get(1).get(1));
    }

    @Given("user is on the vendor login page")
    public void user_is_on_the_vendor_login_page(DataTable table) {
        List<List<String>> data = table.asLists(String.class);
        System.out.print(data.get(1).get(0));
        Utilities.openUrl(data.get(1).get(0));
        System.out.println("The vendor admin login page is displayed");
    }
}
