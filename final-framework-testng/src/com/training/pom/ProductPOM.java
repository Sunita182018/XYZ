package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPOM {
	private WebDriver driver; 
	
	public ProductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-name1")
	private WebElement ProductName; 
	
	public void sendProductName(String ProdName) {
		this.ProductName.clear();
		this.ProductName.sendKeys(ProdName);
	}
	
	@FindBy(id="input-meta-title1")
	private WebElement MetaTagTitle; 
	
	public void sendMetaTagTitle(String MetaTagTitle) {
		this.MetaTagTitle.clear();
		this.MetaTagTitle.sendKeys(MetaTagTitle);
	}
	
	@FindBy(linkText="Data")
	private WebElement dataTab;
	
	public void clickData() {
		this.dataTab.click();
	}
	
	@FindBy(id="input-model")
	private WebElement Model; 
	
	public void sendModel(String Model) {
		this.Model.clear();
		this.Model.sendKeys(Model);
	}
	
	@FindBy(id="input-price")
	private WebElement Price; 
	
	public void sendPrice(String Price) {
		this.Price.clear();
		this.Price.sendKeys(Price);
	}
	
	@FindBy(id="input-quantity")
	private WebElement Quantity; 
	
	public void sendQuantity(String Quantity) {
		this.Quantity.clear();
		this.Quantity.sendKeys(Quantity);
	}
	
	@FindBy(linkText="Links")
	private WebElement LinksTab;
	
	public void clickLinks() {
		this.LinksTab.click();
	}
	
	
	@FindBy(id="input-category")
	private WebElement LinksCategories;
	
	public void clickLinksCategories() {
		this.LinksCategories.click();
		this.LinksCategories.sendKeys("Blazers(3-8)");
	}
	
	@FindBy(className="fa-save")
	private WebElement saveIcone;
	
	public void clickSave() {
		this.saveIcone.click();
	}
	
	@FindBy(id="input-name")
	private WebElement FilterProductName; 
	
	public void sendFilterProdName(String Name) {
		this.FilterProductName.clear();
		this.FilterProductName.sendKeys(Name);
	}
	
	@FindBy(id="input-price")
	private WebElement FilterProductPrice; 
	
	public void sendFilterProdPrice(String price) {
		this.FilterProductPrice.clear();
		this.FilterProductPrice.sendKeys(price);
	}
	
	@FindBy(id="button-filter")
	private WebElement filterIcone;
	
	public void clickFilter() {
		this.filterIcone.click();
	}
	
	@FindBy(id="input-status")
	private WebElement filterStatus;
	
	public void clickStatus() {
		this.filterStatus.click();	
	}
	
	@FindBy(id="input-model")
	private WebElement filterModel; 
	
	public void sendfilterModel(String model) {
		this.filterModel.clear();
		this.filterModel.sendKeys(model);
	}
	
	@FindBy(id="input-quantity")
	private WebElement filterQuantity; 
	
	public void sendfilterQuantity(String quantity) {
		this.filterQuantity.clear();
		this.filterQuantity.sendKeys(quantity);
	}
	

	
}
