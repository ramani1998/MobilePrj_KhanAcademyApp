package pageobject;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class SignOutPage{

	AndroidDriver<AndroidElement> driver;
	
	public SignOutPage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;		
	}	
	
	public void clickSettings() {
		//To click settings icon
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Settings']")).click();
	}
	public void clickSignOut() throws InterruptedException{			
		Thread.sleep(3000);		
		//to click sign out button
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign out\")")).click();
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
    }
	
		
	
}
