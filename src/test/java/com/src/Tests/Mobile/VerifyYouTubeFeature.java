package com.src.Tests.Mobile;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.src.Pages.Mobile.HomePage;

public class VerifyYouTubeFeature {
	
	DesiredCapabilities caps = new DesiredCapabilities();
	WebDriver driver = null;
	Properties prop;
	String deviceType;
	
	
	
	@BeforeSuite
	public void setUp() throws IOException {
		readProperty();
		deviceType = prop.getProperty("deviceType");
		
		if(deviceType.equalsIgnoreCase("Android")) {
			
			caps.setCapability("deviceName", "Samsung M20");
	        caps.setCapability("udid", "emulator-5554"); // DeviceId from "adb devices" command
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("platformVersion", "11.0");
	        caps.setCapability("appPackage", "com.youtube.app");
	        caps.setCapability("appActivity", "com.youtube.app.activities.homepage");
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			
		} else if(deviceType.equalsIgnoreCase("iOS")) {

			caps.setCapability("deviceName", "iPhone 10");
	        caps.setCapability("udid", "emulator-5339"); // DeviceId from "adb devices" command
	        caps.setCapability("platformName", "iOS");
	        caps.setCapability("platformVersion", "9.0");
	        caps.setCapability("appPackage", "com.youtube.app");
	        caps.setCapability("appActivity", "com.youtube.app.activities.homepage");
			driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			
		}
		
	}
	
	@Test
	public void verifyYouTubeHomepage() {
		
		// Login to YouTube
		HomePage homePage = new HomePage();
		
		homePage.verifyYouTubeHomepage();
		
	}
	
	@Test
	public void verifyYouTubeSearchFunctionality() {
		
		// Login to YouTube
		HomePage homePage = new HomePage();
		
		homePage.verifyYouTubeSearchFunctionality();
		
	}
	
	@Test
	public void verifyYouTubeTVandMusicOptionIsDsiplayed() {
		
		// Login to YouTube
		HomePage homePage = new HomePage();
		
		homePage.verifyYouTubeTVandMusicOptionIsDisplayed();
		
	}
	
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
	
	public void readProperty() throws IOException {
		FileReader reader=new FileReader("Config.properties");
		prop=new Properties();
		prop.load(reader);
	}

}

