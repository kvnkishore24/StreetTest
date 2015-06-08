package scenario;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import util.Obj;
import util.ReusableMethods;

public class Login extends ReusableMethods {

	Logger log = Logger.getLogger(UserValidation.class.getName());

	private String baseURL = "http://asdev.digital-nirvana.com/demo1/";

	
	@Parameters({ "browsername" })
	@Test
	// public void login(String baseURL, Method method) throws Throwable {
	public void loginWithValidDetails(String browsername, Method method)

	{
		Logger log = Logger.getLogger(method.getName());
		PropertyConfigurator.configure("Log4j.properties");
		log.info(browsername+" launched");
		driver.get(baseURL);
		driver.manage().window().maximize();
		getElement(Obj.getIdentify("Joinbtn"), Obj.getLocation("Joinbtn")).click();
		log.info(" User clicked JoinIn/SignIn Button");
			
		try {
			Thread.sleep(5000);
			WebElement emailTextbox = getElement(Obj.getIdentify("emailbox"), Obj.getLocation("emailbox"));
			emailTextbox.sendKeys(prop.getProperty("userValidEmail"));
			log.info(" Typed Email in Email-TextBox");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement passwordTextbox = getElement(Obj.getIdentify("passwordbox"), Obj.getLocation("passwordbox"));
		passwordTextbox.clear();
		try {
			Thread.sleep(5000);
			passwordTextbox.sendKeys(prop.getProperty("userValidPassword"));
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
		

	}
}
