package com.bancolombia.certificacion.demostoreqa.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class IPhone4S16GBPage extends PageObject{
	@FindBy(xpath="//*[@name='Buy']")
	private WebElement btnAddToCart;
	@FindBy(xpath="//*[text()='Checkout']")
	private WebElement lnkCheckout;
	@FindBy(xpath="//*[text()='Item has been added to your cart!']")
	private WebElementFacade lblMensajeAnadido;
	
	public void darClicAddToCart() {
		btnAddToCart.click();
	}
	public void darClicCheckout() {
		esperarMensajeAnadido();
		lnkCheckout.click();
	}
	public void esperarMensajeAnadido() {
		lblMensajeAnadido.waitUntilVisible();
	}
}
