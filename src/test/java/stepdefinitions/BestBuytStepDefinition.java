package stepdefinitions;

import cucumber.api.java.en.*;
import driver.SeleniumWebDriver;
import net.thucydides.core.annotations.Steps;
import steps.SearchSteps;

import java.io.IOException;
import java.util.List;

public class BestBuytStepDefinition {



    @Steps
    SearchSteps steps = new SearchSteps();

    public BestBuytStepDefinition() throws IOException {
    }

    @Given("^Que me encuentro en la pagina de Bestbuy$")
    public void queMeEncuentroEnLaPaginaDeBestbuy() {
        SeleniumWebDriver.chrome("https://www.bestbuy.com/");
    }

    @When("^Ingreso el nombre de un producto en la caja de texto y doy clic en la lupa$")
    public void ingresoElNombreDeUnProductoEnLaCajaDeTextoYDoyClicEnLaLupa() throws IOException {
        steps.search();
    }

    @Then("^la pagina me muestra un listado de productos que coinciden con el que busque$")
    public void laPaginaMeMuestraUnListadoDeProductosQueCoincidenConElQueBusque() {
    }

}
