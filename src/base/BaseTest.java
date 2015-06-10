package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import util.ConfiguratorSupport;

public class BaseTest {

	public static WebDriverWait wait = null;
	public static WebDriver driver;
	public static ConfiguratorSupport config = new ConfiguratorSupport();
	public static Properties prop = null;
	public static InputStream input = null;

	@Parameters("browser")
	@BeforeTest
	public void initialize(String browser) throws Exception {

		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			

		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
		

		} else if (browser.equalsIgnoreCase("ie")) {

			System.setProperty("webdriver.ie.driver", "lib/IEDriverServer.exe");
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			caps.setCapability("ignoreZoomSetting", true);
			
			System.setProperty("webdriver.ie.driver", "lib/IEDriverServer.exe");
			driver = new InternetExplorerDriver(caps);
			

		} else {
			throw new Exception("Browser Not Valid..(Info:Please check Suite_file )");
		}

		try {
			String filename = "config.properties";
			prop = new Properties();
			input = new FileInputStream(filename);

			// load a properties file
			prop.load(input);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				return;
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@AfterTest
	public void stopDriver() {
//		driver.close();
	}

}
