package scenario;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.Obj;
import util.ReusableMethods;

public class AlphaTalks extends ReusableMethods {

	private static final CharSequence TESTPOST = "$AAPL moving down by (0.55%)";
	public ArrayList<String> postIdList = new ArrayList<String>();

	@Test(priority = 1, description = "Testing the number of Post's displaying default")
	public void defaultPostsDisplayingTest(Method method) throws InterruptedException {
		ArrayList<String> postIdList = new ArrayList<String>();

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

	@Test(priority = 2, description = "Testing the number of Post's displaying default")
	public void showMorePostBtnTest(Method method) throws InterruptedException {
		ArrayList<String> postIdList = new ArrayList<String>();

		Logger log = Logger.getLogger(method.getName());
		PropertyConfigurator.configure("Log4j.properties");
		log.info("User Clicked on Show_More_Posts-Button ");
		Thread.sleep(8000);

		waitForElementPresent(Obj.getIdentify("showmorepostsBtn"), Obj.getLocation("showmorepostsBtn"));
		WebElement showMorePostsBtn = getElement(Obj.getIdentify("showmorepostsBtn"), Obj.getLocation("showmorepostsBtn"));
		waitForElementPresent(Obj.getIdentify("showmorepostsBtn"), Obj.getLocation("showmorepostsBtn"));
		showMorePostsBtn.click();
		Thread.sleep(5000);

		waitForElementPresent(Obj.getIdentify("alphatalkContent"), Obj.getLocation("alphatalkContent"));
		WebElement alphatalkContentElements = getElement(Obj.getIdentify("alphatalkContent"), Obj.getLocation("alphatalkContent"));
		List<WebElement> AllPostIds = alphatalkContentElements.findElements(By.tagName("article"));

		for (WebElement postIds : AllPostIds) {
			String postId = postIds.getAttribute("id");
			if (!postId.equals("")) {
				postIdList.add(postId);
			}
		}
		log.info("Totel number of Post's::" + postIdList.size());
		Assert.assertEquals(postIdList.size(), 20);
		for (int i = 0; i < postIdList.size(); i++) {
			System.out.println(postIdList.get(i));
		}

	}

	@Test(priority = 0, description = "Testing Share Tab by Posting on post",enabled=false)
	public void shareTest(Method method) throws InterruptedException {

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
				log.info(" TEXTAREA-BOX Displaying");
			} catch (Exception e) {
				e.getMessage();
			}
		} else {
			log.warn("Unable to locate SHARE_TAB");
		}

		Actions a1 = new Actions(driver);
		a1.moveToElement(textareaElement).build().perform();

		try {
			textareaElement.sendKeys(TESTPOST);
			log.info("User Successfully posted.");
		} catch (Exception e) {
			log.warn(e.getMessage());
			log.warn("Unable to find or typed ticker in Estimate-Ticker-TxtBox");
		}
		waitForElementPresent(Obj.getIdentify("postbtn"), Obj.getLocation("postbtn"));
		WebElement postSubmitElement = getElement(Obj.getIdentify("postbtn"), Obj.getLocation("postbtn"));
		postSubmitElement.click();
		log.info("Cliked on POST-Button ");

	}

}
