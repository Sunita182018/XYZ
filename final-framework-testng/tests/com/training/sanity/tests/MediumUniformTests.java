package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.pom.ProductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MediumUniformTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ProductPOM productPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public  void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		productPOM = new ProductPOM(driver);
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
	
	@Test (priority=30)
	public void FilterProductTest() {
		
		loginPOM.clickProduct();
		
		//ProductName filter
		productPOM.sendFilterProdName("Blazer Girls(7-8)");
		productPOM.clickFilter();
		assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Blazer Girls(7-8)')]")).getText(),"Blazer Girls(7-8)");
		
		driver.navigate().back();
		
		//Price filter
		productPOM.sendFilterProdPrice("3000");
		productPOM.clickFilter();
		assertEquals(driver.findElement(By.xpath("//tbody//tr[1]//td[5]")).getText(),"3000.0000");
		
		driver.navigate().back();
		productPOM.sendFilterProdPrice("");
		
		//Status filter- Enabled
		productPOM.clickStatus();
		WebElement statusFilter = driver.findElement(By.id("input-status"));
		Select statusEnabled = new Select(statusFilter);

		statusEnabled.selectByVisibleText("Enabled");
		productPOM.clickFilter();
		assertEquals(driver.findElement(By.xpath("//tbody//tr[1]//td[7]")).getText(),"Enabled");
		
		//Reset status to default value
		WebElement statusReset = driver.findElement(By.id("input-status"));
		Select status = new Select(statusReset);
		status.selectByValue("*");

		//Model filter
		productPOM.sendfilterModel("BLG-112");
		productPOM.clickFilter();
		assertEquals(driver.findElement(By.xpath("//td[contains(text(),'BLG-112')]")).getText(),"BLG-112");
		
		driver.navigate().back();
		
		//Quantity filter
		productPOM.sendfilterQuantity("100");
		productPOM.clickFilter();
		assertEquals(driver.findElement(By.xpath("//tbody//tr[1]//td[6]")).getText(),"100");
		
		productPOM.sendfilterQuantity("");
		
		//Image check on status Enabled filter
		WebElement statusFilter2 = driver.findElement(By.id("input-status"));
		Select statusEnabled2 = new Select(statusFilter2);

		statusEnabled2.selectByVisibleText("Enabled");
		productPOM.clickFilter();
		
		driver.findElement(By.className("img-thumbnail")).isDisplayed();
		
		screenShot.captureScreenShot("FifthTest-M");
		
	}
	

	@Test (priority=40)
	public void AddProductTest() {
		
		loginPOM.clickProduct();
		assertEquals(driver.getTitle(),"Products");
		
		loginPOM.AddProduct();
		assertEquals(driver.findElement(By.className("panel-title")).getText(),"Add Product");
	
		productPOM.sendProductName("Shirt");
		productPOM.sendMetaTagTitle("Shirt for girls");
		
		productPOM.clickData();
		
		productPOM.sendModel("SHG-010");
		productPOM.sendPrice("750");
		productPOM.sendQuantity("50");
		
		productPOM.clickLinks();
		
		productPOM.clickLinksCategories();
		
		productPOM.clickSave();
		
		String SaveMsg = driver.findElement(By.className("alert-success")).getText();
		assertEquals(SaveMsg,"Success: You have modified products!\n" + 
				"×");
	
		screenShot.captureScreenShot("SixthTest-M");
	
	}
	

	
}
