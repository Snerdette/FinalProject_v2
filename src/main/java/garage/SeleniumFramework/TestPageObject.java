package garage.SeleniumFramework;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPageObject {

	 protected WebDriver driver;
		@Before
		public void setUp() {
			
			System.setProperty("webdriver.chrome.driver", "C:/Tools/chromedriver.exe");
					
			// Create a new instance of the html unit driver
			driver = new ChromeDriver();
		}
		@After
		public void tearDown() throws Exception {
			driver.close();
			driver.quit();
		}
}
