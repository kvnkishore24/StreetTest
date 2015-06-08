package scenario;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import util.Obj;
import util.ReusableMethods;

public class UserValidation extends ReusableMethods {

	Logger log = Logger.getLogger(UserValidation.class.getName());

	private String baseURL = "http://asdev.digital-nirvana.com/demo1/";

	// @Parameters({ "baseURL" })
	@Parameters({ "browsername" })
	@Test
	// public void login(String baseURL, Method method) throws Throwable {
	public void homePageTest(String browsername, Method method)

	{
		Logger log = Logger.getLogger(method.getName());
		PropertyConfigurator.configure("Log4j.properties");
		log.info(browsername + " launches successfully");
		driver.get(baseURL);
		driver.manage().window().maximize();
		log.info("AlphaStreet Page loaded successfully");
		log.info(" looking for Alpha Street Home page Logo");
		WebElement logoElement = getElement(Obj.getIdentify("Joinbtn"), Obj.getLocation("Joinbtn"));

		if (logoElement.isDisplayed()) {
			log.info(" Successfully navigated to home page");
		} else {
			log.info(logoElement + "unable to locate AS logo");
		}
	}

	@Test
	public void loginTest(Method method) {

		Logger log = Logger.getLogger(method.getName());
		getElement(Obj.getIdentify("Joinbtn"), Obj.getLocation("Joinbtn")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		log.info(" User clicked JoinIn/SignIn Button");

		try {
			Thread.sleep(10000);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement emailTextbox = getElement(Obj.getIdentify("emailbox"), Obj.getLocation("emailbox"));
			
			emailTextbox.sendKeys("kvn.kishore24@gmail.com");
			log.info(" Typed Email in Email-TextBox");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement passwordTextbox = getElement(Obj.getIdentify("passwordbox"), Obj.getLocation("passwordbox"));
		passwordTextbox.clear();
		try {
			Thread.sleep(5000);
			passwordTextbox.sendKeys("test123");
			log.info(" Typed Password in Password-TextBox");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
			click(Obj.getIdentify("signinbtn"), Obj.getLocation("signinbtn"));
			log.info(" User clicked signin Button");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 1,enabled=false)
	public void userNameTest(Method method) {
		Logger log = Logger.getLogger(method.getName());

		WebElement welcomemsg = getElement(Obj.getIdentify("welcometxt"), Obj.getLocation("welcometxt"));
		// Assert.assertTrue(welcomemsg.isDisplayed());
		if (welcomemsg.isDisplayed()) {

			log.info(" The user has successfully logged into AlphaStreet");
			String userNameStatus = welcomemsg.getText();
			Assert.assertTrue(!userNameStatus.isEmpty());
			log.info(userNameStatus);
		}

	}

	@Test(priority = 2,enabled=false)
	public void userEmailTest(Method method) {
		Logger log = Logger.getLogger(method.getName());
		log.info(" Looking for User Emailid");
		WebElement userEmail = getElement(Obj.getIdentify("usermailtxt"), Obj.getLocation("usermailtxt"));
		String userEmailTxt = userEmail.getText();
		if (!userEmailTxt.isEmpty()) {
			Assert.assertTrue(true);
			log.info(" GUI Passed:Mail id displaying");
			log.info(" i.e " + userEmailTxt);
		} else {
			log.warn(" Gui faild:Mail id not displaying");
		}

	}

	@Test(priority = 3,enabled=false)
	public void shareTest(Method method) {
		Logger log = Logger.getLogger(method.getName());
		PropertyConfigurator.configure("Log4j.properties");

		log.info("User Successfully navigated to HOME_PAGE");

		WebElement shareElement = getElement(Obj.getIdentify("sharetabbtn"), Obj.getLocation("sharetabbtn"));
		if (shareElement.isDisplayed()) {
			log.info(" Share-Tab Displaying");
		} else {
			log.info("-----ERROR--Unable to locate----");
		}
		shareElement.click();
		log.info(" Share-Tab cliked");

		WebElement textareaElement = getElement(Obj.getIdentify("postingtextarea"), Obj.getLocation("postingtextarea"));

		if (textareaElement.isDisplayed()) {
			try {
				Thread.sleep(5000L);
				log.info(" Textarea  Displaying");

			} catch (InterruptedException e) {

				e.getMessage();
			}

		} else {
			log.info("-----ERROR--Unable to locate SahreTab----");

		}

		Actions a1 = new Actions(driver);
		a1.moveToElement(textareaElement).build().perform();

		try {
			Thread.sleep(8000L);
			textareaElement
					.sendKeys("$MDT 4Q15 Q&A Update - Gary, CFO: On the transfer pricing issue in Puerto Rico, the court heard the case. We are waiting for the judge’s decision. It’s probably going to be closer towards end of fiscal year before we hear anything on it, but it’s all based on their timing.");
			log.info("Text added in post_txt_area");
		} catch (InterruptedException e) {

			e.getMessage();
		}
		WebElement postSubmitElement = getElement(Obj.getIdentify("postbtn"), Obj.getLocation("postbtn"));
		postSubmitElement.click();
		log.info("Share posted successfully");

	}

	@Test(priority = 4,enabled=false)
	public void userLogOutTest(Method method) {
		Logger log = Logger.getLogger(method.getName());
		WebElement userEmail = getElement(Obj.getIdentify("usermailtxt"), Obj.getLocation("usermailtxt"));
		WebElement userLogoutlink = getElement(Obj.getIdentify("logoutlink"), Obj.getLocation("logoutlink"));
		userEmail.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String userLogoutTxt = userLogoutlink.getText();

		if (!userLogoutTxt.isEmpty()) {
			Assert.assertTrue(true);
			log.info(" GUI Passed:LogOut Diplaying");
			log.info(" i.e " + userLogoutTxt);
		} else {
			log.warn("GUI Faild: LogOut not displaying");
			Assert.assertFalse(false, "GUI Faild: LogOut not displaying");
		}
		userLogoutlink.click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		log.info(" User Clicked on LogOut");

	}

}
