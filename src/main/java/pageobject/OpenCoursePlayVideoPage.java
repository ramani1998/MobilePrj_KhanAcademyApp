package pageobject;

import java.util.Set;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class OpenCoursePlayVideoPage{

	AndroidDriver<AndroidElement> driver;
	protected static String usernameExpected,usernameActual;
	
	public OpenCoursePlayVideoPage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;		
	}	
		
	public void openCourse(){		
		//to click Electrical engineering under my courses
        driver.findElement(By.xpath("//*[@text='Computer programming']")).click();        
    }
	
	public void clickJustonce() throws InterruptedException{
		Thread.sleep(3000);
		//to click just once
        driver.findElement(By.id("android:id/button_once")).click();
       
	}
	
	public void switchToWebApp() throws InterruptedException {
		 	Thread.sleep(10000);
	        
	        // my Native app is changed the context to webapp
	        Set<String> contextNames = driver.getContextHandles();
	        for (String contextName : contextNames) {
	            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
	        }
	        
	        driver.context("WEBVIEW_chrome");
	        Thread.sleep(8000);      
	}
	
	public void removeAddedCourse() throws InterruptedException{		
		//to click edit link under my courses
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Edit\")")).click();
		
		Thread.sleep(3000);
		//to select Electrical engineering under choose Science courses and click done
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Science\"))");
        driver.findElement(By.xpath("//*[@text='Electrical engineering']")).click();
        driver.findElement(By.xpath("//*[@text='Done']")).click();
        
        Thread.sleep(3000);
    }
	
	public void playVideo() throws InterruptedException {
		
		//To click Intro to JS: Drawing & Animation topic
		driver.findElement(By.linkText("Intro to JS: Drawing & Animation")).click();
		Thread.sleep(12000);
		//to play What is Programming? video 
		driver.findElement(By.xpath("//span[text()='What is Programming?']")).click();
		Thread.sleep(10000);
		
		//to click pause button
		//driver.findElement(By.xpath("//button[@title='Pause (k)']")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
	}
	public void switchbacktoNativeApp() throws InterruptedException{
		//To click back from settings page
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(4000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(4000);
        driver.context("NATIVE_APP");
        Thread.sleep(7000);
	}
}
