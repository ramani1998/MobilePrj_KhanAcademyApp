package Practice.Appium_Framework;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Capability{
	protected static String appPackage;
	protected static String appActivity;
	protected static String deviceName;
	protected static String chromeDriverExecutable;
	protected static String platformName;
	protected static AndroidDriver<AndroidElement> driver;

public static AndroidDriver<AndroidElement> DesiredCapability() throws IOException {
		// TODO Auto-generated method stub
		//trying to get the apk file from src
		//File f = new File("src");
	
		FileReader fr = new FileReader(System.getProperty("user.dir")+"//src//main//java//global.properties");
		Properties prop = new Properties();
		prop.load(fr);
		
		appPackage = prop.getProperty("APPPACKAGE");
		appActivity = prop.getProperty("APPACTIVITY");
		deviceName = prop.getProperty("DEVICENAME");
		chromeDriverExecutable = prop.getProperty("CHROMEDRIVEREXECUTABLE");
		platformName = prop.getProperty("PLATFORMNAME");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
		//below 2 are for web context
		//cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		//chrome driver executable will not be available in mobile capability/android capability
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, chromeDriverExecutable);
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);//this ip also will work.. this is our local system url
				//("http://0.0.0.0:4723/wd/hub"),cap);
		return driver;
	}
	

}

