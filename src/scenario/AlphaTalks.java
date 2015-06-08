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

public class AlphaTalks extends ReusableMethods {

	public ArrayList<String> postIdList = new ArrayList<String>();

	@Test(priority = 1, description = "Testing the number of Post's displaying default")
	public void defaultPostsDisplayingTest(Method method) throws InterruptedException {

		Logger log = Logger.getLogger(method.getName());
		PropertyConfigurator.configure("Log4j.properties");
		log.info("User Successfully navigated to HOME_PAGE");
		Thread.sleep(8000);
		waitForElementPresent(Obj.getIdentify("alphatalkContent"), Obj.getLocation("alphatalkContent"));
		WebElement alphatalkContentElements = getElement(Obj.getIdentify("alphatalkContent"), Obj.getLocation("alphatalkContent"));
		List<WebElement> AllPostIds = alphatalkContentElements.findElements(By.tagName("article"));
		Assert.assertEquals(AllPostIds.size(), 10);
		log.info("Totel number of Post's::" + AllPostIds.size());

		for (WebElement postIds : AllPostIds) {
			String postId = postIds.getAttribute("id");
			postIdList.add(postId);
		}
		for (int i = 0; i < postIdList.size(); i++) {
			System.out.println(postIdList.get(i));
		}

	}

}
