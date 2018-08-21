package com.bancolombia.certificacion.demostoreqa.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class LoginPage extends PageObject{
	@FindBy(xpath = "//*[@id='log']")
	private WebElement txtUsuario;
		
	@FindBy(xpath = "//*[@id='pwd']")
	private WebElement txtPassword;
	
	@FindBy(xpath = "//*[@id='login']")
	private WebElement btnLogin;
	
	public void escribirUsuario(String strUsuario) {
		txtUsuario.sendKeys(strUsuario);
	}
	
	public void escribirPassword(String strPass) {
		txtPassword.sendKeys(strPass);
	}
	
	public void clicLogin() {
		btnLogin.click();
	}
}
