package com.actitime.TestScript;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.actitime.GenricLibrary.BaseClass;
import com.actitime.GenricLibrary.FileLibrary;
import com.actitime.GenricLibrary.ListnerImplementation;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskPage;
@Listeners(ListnerImplementation.class)
public class CreateCustomer extends BaseClass {
	@Test
	public void creatCustomer() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.getTasks().click();
		TaskPage tp=new TaskPage(driver);
		tp.getAddcustom().click();
		tp.getNewcust().click();
		FileLibrary f=new FileLibrary();
	String name = f.readdatafromExel("sheet1", 1, 1);
		tp.getCustname().sendKeys(name);
		String desp = f.readdatafromExel("sheet1", 1, 2);
		tp.getCustdesp().sendKeys(desp);
		tp.getCreatcut().click();
		
		String expectedresult = name;
		String actualresult = driver.findElement(By.xpath("(//div[.='ASDFG'])[2]")).getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(expectedresult, actualresult);
		s.assertAll();
	}

}
