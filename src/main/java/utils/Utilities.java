package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Utilities {
	static WebDriver driver;
	static Actions ac;
	static WebDriverWait wait;

	
	public static void openUrl(String strUrl){
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get(strUrl);
		driver.manage().window().maximize();
		ac = new Actions(driver);
	}

	public static boolean isElementPresent(By by) {
		try {
//			WebDriverWait wait = new WebDriverWait(driver, 1);
			wait.until(ExpectedConditions.or(ExpectedConditions.presenceOfElementLocated(by),
					ExpectedConditions.elementToBeSelected(by),
					ExpectedConditions.invisibilityOfElementLocated(by),
					ExpectedConditions.elementToBeClickable(by),
					ExpectedConditions.presenceOfNestedElementLocatedBy(by, null)));
			return true;
		} catch (NoSuchElementException | TimeoutException e) {
			return false;
		}
	}

	public static WebElement el(By by) {
		return driver.findElement((By) by);
	}


	public static String base64Screenshot(){
		return "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}
	
	public static List<WebElement> els(By by) {
		return driver.findElements((By) by);
	}

	public static void wt(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

//	public static void waitForElement(By by, long timeOutInSeconds) {
//		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
//		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(by),
//				ExpectedConditions.elementToBeSelected(by),
//				ExpectedConditions.presenceOfNestedElementLocatedBy(by, null)));
//	}
		
	public static void closeExplorer() {
		driver.close();
	}
	
	public static void closeProcess() {
		driver.quit();
	}
	
	public static void type(By by, String str) {
		el(by).sendKeys(str);
	}
	
	public static void click(By by) {
		el(by).click();
	}

	public static boolean clickWait(By by) {
		try{
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
		return true;
	} catch (NoSuchElementException | TimeoutException e) {
		return false;
	}
	}

	public static void clickEnter(By by) {
		el(by).click();
		ac.sendKeys(Keys.ENTER).perform();
	}

	public static void Tabs(String str) {
		ac.sendKeys(Keys.TAB).perform();
		ac.sendKeys(Keys.TAB).perform();
		ac.sendKeys(Keys.TAB).perform();
		ac.sendKeys(str).perform();
	}

	public static void HooverClick(By by) {
		ac = new Actions(driver);
		ac.moveToElement(el(by));
		ac.click().build().perform();
	}

	public static void Enter() {
		ac.sendKeys(Keys.ENTER).perform();
	}

	public static void clickType(By by) {
		el(by).click();
		ac.sendKeys(el(by),"Al Salam").perform();
//		ac.sendKeys(Keys.ENTER).perform();
	}

	public static void hoover(By by) {
		ac.moveToElement(el(by)).click();
	}
	
	public static String getText(By by) {
		return el(by).getText();
	}

	public static String getDateYYYYMMDDHHMMSS() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static boolean isAlertPresent() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 1);
			wait.until(ExpectedConditions.alertIsPresent());
			return true;
		} catch (NoSuchElementException | TimeoutException e) {
			return false;
		}
	}

	public static void closeAlert(){
		Alert objAlert = driver.switchTo().alert();
		objAlert.accept();
	}

	public static void executeScript(String script) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(script);
	}

	public static void scrollDown() {
		executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	public static void selectXName(By by, String str) {
		Select objSelect = new Select(el(by));
		objSelect.selectByVisibleText(str);
	}

	public static void selectXIndex(By by, Integer n) {
		Select objSelect = new Select(el(by));
		objSelect.selectByIndex(n);
	}


	public static void printer(By by) {
		String text = getText(by);
		System.out.print(text);
	}

	public static String gText(By by) {
		String text = getText(by);
		return(text);
	}

	public static boolean compareText(By by, String str) {
		String text = getText(by);
		System.out.println(text);
		if (str.equals(text)) {
			System.out.println("passed");
			return true;
		}
		else System.out.println("fail");
		return false;
	}
	}