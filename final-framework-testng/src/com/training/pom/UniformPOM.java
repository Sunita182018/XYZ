package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UniformPOM {
	private WebDriver driver; 
	
	public UniformPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(id="input-email")
	private WebElement email; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement loginBtn;
	
	@FindBy(className="fa-user")
	private WebElement userIcone;
	
	public void clickUserIcone() {
		this.userIcone.click(); 
	}
	
	@FindBy(linkText="Login")
	private WebElement login;
	
	public void clickLogin() {
		this.login.click(); 
	}
	
	public void sendEMailAddress(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	@FindBy(linkText="Uniform Store")
	private WebElement uniformStore;
	
	public void clickUniformStore() {
		this.uniformStore.click(); 
	}
	
	@FindBy(xpath="//a[contains(text(),'REGULAR T-SHIRTS (Rust)')]")
	private WebElement regularTShirt;
	
	public void clickTShirt() {
		this.regularTShirt.click(); 
	}
	
	
	@FindBy(id="input-option376")
	private WebElement chestSize;
	
	public void clickChestSize() {
		this.chestSize.click(); 
	}
	
	@FindBy(id="button-cart")
	private WebElement addCart;
	
	public void clickAddToCart() {
		this.addCart.click(); 
	}
		
	@FindBy(id="cart")
	private WebElement Cart;
		
	public void clickCart() {
		this.Cart.click();	
	}
	
	@FindBy(partialLinkText="View Cart")
	private WebElement viewCart;
		
	public void clickViewCart() {
		this.viewCart.click();	
	}
	
	@FindBy(linkText="Checkout")
	private WebElement checkOut;
		
	public void clickCheckOut() {
		this.checkOut.click();	
	}
	
	
	@FindBy(id="button-payment-address")
	private WebElement BillContinue;
		
	public void clickBillContinue() {
		this.BillContinue.click();	
	}
	
	@FindBy(id="button-shipping-address")
	private WebElement DeliveryContinue;
		
	public void clickDeliveryDetailsContinue() {
		this.DeliveryContinue.click();	
	}
	
	@FindBy(xpath="//textarea[@name='comment']")
	private WebElement comments;
	
	public void sendAddComments(String comments) {
		this.comments.sendKeys(comments);
	}
	
	@FindBy(id="button-shipping-method")
	private WebElement ShippingContinue;
		
	public void clickDeliveryMethodContinue() {
		this.ShippingContinue.click();	
	}
	
	@FindBy(name="agree")
	private WebElement checkBox;
		
	public void clickTermConditions() {
		this.checkBox.click();	
	}
	
	@FindBy(id="button-payment-method")
	private WebElement PaymentsContinue;
		
	public void clickPaymentContinue() {
		this.PaymentsContinue.click();	
	}
	
	@FindBy(id="button-confirm")
	private WebElement confirmOrder;
		
	public void clickConfirmOrder() {
		this.confirmOrder.click();	
	}
	
	@FindBy(xpath="//div[@class='container-fluid']//div[2]//div[1]//div[3]//a[1]")
	private WebElement saleIcon;
		
	public void clicksaleIcon() {
		this.saleIcon.click();	
	}
	
	@FindBy(className="fa-eye")
	private WebElement viewIcon;
		
	public void clickviewIcon() {
		this.viewIcon.click();	
	}
	
	@FindBy(id="input-order-status")
	private WebElement orderStatus;
		
	public void clickOrderStatus() {
		this.orderStatus.click();	
	}
	
	@FindBy(id="button-history")
	private WebElement addHistory;
		
	public void clickAddHistory() {
		this.addHistory.click();	
	}
}

