package com.bancolombia.certificacion.demostoreqa.pages;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.By;

public class CheckoutPage extends PageObject{
	@FindBy(xpath ="//*[@id='current_country']")
	private WebElement slcCountryShipping;
	@FindBy(xpath ="//*[@id='change_country']/input[2]")
	private WebElementFacade txtStateProvinceShipping;
	@FindBy(xpath ="//*[@id='wpsc_checkout_form_9']")
	private WebElementFacade txtBillingEmail; 
	@FindBy(xpath ="//*[@id='wpsc_checkout_form_2']")
	private WebElementFacade txtNombre;
	@FindBy(xpath ="//*[@id='wpsc_checkout_form_3']")
	private WebElementFacade txtApellidos; 
	@FindBy(xpath ="//*[@id='wpsc_checkout_form_4']")
	private WebElementFacade txtDireccion;
	@FindBy(xpath ="//*[@id='wpsc_checkout_form_5']")
	private WebElementFacade txtCiudad;
	@FindBy(xpath ="//*[@id='wpsc_checkout_form_6']")
	private WebElementFacade txtStateProvince;
	@FindBy(xpath ="//*[@id='wpsc_checkout_form_7']")
	private WebElement slcPais;
	@FindBy(xpath ="//*[@id='wpsc_checkout_form_18']")
	private WebElementFacade txtTelefono;
	@FindBy(xpath ="//*[@id='shippingSameBilling']")
	private WebElement chkShippingSame;
	@FindBy(xpath ="//*[@value='Purchase']")
	private WebElementFacade btnPurchase;
	
	
	
	public void seleccionarPaisDeCalcularEnvio(String strPais) {
		Select slcPaisCalcular = new Select(slcCountryShipping);
		slcPaisCalcular.selectByVisibleText(strPais);
	}
	
	public void escribirEstadoProvinciaCalcular(String strState) {
		txtStateProvinceShipping.clear();
		txtStateProvinceShipping.type(strState);
	}
	
	public void escribirEmail(String strEmail) {
		txtBillingEmail.clear();
		txtBillingEmail.type(strEmail);
	}
	
	public void escribirNombre(String strNombre) {
		txtNombre.clear();
		txtNombre.type(strNombre);
	}
	
	public void escribirApellidos(String strApellidos) {
		txtApellidos.clear();
		txtApellidos.type(strApellidos);
	}
	public void escribirDireccion(String strDireccion) {
		txtDireccion.clear();
		txtDireccion.type(strDireccion);
	}
	public void escribirCiudad(String strCiudad) {
		txtCiudad.clear();
		txtCiudad.type(strCiudad);
	}
	public void escribirEstadoProvincia(String strState) {
		txtStateProvince.clear();
		txtStateProvince.type(strState);
	}
	
	public void seleccionarPais(String strPais) {
		Select slcPais = new Select(this.slcPais);
		slcPais.selectByVisibleText(strPais);
	}
	
	public void escribirTelefono(String strTelefono) {
		txtTelefono.clear();
		txtTelefono.type(strTelefono);
	}
	
	public void clicEnSameShipping() {
//		try {
			chkShippingSame.click();
//		} catch (Exception e) {
//			Actions actions = new Actions(getDriver());
//			actions.moveToElement(chkShippingSame).click().perform();
//		}
	}
	public void clicEnPurchase() {
		btnPurchase.click();
	}
}
