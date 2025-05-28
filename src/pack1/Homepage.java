package pack1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Homepage {
	
	WebDriver driver;
	    
	    @FindBy(id = "email")
	    WebElement usernameField;
	    
	    @FindBy(id = "pass")
	    WebElement passwordField;
	    
	    @FindBy(name = "login")
	    WebElement loginButton;

	    public Homepage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	    public void launchBrowser() throws Exception {

			driver.get("https://www.facebook.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}

	    public void login(String user, String pass) {
	        usernameField.sendKeys(user);
	        passwordField.sendKeys(pass);
	        loginButton.click();
	    }
	    
	    public void verify() {
	    	String actualTitle = driver.getTitle();
	    	String expectedTitle = "Log in to Facebook";		       
	    	Assert.assertEquals(actualTitle, expectedTitle, "Page title should match after login");
	    }
	    
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();  // Properly ends the session
	        }
	        
	    }

}
