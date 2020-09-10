package Practice.Appium_Framework;

import org.testng.annotations.Test;

import pageobject.OpenCoursePlayVideoPage;

public class OpenCoursePlayVideoTest extends Capability {
	OpenCoursePlayVideoPage opencoursepg;
	
	
	@Test
	public void OpenAndPlayCourse() throws InterruptedException{
		opencoursepg = new OpenCoursePlayVideoPage(driver);
		opencoursepg.openCourse();
		opencoursepg.clickJustonce();
		opencoursepg.switchToWebApp();
		opencoursepg.playVideo();
		opencoursepg.switchbacktoNativeApp();
		opencoursepg.removeAddedCourse();
	}
	
	

}
