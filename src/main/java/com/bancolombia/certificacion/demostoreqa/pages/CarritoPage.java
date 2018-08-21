package com.bancolombia.certificacion.demostoreqa.pages;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CarritoPage extends PageObject {
	
	@FindBy(xpath = "//*[text()='Continue']")
	private WebElementFacade lnkContinue;
	
	@FindBy(xpath = "//*[@name='quantity']")
	private WebElementFacade txtCantidad;
	
	@FindBy(xpath = "//*[@value='Update']")
	private WebElementFacade btnUpdate;
	
	public int capturarCantidadEnCarrito() {
		return findAll("//table[@class='checkout_cart']" + "/tbody/tr").size();
	}

	public void limpiarCarrito(String strArticuloAGuardar) {
		int intSizeLista = findAll("//table[@class='checkout_cart']" + "/tbody/tr").size();
		for (int i = 2; i <= intSizeLista; i++) {
			String valor = find(By.xpath("//table[@class='checkout_cart']/tbody/tr[" + i + "]/td[2]/a")).getText();
			if (!valor.contains(strArticuloAGuardar)) {
				find(By.xpath("//table[@class='checkout_cart']/tbody/tr[" + i + "]/td//input[@value='Remove']"))
						.click();
				i--;
				intSizeLista = findAll("//table[@class='checkout_cart']" + "/tbody/tr").size();
			}

		}
	}
	public void escribirCantidad(String strCantidad) {
		txtCantidad.clear();
		txtCantidad.type(strCantidad);
	}
	
	public void darClicContinuar() {
		lnkContinue.click();
	}
	public void darClicEnUpdate() {
		btnUpdate.click();
	}
}
