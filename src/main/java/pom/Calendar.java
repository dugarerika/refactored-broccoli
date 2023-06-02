package pom;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utils.Utilities;

import java.util.Arrays;

import static utils.Utilities.isElementPresent;

public class Calendar {

    SoftAssert softAssert = new SoftAssert();
    private final By CALENDAR = By.xpath("//div[@aria-label='Calendar']");
    private final By HEADER = By.xpath("//header/div/div/div[@class]");
    private final By MODALTITTLE = By.xpath("//div/h6[text()='New Appointment']");
    private final By SEARCHCOSTUMER = By.xpath("//div[text()='Search customers..']//parent::div//parent::div");
    private final By COSTUMER = By.xpath("//div[text()='Search customers..']/following-sibling::div/input");
    private final By CATEGORY = By.xpath("//div/div[text()='Select category...']/following-sibling::div");
    private final By SERVICE = By.xpath("//div/div[text()='Select service..']/following-sibling::div");
    private final By CLOSEICON= By.xpath("//button[@aria-label='close']");
    private final By DURATION = By.xpath("");
    private final By BUFFER = By.xpath("");
    private final By BTNADDNEW = By.xpath("");
    private final By BTNWALKIN = By.xpath("//div/button[text()='Walk in']");
    private final By BTNADDSERVICE = By.xpath("");
    private final By BTNADDOFFER = By.xpath("");
    private final By BTNADDSUBC = By.xpath("//div/button[text()='Print Booking Info']");
    private final By BTNCREATE = By.xpath("//div/button[text()='Create']");
    private final By BTNREMOVESERVICE = By.xpath("");
    private final By TXTWALKIN = By.xpath("//div/h3[text()='Walk in']");
    private final By STATUS = By.xpath("//div/span[text()='No Status']");
    private final By BTNBOOKINGINFO = By.xpath("//div/button[text()='Print Booking Info']");
    private final By BTNEDITBOOKING = By.xpath("//div/button[text()='Edit Booking']");
    private final By BTNCHECKOUT = By.xpath("//div/button[text()='Checkout']");

    public Calendar btnTimeSlot(String staff, String time)
    {
        final By POSITIONNNODE = By.xpath("//span[text()='"+staff+"']//ancestor::div[@class='rbc-time-header-content']/preceding-sibling::div[@class='rbc-time-header-content']");
        String snode = Utilities.node(POSITIONNNODE);
        final By TIMESLOT = By.xpath("//div[@class='rbc-time-content']//child::div["+snode+"]/div/div[@class='rbc-time-slot rbc-available']/span[text()='"+time+"']");
        Utilities.wt( 100);
        if (Utilities.isElementPresent(TIMESLOT))
        {
            Utilities.clickWait(TIMESLOT);
            Utilities.HooverClick(TIMESLOT);
        }
        return this;
    }

    public Calendar btnCalendar(){
        Utilities.wt( 1000);
        Utilities.clickWait(CALENDAR);
        return this;
    }

    public Calendar chckMessage(String message1) {
        isElementPresent(HEADER);
        Utilities.wt( 1000);
        Utilities.compareText(HEADER, message1);
        return this;
    }
    public Calendar chckModal() {
        Assert.assertTrue(isElementPresent(MODALTITTLE));
//        softAssert.assertAll();
        return this;
    }
    public Calendar closeIcon() {
        if(isElementPresent(CLOSEICON)) {
            Utilities.clickWait(CLOSEICON);
        } else {
            Assert.fail();
        }
        return this;
    }

    public Calendar SelectCategory() {
        Utilities.clickEnter(CATEGORY);
        return this;
    }

    public Calendar SelectService() {
        Utilities.clickEnter(SERVICE);
        return this;
    }
    public Calendar btnCreate(){
        Utilities.wt( 10);
        Utilities.clickWait(BTNCREATE);
        return this;
    }
    public Calendar checkApptBox(){
        for (By by : Arrays.asList(TXTWALKIN, STATUS, BTNBOOKINGINFO, BTNEDITBOOKING, BTNCHECKOUT)) {
            softAssert.assertTrue(isElementPresent(by));
        }
        //        softAssert.assertAll();
        return this;
    }
    public Calendar btnWalkin(){
        Utilities.wt( 10);
        Utilities.clickWait(BTNWALKIN);
        return this;
    }

    public Calendar fillSearchCustomer(String strCustomer){
        softAssert.assertTrue(isElementPresent(MODALTITTLE));
        Utilities.Tabs(strCustomer);
        Utilities.wt( 10000);
        Utilities.Enter();
//        softAssert.assertAll();
        return this;
    }
}