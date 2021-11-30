package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

//Correr con Cucumber
@RunWith(Cucumber.class)

//Configurar Cucumber
@CucumberOptions(
        features = "src/test/resources/features/BestBuy.feature",
        glue ="stepdefinitions",
        snippets = SnippetType.CAMELCASE
)
public class BestBuyRunner {
}
