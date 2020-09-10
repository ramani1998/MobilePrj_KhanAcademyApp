package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SignInPage{

	AndroidDriver<AndroidElement> driver;
	protected static String usernameExpected,usernameActual;
	
	public SignInPage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;		
	}
	
		
	public void clickDismiss(){		
		//to click dismiss button
		driver.findElement(By.className("android.widget.Button")).click();
		//To click covid dismiss link
		driver.findElement(By.xpath("//android.widget.Button[@content-desc='Dismiss']/android.widget.TextView")).click();
    }
	
	public void signIn(){
		//to click sign in
        driver.findElement(By.xpath("//*[@text='Sign in']")).click();
        //To click Continue with Google
        driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Continue with Google\")")).click();
        
        //to retrieve username and click mail id
        WebElement mailID = driver.findElement(By.id("com.google.android.gms:id/account_name"));
        //driver.findElement(By.id("com.google.android.gms:id/account_display_name"));
        String username =mailID.getText();
        usernameExpected = username.substring(0, username.lastIndexOf("@"));
        System.out.println(usernameExpected);
        mailID.click();
	}
	
	public void verifyusername() throws InterruptedException {
		//To click settings icon
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Settings']")).click();
		Thread.sleep(3000);
		//To read username under settings
		usernameActual = driver.findElement(By.xpath("(//*[@class='android.widget.TextView'])[2]")).getText();
		System.out.println("usernameActual = "+usernameActual);
		
		//Assert login name and username
		Assert.assertEquals(usernameExpected, usernameActual);
					
	}
	
	public void clickBack(){
		//To click back from settings page
		driver.findElement(By.className("android.widget.ImageView")).click();
	}
}
