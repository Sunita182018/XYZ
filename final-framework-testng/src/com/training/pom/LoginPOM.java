package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	@FindBy(className="parent")
	private WebElement CategoriesIcone;
	
	@FindBy(xpath="//a[contains(text(),'Categories')]")
	private WebElement Categories;
	
	@FindBy(className="btn-danger")
	private WebElement deleteIcone;
	
	@FindBy(className="fa-pencil")
	private WebElement EditIcone;
	
	@FindBy(linkText="Products")
	private WebElement Product;
	
	@FindBy(className="fa-plus")
	private WebElement AddProductIcone;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickCategories() {
		this.CategoriesIcone.click();
		this.Categories.click();
	}
	
	public void clickDelete() {
		this.deleteIcone.click();
	}
	
	public void clickEdit() {
		this.EditIcone.click();
	}
	
	public void clickProduct() {
		this.CategoriesIcone.click();
		this.Product.click();
	}
	
	public void AddProduct() {
		this.AddProductIcone.click();
	}
	
}
