package scenario;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import util.Obj;
import util.ReusableMethods;

public class Sample extends ReusableMethods {

	@Test(priority = 1, description = "Testing Share Tab by Posting on post")
	public void shareTest(Method method) throws InterruptedException  {

		Logger log = Logger.getLogger(method.getName());
		PropertyConfigurator.configure("Log4j.properties");

		log.info("User Successfully navigated to HOME_PAGE");
		Thread.sleep(8000);
		waitForElementPresent(Obj.getIdentify("sharetabbtn"), Obj.getLocation("sharetabbtn"));
		WebElement shareElement = getElement(Obj.getIdentify("sharetabbtn"), Obj.getLocation("sharetabbtn"));

		shareElement.click();
		log.info(" Share-Tab cliked");
		waitForElementPresent(Obj.getIdentify("postingtextarea"), Obj.getLocation("postingtextarea"));
		WebElement textareaElement = getElement(Obj.getIdentify("postingtextarea"), Obj.getLocation("postingtextarea"));

		if (textareaElement.isDisplayed()) {
			try {
				log.info(" Textarea  Displaying");
			} catch (Exception e) {
				e.getMessage();
			}
		} else {
			log.warn("-----ERROR--Unable to locate SahreTab----");
		}

		Actions a1 = new Actions(driver);
		a1.moveToElement(textareaElement).build().perform();

		try {
			textareaElement.sendKeys("$MDT  Gary, CFO: On the transfer pricing issue in Puerto Rico, " + "the court heard the case. " + "We are waiting for the judge’s decision."
					+ " It’s probably going to be closer towards end of fiscal year before we hear anything on it, but it’s all based on their timing.");
			log.info("Post ad");
		} catch (Exception e) {
			log.warn(e.getMessage());
			log.warn("Unable to find or typed ticker in Estimate-Ticker-TxtBox");
		}
		waitForElementPresent(Obj.getIdentify("postbtn"), Obj.getLocation("postbtn"));
		WebElement postSubmitElement = getElement(Obj.getIdentify("postbtn"), Obj.getLocation("postbtn"));
		postSubmitElement.click();
		log.info("Cliked on POST-Button ");
		

	}

	@Test(enabled=false,priority = 1, description = "Testing Estimate Tab")
	public void estimateTest(Method method) throws InterruptedException {
		Logger log = Logger.getLogger(method.getName());
		PropertyConfigurator.configure("Log4j.properties");
		Thread.sleep(5000);

		try {

			WebElement tickerElement = getElement(Obj.getIdentify("estimatetabBtn"), Obj.getLocation("estimatetabBtn"));
			waitForElementPresent(Obj.getIdentify("estimatetabBtn"), Obj.getLocation("estimatetabBtn"));
			tickerElement.click();

		} catch (Exception e) {
			log.warn(e.getMessage());
			log.warn("Unable to find or typed ticker in Estimate-Ticker-TxtBox");
		}
		try {
			waitForElementPresent(Obj.getIdentify("estimatetickerBox"), Obj.getLocation("estimatetickerBox"));
			WebElement tickerElement = getElement(Obj.getIdentify("estimatetickerBox"), Obj.getLocation("estimatetickerBox"));

			tickerElement.clear();
			Thread.sleep(5000);

			tickerElement.sendKeys("$AAPL");
			log.info("Estimate Ticker Typed ");

		} catch (Exception e) {
			log.warn(e.getMessage());
			log.warn("Unable to find (or) typed ticker in Estimate-Ticker-TxtBox");
		}
		try {
			waitForElementPresent(Obj.getIdentify("estimatevalueBox"), Obj.getLocation("estimatevalueBox"));
			WebElement tickerpriceElement = getElement(Obj.getIdentify("estimatevalueBox"), Obj.getLocation("estimatevalueBox"));
			Thread.sleep(5000);
			tickerpriceElement.clear();
			tickerpriceElement.sendKeys("200");
			log.info("Estimate Ticker Value Typed ");
		} catch (Exception e) {
			log.warn(e.getMessage());
			log.warn("Unable to find (or) typed ticker in Estimate-Value-TxtBox");
		}

	}

}
