package Practice.Appium_Framework;

import org.testng.annotations.Test;

import pageobject.SignOutPage;

public class SignoutTest extends Capability {
	SignOutPage signoutpg;
	
	@Test
	public void SignOutApp() throws InterruptedException{
		signoutpg = new SignOutPage(driver);
		Thread.sleep(8000);
		signoutpg.clickSettings();
		signoutpg.clickSignOut();
	}
	

}
