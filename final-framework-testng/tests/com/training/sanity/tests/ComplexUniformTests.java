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
import com.training.pom.UniformPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ComplexUniformTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ProductPOM productPOM;
	private UniformPOM uniformPOM;
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
		uniformPOM = new UniformPOM(driver);
		//baseUrl = properties.getProperty("baseURL");		
		screenShot = new ScreenShot(driver); 
		// open the browser 
		//driver.get(baseUrl);
		driver.get(properties.getProperty("uniformURL"));
		
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	@Test (priority=10)
	public void validLoginTest(){
		
		uniformPOM.clickUserIcone();
		uniformPOM.clickLogin();
		uniformPOM.sendEMailAddress("chk4green@gmail.com");
		uniformPOM.sendPassword("IBM_SPB14");
		uniformPOM.clickLoginBtn();

	}
	
	@Test (priority=20)
	public void shopUniformsTest_UNF_070() throws Exception{
			
		uniformPOM.clickUniformStore();
		Thread.sleep(1000);
		uniformPOM.clickTShirt();
		
		Thread.sleep(1000);
		uniformPOM.clickChestSize();
		
		WebElement chestSize = driver.findElement(By.id("input-option376"));
		Select Size = new Select(chestSize);
		Size.selectByValue("971");
		Thread.sleep(1000);
		uniformPOM.clickAddToCart();
		
		assertEquals(driver.findElement(By.className("alert-success")).getText(),"Success: You have added REGULAR T-SHIRTS (Rust) to your shopping cart!\n" + 
				"×");
		
		uniformPOM.clickCart();
		uniformPOM.clickViewCart();
		
		assertEquals(driver.findElement(By.partialLinkText("REGULAR T-SHIRTS (Rust)")).getText(),"REGULAR T-SHIRTS (Rust)");
		uniformPOM.clickCheckOut();
				
		uniformPOM.clickBillContinue();
		Thread.sleep(1000);
		
		uniformPOM.clickDeliveryDetailsContinue();
		Thread.sleep(1000);
		
		uniformPOM.sendAddComments("Quality product");
		uniformPOM.clickDeliveryMethodContinue();
		
		Thread.sleep(1000);
		uniformPOM.clickTermConditions();
		uniformPOM.clickPaymentContinue();
		
		uniformPOM.clickConfirmOrder();
		
		assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Your order has been placed!')]")).getText(),"YOUR ORDER HAS BEEN PLACED!");
		
		driver.get(properties.getProperty("baseURL"));
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		
		uniformPOM.clicksaleIcon();
		
		assertEquals(driver.findElement(By.linkText("Customer")).getText(),"Customer");
		assertEquals(driver.findElement(By.linkText("Status")).getText(),"Status");
		
		uniformPOM.clickviewIcon();
		
		assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Payment Address')]")).getText(),"Payment Address");
		assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Shipping Address')]")).getText(),"Shipping Address");
		
		uniformPOM.clickOrderStatus();
		
		WebElement orderStatus = driver.findElement(By.id("input-order-status"));
		Select Status = new Select(orderStatus);
		Status.selectByVisibleText("Complete");
		
		uniformPOM.clickAddHistory();
		
		screenShot.captureScreenShot("Seventh-C");
	}

	@Test (priority=30)
	public void productRewardsPointTest_UNF_071() {
		
		loginPOM.clickProduct();
		assertEquals(driver.getTitle(),"Products");
		
		loginPOM.AddProduct();
		assertEquals(driver.findElement(By.className("panel-title")).getText(),"Add Product");
	}
	
	

	
}
