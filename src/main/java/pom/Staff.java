package pom;

import org.openqa.selenium.By;
import utils.Utilities;

public class Staff {

    private final By STAFFMENU = By.xpath("//*[@id='__next']/div/div/div/ul/div[@aria-label='Staff']");
    private final By STAFFHEADER = By.xpath("//div/div[text()='Staff']");
    private final By ADDNEWSTAFF = By.xpath("//button[text()='ADD NEW']");
    private final By FIRSTNAME = By.name("firstName");
    private final By LASTNAME = By.name("lastName");
    private final By EMAIL = By.name("email");
    private final By USERNAME = By.name("username");
    private final By PASSWORD = By.name("password");
    private final By ORDER = By.name("order");
    private final By SERVICECOMISSION = By.name("serviceComission");
    private final By PRODUCTCOMISSION = By.name("productComission");
    private final By SUBMITSTAFF = By.xpath("//button[text()='Submit']");

//    public Inventory fillInventory(String strUserName, String strPassword){
//        Utilities.type(, strUserName);
//        Utilities.type(,strPassword);
//
//        return this;
//    }

    public Staff btnStaff(){
        Utilities.clickWait(STAFFMENU);
        return this;
    }

    public Staff chckMessage(String message1) {
        Utilities.isElementPresent(STAFFHEADER);
        Utilities.wt( 2000);
        Utilities.compareText(STAFFHEADER, message1);
        return this;
    }

    public Staff btnAddNewStaff(){
        Utilities.clickWait(ADDNEWSTAFF);
        return this;
    }

//    public Staff fillFormStaff(String FirstName, String LastName, String Email, String Username, String Password, String Price){
//        Utilities.type(FIRSTNAME, FirstName);
//        Utilities.type(LASTNAME, LastName);
//        Utilities.type(EMAIL, Email);
//        Utilities.type(USERNAME, Username);
//        Utilities.type(PASSWORD, Password);
//        System.out.println(ProductBrand);
//        System.out.println(ProductCategory);
//        if (!Objects.equals(ProductBrand, "")) Utilities.clickEnter(PRODUCTBRAND);
//        if (!Objects.equals(ProductCategory, "")) Utilities.clickEnter(PRODUCTCATEGORY);
//        return this;
//    }



//    public Inventory chckMessageVendor(String message1, String message2 ) {
//        Utilities.compareText(MESSAGEUSERNAME, message1);
//        Utilities.compareText(MESSAGEPWD, message2);
//        return this;
//    }

//    public Inventory chckMessageError(String message3) {
//        Utilities.compareText(MESSAGEERROR, message3);
//        return this;
//    }
}
