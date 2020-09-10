package pageobject;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MyCoursePage{

	AndroidDriver<AndroidElement> driver;
	protected static String course_Expected,course_Actual;
	protected static int index;
	
	public MyCoursePage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;		
	}
	
		
	public void clickEdit(){		
		//to click edit link under my courses
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Edit\")")).click();
    }
	
	public void chooseGrade() {
		//to click back from choose courses
		driver.findElement(By.className("android.widget.ImageView")).click();
				
		//Scrolling the element to till Graduate studies
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Graduate studies\"))");
	
        //Tap on Graduate studies
        WebElement grade = driver.findElement(By.xpath("//*[@text='Graduate studies']"));
 	    TouchAction t=new TouchAction(driver);
 	    t.tap(tapOptions().withElement(element(grade))).perform();
	}
	
	public void chooseAndAssertCourse() throws InterruptedException {
		Thread.sleep(3000);
		course_Expected = "Electrical engineering";
		//to select Electrical engineering under choose Science courses and click done
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Science\"))");
        driver.findElement(By.xpath("//*[@text='"+course_Expected+"']")).click();
        driver.findElement(By.xpath("//*[@text='Done']")).click();
        
        Thread.sleep(3000);
        int count = driver.findElements(By.className("android.widget.TextView")).size();
        System.out.println("Count = " +count );
                
        for (int i=0;i<count;i++) {
        	String temp = driver.findElements(By.className("android.widget.TextView")).get(i).getText();

        	if (temp.equalsIgnoreCase(course_Expected)){
        		index = i+1;
        		System.out.println("index = "+index);
        		break;
        	}
        }
        course_Actual=driver.findElement(By.xpath("(//*[@class='android.widget.TextView'])["+index+"]")).getText();
		System.out.println("course_Actual = "+course_Actual);   
		
		//Assert to validate the same course is displayed under my courses
		Assert.assertEquals(course_Expected, course_Actual);
		
	}
	
}
