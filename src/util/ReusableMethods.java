package util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class ReusableMethods extends BaseTest {

	public static void highlightElement(WebElement element) {

		for (int i = 0; i < 2; i++) {

			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].setAttribute('style', arguments[1]);",

			element, "color: red; border: 2px solid red;");

			js.executeScript("arguments[0].setAttribute('style', arguments[1]);",

			element, "");
		}
	}

	public WebElement getElement(String identifyby, String locator) {
		WebElement element = null;

		if (identifyby.equalsIgnoreCase("id")) {
			try {
				if (isElementPresent(identifyby, locator)) {
					element = driver.findElement(By.id(locator));
				}
			} catch (Exception e) {
				System.out.println("unable to find -- " + locator + " --By this-- " + identifyby);
			}

		} else if (identifyby.equalsIgnoreCase("xpath")) {
			try {
				if (isElementPresent(identifyby, locator)) {
					element = driver.findElement(By.xpath(locator));
				}
			} catch (Exception e) {
				System.out.println("unable to find -- " + locator + " --By this-- " + identifyby);
			}

		} else if (identifyby.equalsIgnoreCase("name")) {
			try {
				if (isElementPresent(identifyby, locator)) {
					element = driver.findElement(By.name(locator));
				}
			} catch (Exception e) {
				System.out.println("unable to find -- " + locator + " --By this-- " + identifyby);
			}

		} else if (identifyby.equalsIgnoreCase("className")) {
			try {
				if (isElementPresent(identifyby, locator)) {
					element = driver.findElement(By.className(locator));
				}
			} catch (Exception e) {
				System.out.println("unable to find -- " + locator + " --By this-- " + identifyby);
			}

		} else if (identifyby.equalsIgnoreCase("linkText")) {
			try {
				if (isElementPresent(identifyby, locator)) {
					element = driver.findElement(By.linkText(locator));
				}
			} catch (Exception e) {
				System.out.println("unable to find -- " + locator + " --By this-- " + identifyby);
			}

		} else if (identifyby.equalsIgnoreCase("cssSelector")) {
			try {
				if (isElementPresent(identifyby, locator)) {
					element = driver.findElement(By.cssSelector(locator));
				}
			} catch (Exception e) {
				System.out.println("unable to find -- " + locator + " --By this-- " + identifyby);
			}

		} else if (identifyby.equalsIgnoreCase("partialLinkText")) {
			try {
				if (isElementPresent(identifyby, locator)) {
					element = driver.findElement(By.partialLinkText(locator));
				}
			} catch (Exception e) {
				System.out.println("unable to find -- " + locator + " --By this-- " + identifyby);
			}

		} else if (identifyby.equalsIgnoreCase("tagName")) {
			try {
				if (isElementPresent(identifyby, locator)) {
					element = driver.findElement(By.tagName(locator));
				}
			} catch (Exception e) {
				System.out.println("unable to find -- " + locator + " --By this-- " + identifyby);
			}

		}

		return element;
	}

	public void waitForElementPresent(String identifyby, String locator)

	{

		if (identifyby.equalsIgnoreCase("id")) {
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
				highlightElement(driver.findElement(By.id(locator)));

			} catch (Exception e) {

			}

		} else if (identifyby.equalsIgnoreCase("xpath")) {
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
				highlightElement(driver.findElement(By.xpath(locator)));

			} catch (Exception e) {

			}

		} else if (identifyby.equalsIgnoreCase("name")) {
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locator)));
				highlightElement(driver.findElement(By.name(locator)));

			} catch (Exception e) {

			}

		} else if (identifyby.equalsIgnoreCase("className")) {
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locator)));
				highlightElement(driver.findElement(By.className(locator)));

			} catch (Exception e) {

			}
		}

		else if (identifyby.equalsIgnoreCase("linkText")) {
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(locator)));
				highlightElement(driver.findElement(By.linkText(locator)));

			} catch (Exception e) {

			}

		} else if (identifyby.equalsIgnoreCase("cssSelector")) {
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
				highlightElement(driver.findElement(By.cssSelector(locator)));

			} catch (Exception e) {

			}

		} else if (identifyby.equalsIgnoreCase("partialLinkText")) {
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(locator)));
				highlightElement(driver.findElement(By.partialLinkText(locator)));

			} catch (Exception e) {

			}

		} else if (identifyby.equalsIgnoreCase("tagName")) {
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(locator)));
				highlightElement(driver.findElement(By.tagName(locator)));

			} catch (Exception e) {

			}
		}

	}

	public boolean isElementPresent(String identifyby, String locator)

	{
		boolean flag = false;
		if (identifyby.equalsIgnoreCase("id")) {
			try {
				driver.findElement(By.id(locator)).isDisplayed();
				highlightElement(driver.findElement(By.id(locator)));
				flag = true;
				return flag;
			} catch (Exception e) {
				return false;
			}

		} else if (identifyby.equalsIgnoreCase("xpath")) {
			try {
				driver.findElement(By.xpath(locator)).isDisplayed();
				highlightElement(driver.findElement(By.xpath(locator)));
				flag = true;
				return flag;
			} catch (Exception e) {
				return false;
			}

		} else if (identifyby.equalsIgnoreCase("name")) {
			try {
				driver.findElement(By.name(locator)).isDisplayed();
				highlightElement(driver.findElement(By.name(locator)));
				flag = true;
				return flag;
			} catch (Exception e) {
				return false;
			}

		} else if (identifyby.equalsIgnoreCase("className")) {
			try {
				driver.findElement(By.className(locator)).isDisplayed();
				highlightElement(driver.findElement(By.className(locator)));
				flag = true;
				return flag;
			} catch (Exception e) {
				return false;
			}

		}

		else if (identifyby.equalsIgnoreCase("linkText")) {
			try {
				driver.findElement(By.linkText(locator)).isDisplayed();
				highlightElement(driver.findElement(By.linkText(locator)));
				flag = true;
				return flag;
			} catch (Exception e) {
				return false;
			}

		} else if (identifyby.equalsIgnoreCase("cssSelector")) {
			try {
				driver.findElement(By.cssSelector(locator)).isDisplayed();
				highlightElement(driver.findElement(By.cssSelector(locator)));
				flag = true;
				return flag;
			} catch (Exception e) {
				return false;
			}

		} else if (identifyby.equalsIgnoreCase("partialLinkText")) {
			try {
				driver.findElement(By.partialLinkText(locator)).isDisplayed();
				highlightElement(driver.findElement(By.partialLinkText(locator)));
				flag = true;
				return flag;
			} catch (Exception e) {
				return false;
			}

		} else if (identifyby.equalsIgnoreCase("tagName")) {
			try {
				driver.findElement(By.tagName(locator)).isDisplayed();
				highlightElement(driver.findElement(By.tagName(locator)));
				flag = true;
				return flag;
			} catch (Exception e) {
				return false;
			}

		}
		return flag;

	}

	public void type(String identifyby, String locator, String data)

	{
		if (identifyby.equalsIgnoreCase("id")) {
			try {
				if (isElementPresent(identifyby, locator)) {
					driver.findElement(By.id(locator)).sendKeys(data);
				}
			} catch (Exception e) {
				System.out.println("unable to find -- " + locator + " --By this-- " + identifyby);
			}

		} else if (identifyby.equalsIgnoreCase("xpath")) {
			try {
				if (isElementPresent(identifyby, locator)) {
					driver.findElement(By.xpath(locator)).sendKeys(data);
				}
			} catch (Exception e) {
				System.out.println("unable to find -- " + locator + " --By this-- " + identifyby);
			}

		}

		else if (identifyby.equalsIgnoreCase("name")) {
			try {
				if (isElementPresent(identifyby, locator)) {
					driver.findElement(By.name(locator)).sendKeys(data);
				}
			} catch (Exception e) {
				System.out.println("unable to find -- " + locator + " --By this-- " + identifyby);
			}

		} else if (identifyby.equalsIgnoreCase("className")) {
			try {
				if (isElementPresent(identifyby, locator)) {
					driver.findElement(By.className(locator)).sendKeys(data);
				}
			} catch (Exception e) {
				System.out.println("unable to find -- " + locator + " --By this-- " + identifyby);
			}

		}

		else if (identifyby.equalsIgnoreCase("linkText")) {
			try {
				if (isElementPresent(identifyby, locator)) {
					driver.findElement(By.linkText(locator)).sendKeys(data);
				}
			} catch (Exception e) {
				System.out.println("unable to find -- " + locator + " --By this-- " + identifyby);
			}

		} else if (identifyby.equalsIgnoreCase("cssSelector")) {
			try {
				if (isElementPresent(identifyby, locator)) {
					driver.findElement(By.cssSelector(locator)).sendKeys(data);
				}
			} catch (Exception e) {
				System.out.println("unable to find -- " + locator + " --By this-- " + identifyby);
			}

		} else if (identifyby.equalsIgnoreCase("partialLinkText")) {
			try {
				if (isElementPresent(identifyby, locator)) {
					driver.findElement(By.partialLinkText(locator)).sendKeys(data);
				}
			} catch (Exception e) {
				System.out.println("unable to find -- " + locator + " --By this-- " + identifyby);
			}

		} else if (identifyby.equalsIgnoreCase("tagName")) {
			try {
				if (isElementPresent(identifyby, locator)) {
					driver.findElement(By.tagName(locator)).sendKeys(data);
				}
			} catch (Exception e) {
				System.out.println("unable to find -- " + locator + " --By this-- " + identifyby);
			}

		}

	}

	public void click(String identifyby, String locator)

	{
		if (identifyby.equalsIgnoreCase("id")) {
			try {
				if (isElementPresent(identifyby, locator)) {
					driver.findElement(By.id(locator)).click();
				}
			} catch (Exception e) {
				System.out.println("unable to find -- " + locator + " --By this-- " + identifyby);
			}

		} else if (identifyby.equalsIgnoreCase("xpath")) {
			try {
				if (isElementPresent(identifyby, locator)) {
					driver.findElement(By.xpath(locator)).click();
				}
			} catch (Exception e) {
				System.out.println("unable to find -- " + locator + " --By this-- " + identifyby);
			}

		}

		else if (identifyby.equalsIgnoreCase("name")) {
			try {
				if (isElementPresent(identifyby, locator)) {
					driver.findElement(By.name(locator)).click();
				}
			} catch (Exception e) {
				System.out.println("unable to find -- " + locator + " --By this-- " + identifyby);
			}

		} else if (identifyby.equalsIgnoreCase("className")) {
			try {
				if (isElementPresent(identifyby, locator)) {
					driver.findElement(By.className(locator)).click();
				}
			} catch (Exception e) {
				System.out.println("unable to find -- " + locator + " --By this-- " + identifyby);
			}

		} else if (identifyby.equalsIgnoreCase("linkText")) {
			try {
				if (isElementPresent(identifyby, locator)) {
					driver.findElement(By.linkText(locator)).click();
				}
			} catch (Exception e) {
				System.out.println("unable to find -- " + locator + " --By this-- " + identifyby);
			}

		} else if (identifyby.equalsIgnoreCase("cssSelector")) {
			try {
				if (isElementPresent(identifyby, locator)) {
					driver.findElement(By.cssSelector(locator)).click();
				}
			} catch (Exception e) {
				System.out.println("unable to find -- " + locator + " --By this-- " + identifyby);
			}

		} else if (identifyby.equalsIgnoreCase("partialLinkText")) {
			try {
				if (isElementPresent(identifyby, locator)) {
					driver.findElement(By.partialLinkText(locator)).click();
				}
			} catch (Exception e) {
				System.out.println("unable to find -- " + locator + " --By this-- " + identifyby);
			}

		} else if (identifyby.equalsIgnoreCase("tagName")) {
			try {
				if (isElementPresent(identifyby, locator)) {
					driver.findElement(By.tagName(locator)).click();
				}
			} catch (Exception e) {
				System.out.println("unable to find -- " + locator + " --By this-- " + identifyby);
			}

		}

	}

}
