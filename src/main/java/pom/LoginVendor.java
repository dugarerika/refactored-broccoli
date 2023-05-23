package pom;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Utilities;

import java.util.Objects;

public class LoginVendor{
    private final By USERNAME = By.xpath("//input[@name='username']");
    private final By PASSWORD = By.xpath("//input[@name='password']");
    private final By LOGIN = By.xpath("//button[text()='Sign in']");
    private final By MESSAGEUSERNAME = By.id("mui-1-helper-text");
    private final By MESSAGEPWD = By.id("mui-2-helper-text");
    private final By MESSAGEERROR = By.xpath("//div/div/div/form/div/p[text()]");


    public LoginVendor fillLogin(String strUserName, String strPassword){
        Utilities.type(USERNAME, strUserName);
        Utilities.type(PASSWORD,strPassword);
        return this;
    }

    public LoginVendor btnlogInVendor(){
        Utilities.click(LOGIN);
        return this;
    }

    public LoginVendor chckMessageVendor(String message1, String message2 ) {
        Utilities.wt( 100);
        if((!Objects.equals(message1, " "))) Utilities.compareText(MESSAGEUSERNAME, message2);
        if((!Objects.equals(message2, " "))) Utilities.compareText(MESSAGEPWD, message1);
        return this;
    }

    public LoginVendor chckMessageError(String message3) {
        Utilities.wt( 1000);
        Assert.assertTrue( Utilities.compareText(MESSAGEERROR, message3));
        return this;
    }
}
