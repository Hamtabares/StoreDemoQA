package com.bancolombia.certificacion.demostoreqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class MenuPage extends PageObject{
	@FindBy(xpath="//*[text()='Product Category']")
	private WebElementFacade lnkProductCategory;
	
	@FindBy(xpath="//*[text()='iPhones']")
	private WebElement lnkiPhones;
		
	public void posicionarseEnProductCategory() {
		
		esperarQueCargueMenu();
		Actions action = new Actions(getDriver());
		action.moveToElement(lnkProductCategory).build().perform();
		
	}
	public void darClicEnIphone() {
		lnkiPhones.click();
	}
	
	
	public void esperarQueCargueMenu() {
		findBy("//*[contains(text(),'Howdy')]").waitUntilVisible();
	}
	
}
