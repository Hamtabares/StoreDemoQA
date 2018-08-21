package com.bancolombia.certificacion.demostoreqa.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.bancolombia.certificacion.demostoreqa.pages.CarritoPage;
import com.bancolombia.certificacion.demostoreqa.pages.CheckoutPage;
import com.bancolombia.certificacion.demostoreqa.pages.DemoStoreHomePage;
import com.bancolombia.certificacion.demostoreqa.pages.IPhone4S16GBPage;
import com.bancolombia.certificacion.demostoreqa.pages.IPhoneCategoryPage;
import com.bancolombia.certificacion.demostoreqa.pages.LoginPage;
import com.bancolombia.certificacion.demostoreqa.pages.MenuPage;
import com.bancolombia.certificacion.demostoreqa.pages.ResultadoPage;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class ComprarArticulosSteps {
	Properties prop;
	String[] vecDatos;
	DemoStoreHomePage demoStoreHomePage;
	LoginPage loginPage;
	MenuPage menuPage;
	IPhoneCategoryPage iPhoneCategoryPage;
	IPhone4S16GBPage iPhone4S16GBPage;
	CarritoPage carritoPage;
	CheckoutPage checkoutPage; 
	ResultadoPage resultadoPage;
	
	public void inicializarProperties() throws IOException {
		prop = new Properties();
		InputStream inputStream = new FileInputStream("serenity.properties");
		prop.load(inputStream);
	}

	public void tomarDatosTxt() throws IOException {
		BufferedReader br;
		FileReader file = new FileReader(prop.getProperty("archivo.ruta"));

		// BufferedReader Es para poder leer las lineas del archivo
		br = new BufferedReader(file);
		String strLinea;
		if ((strLinea = br.readLine()) != null) {
			vecDatos = strLinea.split(";");
		}
	}

	public void abrirAPP() {
		demoStoreHomePage.open();
	}

	@Step
	public void loguearse() {
		demoStoreHomePage.clicEnMyAccount();
		loginPage.escribirUsuario(vecDatos[0]);
		loginPage.escribirPassword(vecDatos[1]);
		loginPage.clicLogin();
	}
	
	@Step
	public void seleccionarArticulo(String strArticulo) {
		Serenity.setSessionVariable("articulo").to(strArticulo);
		//Antes de hacer este proceso, verificar que no haya
		//items y si es asi, entonces ejecutar metodo limpieza
		menuPage.posicionarseEnProductCategory();
		menuPage.darClicEnIphone();
		iPhoneCategoryPage.seleccionarArticulo(strArticulo);		
		iPhone4S16GBPage.darClicAddToCart();
		iPhone4S16GBPage.darClicCheckout();
		verificarSiHayOtrosArticulos();
	}
	
	@Step 
	public void aumentarCantidadA(int intCantidad) {
		Serenity.setSessionVariable("cantidad").to(intCantidad);
		carritoPage.escribirCantidad(Integer.toString(intCantidad));
		carritoPage.darClicEnUpdate();
		carritoPage.darClicContinuar();
	}
	
	public void verificarSiHayOtrosArticulos() {
		int intCantidadProductos = carritoPage.capturarCantidadEnCarrito();
		if(intCantidadProductos>2) {
			carritoPage.limpiarCarrito(Serenity.sessionVariableCalled("articulo"));
		}
	}
	
	@Step
	public void ingresarInformacionEnvio(List<Map<String, String>> listInformacionEnvio) {
		checkoutPage.seleccionarPaisDeCalcularEnvio(listInformacionEnvio.get(0).get("Pais"));
		checkoutPage.escribirEstadoProvinciaCalcular(listInformacionEnvio.get(0).get("Estado"));
		checkoutPage.escribirEmail(listInformacionEnvio.get(0).get("Email"));
		checkoutPage.clicEnSameShipping();
		checkoutPage.escribirNombre(listInformacionEnvio.get(0).get("Nombre"));
		checkoutPage.escribirApellidos(listInformacionEnvio.get(0).get("Apellidos"));
		checkoutPage.escribirDireccion(listInformacionEnvio.get(0).get("Direccion"));
		checkoutPage.escribirCiudad(listInformacionEnvio.get(0).get("Ciudad"));
		checkoutPage.escribirEstadoProvincia(listInformacionEnvio.get(0).get("Estado"));
		checkoutPage.seleccionarPais(listInformacionEnvio.get(0).get("Pais"));
		checkoutPage.escribirTelefono(listInformacionEnvio.get(0).get("Telefono"));
		checkoutPage.clicEnPurchase();	
		
	}
	
	@Step
	public void verificarProductoComprado() {
		String strArticulo = Serenity.sessionVariableCalled("articulo");
		assertTrue("Los nombres de los articulos no coinciden",
				resultadoPage.getNombreArticulo().contains(strArticulo));
	}
	
	@Step
	public void verificarPrecioProducto(String strPrecioEsperado) {
		Serenity.setSessionVariable("precioEsperado").to(strPrecioEsperado);
		assertEquals(strPrecioEsperado.toString(), resultadoPage.getPrecio());
	}
	
	@Step
	public void verificarCantidad() {
		int intCantidadEsperada = Serenity.sessionVariableCalled("cantidad");
		assertEquals(String.valueOf(intCantidadEsperada), resultadoPage.getCantidad());
	}
	
	@Step 
	public void verificarPrecioTotalItem() {
		int intCantidadEsperada = Serenity.sessionVariableCalled("cantidad");
		String strPrecioEsperado = Serenity.sessionVariableCalled("precioEsperado");
		double dblPrecioEsperado = Double.parseDouble(obtenerNumerosCadena(strPrecioEsperado));
		dblPrecioEsperado = dblPrecioEsperado * intCantidadEsperada;
		String strPrecioEsperadoString = String.valueOf(dblPrecioEsperado);
//		System.out.println("Este es el de la pagina: "+resultadoPage.getItemTotal());
		assertTrue("El resultado del item no es correcto"
				, resultadoPage.getItemTotal()
				.contains(strPrecioEsperadoString));
	}
	
	public String obtenerNumerosCadena(String strCadena) {
		String strNumero = "";
		char caracter;
		for (int i = 0; i < strCadena.length(); i++) {
			if (buscarNumero(strCadena.charAt(i))) {
				strNumero = strNumero + strCadena.charAt(i);
			}
		}
		return strNumero;
	}
	public boolean buscarNumero(char c){		 
	    boolean flag = false;	   
	    if (Character.isDigit(c) || c == '.') {
	            flag = true;
	    }   
	 
	    return flag;
	}
}
