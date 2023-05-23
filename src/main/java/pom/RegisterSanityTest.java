package pom;

import org.openqa.selenium.By;
import utils.Utilities;

public class RegisterSanityTest {

    private final By LNKREG = By.linkText("Register");
    private final By USRNOM = By.xpath("//input[@name='username']");
    private final By PWD = By.name("password");
    private final By RPTPWD = By.name("password2");
    private final By GNDR = By.xpath("//input[@value='M']");
    private final By ADDR = By.xpath("//textarea[@id='taid']");
    private final By BILLADDR = By.xpath("//textarea[@id='btaid']");
    private final By CHKBXTERMS = By.xpath("//input[@name='agree']");
    private final By BTNREGISTER = By.xpath("//input[@value='Register']");
    private final By BTNCANCEL = By.xpath("//input[@value='Cancel']");
    private final By BCKLG = By.linkText("Go back to login");
    private final By SLCTSTATE = By.name("state");

    public RegisterSanityTest fillForm(String strUserName, String strPassword, String addr, String billaddr, String state){
        Utilities.el(LNKREG);
        Utilities.click(LNKREG);
        Utilities.wt( 500);
        Utilities.type(USRNOM, strUserName);
        Utilities.wt( 100);
        Utilities.type(PWD,strPassword);
        Utilities.type(RPTPWD,strPassword);
        Utilities.wt( 100);
        Utilities.click(GNDR);
        Utilities.type(ADDR,addr);
        Utilities.type(BILLADDR,billaddr);
        Utilities.selectXName(SLCTSTATE, state);
        Utilities.wt( 100);
        Utilities.click(CHKBXTERMS);
        return this;
    }

    public RegisterSanityTest btnRegister(){
        Utilities.click(BTNREGISTER);
        return this;
    }
    public RegisterSanityTest btnCancel(){
        Utilities.click(BTNCANCEL);
        return this;
    }

    public RegisterSanityTest lnkbckToLogin(){
        Utilities.click(BCKLG);
        return this;
    }
}
