package com.src.Tests.Web;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.src.Pages.Web.HomePage;

public class VerifyYouTubeFeature {
	
	WebDriver driver = null;
	Properties prop;
	String browserName;
	String baseUrl;
	
	
	@BeforeSuite
	public void setUp() throws IOException {
		readProperty();
		browserName = prop.getProperty("browserName");
		baseUrl = prop.getProperty("baseUrl");
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if(browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver","GeckoDriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
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
