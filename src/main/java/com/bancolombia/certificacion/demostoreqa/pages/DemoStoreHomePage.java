package com.bancolombia.certificacion.demostoreqa.pages;

import org.openqa.selenium.WebElement;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
@DefaultUrl("http://store.demoqa.com")

public class DemoStoreHomePage extends PageObject{
	@FindBy(xpath="//*[@title='My Account']")
	private WebElement lnkMyAccount;
		
	public void clicEnMyAccount() {
		lnkMyAccount.click();
	
	
	
	}
}
