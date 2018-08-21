package com.bancolombia.certificacion.demostoreqa.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ResultadoPage extends PageObject{
	@FindBy(xpath = "//tr/td[1]")
	private WebElementFacade lblProducto;
	
	@FindBy(xpath = "//tr/td[2]")
	private WebElementFacade lblPrecio;
	
	@FindBy(xpath = "//tr/td[3]")
	private WebElementFacade lblCantidad;
	
	@FindBy(xpath = "//tr/td[4]")
	private WebElementFacade lblItemTotal;
	
	public String getNombreArticulo() {
		return lblProducto.getText();
	}
	
	public String getPrecio() {
		return lblPrecio.getText();
	}
	
	public String getCantidad() {
		return lblCantidad.getText();
	}
	
	public String getItemTotal() {
		return lblItemTotal.getText();
	}
}
