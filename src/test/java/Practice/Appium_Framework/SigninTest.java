package Practice.Appium_Framework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.SignInPage;

public class SigninTest extends Capability {
	SignInPage signpg;
	
	@BeforeTest
	public void openSession() throws IOException{
		driver = DesiredCapability();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	
	@Test
	public void OpenApp() throws InterruptedException{
		signpg = new SignInPage(driver);
		Thread.sleep(8000);
		signpg.clickDismiss();
	}
	
	@Test(dependsOnMethods = { "OpenApp" })
    public void signIn() throws InterruptedException {
        Thread.sleep(3000);
        signpg.signIn();
        signpg.verifyusername();
        signpg.clickBack();
        
    }
	

}
