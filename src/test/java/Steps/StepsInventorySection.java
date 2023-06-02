package Steps;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import pom.Inventory;
import pom.LoginVendor;
import utils.Utilities;

import java.util.List;

public class StepsInventorySection {

    private final By COSTPRICE = By.xpath("//div/label[text()='Cost Price']//following-sibling::div/input");
    private final By SUPPLIERPHONE = By.xpath("//div/label[text()='Supplier Phone']//following-sibling::div/input");

    static LoginVendor objLogin = new LoginVendor();
    Inventory objInventory = new Inventory();


    @BeforeAll
    public  void beforeAll() {
        Utilities.openUrl("https://vendor.bookr-dev.com");
        objLogin.fillLogin("testsalon", "testsalon1o");
        objLogin.btnlogInVendor();
    }

//    @After
//    public void afterScenario() {
//        Utilities.closeExplorer(); Utilities.closeProcess();
//    }

    @And("the user login into the vendor with Admin credentials")
    public void theUserLoginIntoTheVendorWithAdminCredentials(DataTable table) {
        List<List<String>> data = table.asLists(String.class);
        objLogin.fillLogin(data.get(1).get(0), data.get(1).get(1));
        objLogin.btnlogInVendor();
    }

    @When("the user clicks on the inventory icon")
    public void theUserClicksOnTheInventoryIcon() {
        objInventory.btnInventory();
    }

    @Then("the user has access to the inventory section")
    public void theUserHasAccessToTheInventorySection() {
        objInventory.chckMessage("Inventory");
    }

    @When("the user clicks on the ADD PRODUCT button")
    public void theUserClicksOnTheADDPRODUCTButton() {
        objInventory.btnAddProduct();
    }

    @Then("the Add Product form is displayed")
    public void theAddProductFormIsDisplayed() {
    }

    @When("the user clicks on the ADD BRAND button")
    public void theUserClicksOnTheADDBRANDButton() {
        objInventory.btnAddBrand();
    }

    @Then("the Add Brand form is displayed")
    public void theAddBrandFormIsDisplayed() {

    }

    @And("click on the Submit button")
    public void clickOnTheSubmitButton() {objInventory.btnAddProductSubmit();
    }

    @And("the user enters ([^\"]*) and ([^\"]*) and ([^\"]*) and ([^\"]*) and ([^\"]*) and ([^\"]*)$")
    public void theUserEntersProductNameAndProductBrandAndProductCategoryAndProductQuantityAndProductSKUAndPriceInfo(String ProductName, String ProductBrand, String ProductCategory, String ProductQuantity, String ProductSKU, String Price) {
        objInventory.fillForm(ProductName, ProductBrand, ProductCategory, ProductQuantity, ProductSKU, Price);
    }

    @Then("The ([^\"]*) is displayed$")
    public void theExpectedMessageIsDisplayed(String ExpectedMessage) {
        objInventory.chckExpectedMsg(ExpectedMessage);
    }

    @And("clicks on close form")
    public void clicksOnCloseForm() {
        objInventory.btnCloseAddForm();
    }

    @And("Close")
    public void close_b() {
        Utilities.closeExplorer(); Utilities.closeProcess();
    }

    @When("the user clicks on the + icon")
    public void theUserClicksOnTheIcon() {
        objInventory.btnInventory();
        objInventory.btnAddBrand();
        objInventory.btnAddIcon();
    }

    @And("type a New Brand")
    public void typeANewBrand(DataTable table) {
        List<List<String>> data = table.asLists(String.class);
        objInventory.fillBrandName(data.get(1).get(0));
    }

    @And("Click on CREATE button")
    public void clickOnCREATEButton() {
        objInventory.btnAddCreate();
    }

    @Then("the new brand is added successfully")
    public void theNewBrandIsAddedSuccessfully() {
    }

    @And("the user clicks on the delete icon button")
    public void theUserClicksOnTheDeleteIconButton() {
        objInventory.DeleteIcon();
    }

    @Then("the delete product modal is displayed")
    public void theDeleteProductModalIsDisplayed() {
        objInventory.chckDeleteModal();
    }

    @And("click on CANCEL")
    public void clickOnCANCEL() {
        objInventory.btnCancelDelete();
    }

    @Then("The product is delete successfully")
    public void theProductIsDeleteSuccessfully() {
        objInventory.chckMessageDelete();
    }

    @And("click on DELETE")
    public void clickOnDELETE() {
        objInventory.btnConfirmDelete();
    }

    @And("the ([^\"]*) Cost Price$")
    public void theCostPriceInfo(String CostPrice) {
        Utilities.type(COSTPRICE, CostPrice);
    }

    @And("the ([^\"]*) Supplier Phone$")
    public void theSupplierPhoneSupplierPhone(String SupplierPhone) {
        Utilities.type(SUPPLIERPHONE, SupplierPhone);
    }

//    @And("([^\"]*) info$")
//    public void costpriceInfo(String CostPrice) {
//        objInventory.fillNonReq(CostPrice);
//    }

//    @AfterAll
//    public static void afterAll() {
//        Utilities.closeExplorer(); Utilities.closeProcess();
//        System.out.println("After All Hook");
//    }
}
