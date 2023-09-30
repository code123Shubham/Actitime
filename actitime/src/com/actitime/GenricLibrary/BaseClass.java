package com.actitime.GenricLibrary;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.monitor.FileEntry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.actitime.pom.LoginPage;

public class BaseClass {
	FileLibrary f=new FileLibrary();
	public static WebDriver driver;
	
	@BeforeSuite
	public void databaseConnection() {
		Reporter.log("database connected",true);
	}
	
	@BeforeClass
	public void launchBrowser() throws IOException{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String Link = f.readDataFromPropertyFile("url");
		driver.get(Link);
		driver.get("https://demo.actitime.com");
		Reporter.log("browser launch succesfully",true);
		
	}
	@BeforeMethod
	public void loginactitime() throws IOException {
		LoginPage lp=new LoginPage(driver);
		String un = f.readDataFromPropertyFile("username");
		lp.getUntbx().sendKeys(un);
	    String pw = f.readDataFromPropertyFile("password");
	    lp.getPwtbx().sendKeys(pw);
	    lp.getLgbtn().click();
		Reporter.log("Logged in succesfully",true);
	}

	@AfterMethod
	public void logoutFromActitime() {
		driver.findElement(By.id("logoutLink")).click();
		Reporter.log("Loggedout  succesfully",true);
		
	}
	@AfterClass
	public void closeBroowser() {
		driver.close();
		Reporter.log("Browser close succesfully",true);
	}
	
	@AfterSuite
	public void closedatabaseconnection() {
		Reporter.log("database disconnected",true);
	}
}
