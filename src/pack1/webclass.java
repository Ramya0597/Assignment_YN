package pack1;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class webclass {

			@Test
		    public void testLogin() throws Exception {
				WebDriver driver = new ChromeDriver();
		        Homepage loginPage = new Homepage(driver);
		        loginPage.launchBrowser();
		        loginPage.login("admin", "admin123");
		        loginPage.verify();
		       	loginPage.tearDown();	        
		    }

}
