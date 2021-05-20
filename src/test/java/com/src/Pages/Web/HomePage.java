package com.src.Pages.Web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage {
	
	@FindBy(xpath="//*[text()='Home']")
	public WebElement HomepageLabel;
	
	@FindBy(xpath="//*[text()='Sign in']")
	public WebElement SignInButton;
	
	@FindBy(xpath="//input[@id='search']")
	public WebElement searchTextbox;
	
	@FindBy(xpath="//button[@id='search-icon-legacy']")
	public WebElement searchButton;
	
	@FindBy(xpath="//div[@id='button']")
	public WebElement gridButton;
	
	@FindBy(xpath="//*[text()='YouTube TV']")
	public WebElement youTubeTvOption;
	
	@FindBy(xpath="//*[text()='YouTube Music']")
	public WebElement youTubeMusicOption;
	
	public void verifyYouTubeHomepage() {
		
		if(HomepageLabel.isDisplayed()){
			Assert.assertEquals(HomepageLabel.getText(), "Home");
		} else {
			Assert.fail("Homepage is not displayed");
		}
		
	}
	
	public void verifyYouTubeSearchFunctionality() {
		
		searchTextbox.sendKeys("Selenium Tutorial");
		searchButton.click();
		verifyYouTubeHomepage();
		
	}
	
	public void verifyYouTubeTVandMusicOptionIsDisplayed() {
		
		gridButton.click();
		
		if (youTubeTvOption.isDisplayed() && youTubeMusicOption.isDisplayed()) {
			Assert.assertEquals(youTubeTvOption.getText(), "YouTube TV");
			Assert.assertEquals(youTubeMusicOption.getText(), "YouTube Music");
		} else {
			Assert.fail("Unable to display YouTube TV and Music options");
		}
	}

}
