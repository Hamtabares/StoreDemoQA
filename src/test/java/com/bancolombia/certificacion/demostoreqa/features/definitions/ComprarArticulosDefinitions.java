package com.bancolombia.certificacion.demostoreqa.features.definitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.bancolombia.certificacion.demostoreqa.steps.ComprarArticulosSteps;

import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class ComprarArticulosDefinitions {
	
	@Steps
	ComprarArticulosSteps comprarArticuloSteps;
	
	@Before
	public void iniciarPrueba() throws IOException {
		comprarArticuloSteps.abrirAPP();
		comprarArticuloSteps.inicializarProperties();
		comprarArticuloSteps.tomarDatosTxt();		
	}
	
	@Dado("^anadi el articulo \"([^\"]*)\" al carrito$")
	public void dadoAnadiElArticuloAlCarrito(String strArticulo) {
		comprarArticuloSteps.loguearse();
		comprarArticuloSteps.seleccionarArticulo(strArticulo);
	}
	@Dado("^aumente la cantidad a (\\d+)$")
	public void dadoAumenteLaCantidadA(int intCantidad) {
		comprarArticuloSteps.aumentarCantidadA(intCantidad);
	}

	@Cuando("^compro el producto$")
	public void cuandoComproElProducto(List<Map<String, String>> listInformacionComprar) {
		// llenar campos y dar clic en purchase
		comprarArticuloSteps.ingresarInformacionEnvio(listInformacionComprar);
	}

	@Entonces("^me aparece un resumen de transaccion$")
	public void entoncesMeApareceUnResumenDeTransaccion(List<Map<String, String>> listDatosResultados) {
		comprarArticuloSteps.verificarProductoComprado();
		comprarArticuloSteps.verificarPrecioProducto(listDatosResultados.get(0).get("Precio"));
		comprarArticuloSteps.verificarCantidad();
		comprarArticuloSteps.verificarPrecioTotalItem();
	}
}
