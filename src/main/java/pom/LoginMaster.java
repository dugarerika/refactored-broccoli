package pom;
import org.openqa.selenium.By;
import utils.Utilities;

public class LoginMaster {
    private final By USERNAME = By.xpath("//input[@name='username']");
    private final By PASSWORD = By.xpath("//input[@name='password']");
    private final By LOGIN = By.xpath("//button");
    private final By MESSAGE = By.xpath("//div[@aria-describedby]");

    public LoginMaster fillLogin(String strUserName, String strPassword){
        Utilities.type(USERNAME, strUserName);
        Utilities.type(PASSWORD,strPassword);
        return this;
    }

    public LoginMaster btnlogIn(){
        Utilities.click(LOGIN);
        return this;
    }

    public LoginMaster chckMessage(String message) {
        Utilities.printer(MESSAGE);
        Utilities.compareText(MESSAGE, message);
        return this;
    }
}
