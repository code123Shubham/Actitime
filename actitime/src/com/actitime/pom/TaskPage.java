package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
	
	@FindBy (xpath = "//div[.='Add New']")
	private WebElement addcustom;
	
	@FindBy (xpath = "//div[.='+ New Customer']")
	private WebElement newcust;
	
	@FindBy (xpath = "(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement custname;
	
	@FindBy (xpath = "//textarea[@placeholder='Enter Customer Description']")
	private WebElement custdesp;
	
	@FindBy (xpath = "//div[.='Create Customer']")
	private WebElement creatcut ;
	
	@FindBy (xpath = "//div[@class='greyButton cancelBtn']")
	private WebElement cancelcust ;
	
	//initilization
	
	public TaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	


	public WebElement getAddcustom() {
		return addcustom;
	}

	public WebElement getNewcust() {
		return newcust;
	}

	public WebElement getCustname() {
		return custname;
	}

	public WebElement getCustdesp() {
		return custdesp;
	}

	public WebElement getCreatcut() {
		return creatcut;
	}

	public WebElement getCancelcust() {
		return cancelcust;
	}
	
}
