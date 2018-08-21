package com.bancolombia.certificacion.demostoreqa.pages;

import net.serenitybdd.core.pages.PageObject;

public class IPhoneCategoryPage extends PageObject{
	
	
	public void seleccionarArticulo(String strArticulo) {
		findBy("//*[contains(text(),'"+strArticulo+"')]").click();
		
	}
}
