package Practice.Appium_Framework;

import org.testng.annotations.Test;

import pageobject.MyCoursePage;

public class MyCoursesTest extends Capability {
	MyCoursePage mycoursepg;
	
	@Test
	public void selectAndVerifyCourse() throws InterruptedException{
		mycoursepg = new MyCoursePage(driver);
		mycoursepg.clickEdit();
		mycoursepg.chooseGrade();
		mycoursepg.chooseAndAssertCourse();
	}	

}
