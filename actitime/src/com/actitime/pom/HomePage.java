package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage  {
	//decleration
	@FindBy(xpath = "//div[.='Tasks']")
	private WebElement tasks;

	
	@FindBy(xpath = "Reports")
	private WebElement reports;
	
	@FindBy(xpath = "Users")
	private WebElement users;
	
	@FindBy(id = "logoutLink")
	private WebElement logout;
	
	//intilization
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getTasks() {
		return tasks;
	}

	public WebElement getReports() {
		return reports;
	}

	public WebElement getUsers() {
		return users;
	}

	public WebElement getLogout() {
		return logout;
	}
	
	
}
