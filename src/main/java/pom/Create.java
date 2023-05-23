package pom;


import org.openqa.selenium.By;
import utils.Utilities;

import javax.swing.border.TitledBorder;

public class Create {

    private final By CREATE = By.xpath("//*[@id='__next']/div/div[2]/div/div[1]/button");
    private final By MESSAGE2 = By.xpath("//*[@id='notistack-snackbar']");

    private final By FIRSTNAME = By.name("firstName");
    private final By LASTNAME = By.name("lastName");
    private final By MOBILE = By.name("mobileNo");
    private final By EMAIL = By.name("email");
    private final By PASS = By.name("password");

    private final By NAME = By.name("name");
    private final By SLUG = By.name("slug");
    private final By VAT = By.name("vatTax");
    private final By VATNO = By.name("vatNo");
    private final By MINIMUM = By.name("minCharges");
    private final By COMISSION = By.name("commissionAmount");
    private final By DESCRIPTION = By.name("description");
    private final By DELIVERY = By.xpath("//div[@class=' css-1hwfws3']/div[text()='Bookr delivery']");
    private final By GENDER = By.xpath("//div[@class=' css-1hwfws3']/div[text()='Gender']");
    private final By STATUS = By.xpath("//div[@class=' css-ngw5j5-control']/div[@class=' css-1hwfws3']/div[text()='Status']");
    private final By FEATURE = By.xpath("//div[@class=' css-ngw5j5-control']/div[@class=' css-1hwfws3']/div[text()='Is featured']");
    private final By PRIMARY = By.xpath("//div[@class=' css-1hwfws3']/div[text()='Primary']");
    private final By MOBILENO = By.name("mobileNo");
    private final By TITLE = By.name("title");
    private final By BLOCK = By.name("block");
    private final By BUILDING = By.name("title");
    private final By FLOOR = By.name("floor");
    private final By APARTMENT = By.name("apartment");
    private final By LATITUD = By.name("latitude");
    private final By LONGITUD = By.name("longitude");
    private final By AREA = By.xpath("//div[@class='select__value-container css-1hwfws3']/div[text()='Search Area']");




    private final By SUBMIT = By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/form/button/span[1]");

    public Create fillCreate(String strFName, String strLName, String strMobile, String strEmail, String strPass, String strName, String strSlug, String strVat, String strVatno, String strMinimum, String strMobileno){
        Utilities.type(FIRSTNAME, strFName);
        Utilities.type(LASTNAME,strLName);
        Utilities.type(MOBILE, strMobile);
        Utilities.type(EMAIL,strEmail);
        Utilities.type(PASS, strPass);
        Utilities.type(NAME,strName);
        Utilities.type(SLUG,strSlug);
        Utilities.type(VAT, strVat);
        Utilities.type(VATNO,strVatno);
        Utilities.type(MINIMUM,strMinimum);
        Utilities.type(COMISSION,strVatno);
        Utilities.type(DESCRIPTION,strMinimum);
        Utilities.clickEnter(DELIVERY);
        Utilities.clickEnter(GENDER);
        Utilities.clickEnter(STATUS);
        Utilities.clickEnter(FEATURE);
        Utilities.scrollDown();
        Utilities.clickEnter(PRIMARY);
        Utilities.type(MOBILENO, strMobileno);
        Utilities.type(TITLE, strFName);
        Utilities.type(BLOCK, strVat);
        Utilities.type(BUILDING, strVat);
        Utilities.type(FLOOR, strVat);
        Utilities.type(APARTMENT, strVat);
        Utilities.type(LATITUD, strVat);
        Utilities.type(LONGITUD, strVat);
        Utilities.clickType(AREA);
        Utilities.wt( 10000);
        Utilities.Enter();

        return this;
    }

    public Create fillCreateNotGender(String strFName, String strLName, String strMobile, String strEmail, String strPass, String strName, String strSlug, String strVat, String strVatno, String strMinimum, String strMobileno){
        Utilities.type(FIRSTNAME, strFName);
        Utilities.type(LASTNAME,strLName);
        Utilities.type(MOBILE, strMobile);
        Utilities.type(EMAIL,strEmail);
        Utilities.type(PASS, strPass);
        Utilities.type(NAME,strName);
        Utilities.type(SLUG,strSlug);
        Utilities.type(VAT, strVat);
        Utilities.type(VATNO,strVatno);
        Utilities.type(MINIMUM,strMinimum);
        Utilities.type(COMISSION,strVatno);
        Utilities.type(DESCRIPTION,strMinimum);
        Utilities.clickEnter(DELIVERY);
        Utilities.clickEnter(STATUS);
        Utilities.clickEnter(FEATURE);
        Utilities.scrollDown();
        Utilities.clickEnter(PRIMARY);
        Utilities.type(MOBILENO, strMobileno);
        Utilities.type(TITLE, strFName);
        Utilities.type(BLOCK, strVat);
        Utilities.type(BUILDING, strVat);
        Utilities.type(FLOOR, strVat);
        Utilities.type(APARTMENT, strVat);
        Utilities.type(LATITUD, strVat);
        Utilities.type(LONGITUD, strVat);
        return this;
    }


    public Create btnSubmit(){
        Utilities.click(SUBMIT);
        return this;
    }




    public Create btncreate(){
        Utilities.click(CREATE);
        return this;
    }
    public Create chckMessage(String message) {
        Utilities.printer(MESSAGE2);
        Utilities.compareText(MESSAGE2, message);
        return this;
    }
}
