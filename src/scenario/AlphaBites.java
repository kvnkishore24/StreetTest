package scenario;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.Obj;
import util.ReusableMethods;

public class AlphaBites extends ReusableMethods {
	public ArrayList<String> biteIdList = new ArrayList<String>();
	

	@Test(priority = 1, description = "Testing the number of Bite's displaying default")
	public void defaultBitesDisplayingTest(Method method) throws InterruptedException {

		Logger log = Logger.getLogger(method.getName());
		PropertyConfigurator.configure("Log4j.properties");
		log.info("User Successfully navigated to HOME_PAGE");
		Thread.sleep(8000);
		waitForElementPresent(Obj.getIdentify("alphabitesContent"), Obj.getLocation("alphabitesContent"));
		WebElement alphaBiteContentElements = getElement(Obj.getIdentify("alphabitesContent"), Obj.getLocation("alphabitesContent"));
		List<WebElement> allBiteIds = alphaBiteContentElements.findElements(By.tagName("article"));
		Assert.assertEquals(allBiteIds.size(), 10);
		log.info("Totel number of Bite's::" + allBiteIds.size());
		
		for (WebElement biteIds : allBiteIds) {
			 String biteId = biteIds.getAttribute("id");
			 biteIdList.add(biteId);
		
		}
		for (int i = 0; i < biteIdList.size(); i++) {
			System.out.println(biteIdList.get(i));
		}
	}
}
