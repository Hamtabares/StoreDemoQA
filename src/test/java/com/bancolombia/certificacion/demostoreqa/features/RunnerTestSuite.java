package com.bancolombia.certificacion.demostoreqa.features;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class) 
//Esta es con la clase que ejecuta
@CucumberOptions(features = "src/test/resources/features") //tags="@Cantidad2,@Pepito") //Se especifica la ruta donde estan las 
// historias que queremos ejecutar
public class RunnerTestSuite {	
	// VA A EJECUTAR TODAS NUESTRAS HISTORIAS
}
