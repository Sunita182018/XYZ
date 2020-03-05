package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MediumUniformTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public  void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	@Test (priority=10)
	public void validLoginTest(){
		
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
	}

	@Test (priority=20)
	public void EditDeleteCategoryTest() throws Exception{

		loginPOM.clickCategories();
		
		WebElement chkbox = driver.findElement(By.xpath("//tbody//tr[1]//td[1]//input[1]"));
		chkbox.click();
		
		loginPOM.clickEdit();
		Thread.sleep(1000);
		
		assertEquals(driver.findElement(By.className("panel-title")).getText(),"Edit Category");
		screenShot.captureScreenShot("FouthTest-M1");
		
		driver.navigate().back();

		Thread.sleep(1000);
		loginPOM.clickDelete();
		Alert delAlert = driver.switchTo().alert();
		delAlert.accept();
		
		String text = driver.findElement(By.className("alert-success")).getText();
		assertEquals(text,"Success: You have modified categories!\n" + 
				"×");
		
		screenShot.captureScreenShot("FouthTest-M2");
	}

	
	
}
