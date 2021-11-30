package steps;

import driver.SeleniumWebDriver;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BestBuyPageObjects;
import utils.Excel;

import static org.junit.Assert.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


public class SearchSteps {
    BestBuyPageObjects locators = new BestBuyPageObjects();

    ArrayList<Map<String, String>> data;

    public void click(By element) {
        SeleniumWebDriver.driver.findElement(element).click();
    }

    public void type(By element, String text) {
        SeleniumWebDriver.driver.findElement(element).sendKeys(text);
    }

    public String getText(By element) {
        return SeleniumWebDriver.driver.findElement(element).getText();
    }

    public boolean isDisplayed(By element) {
        return SeleniumWebDriver.driver.findElement(element).isDisplayed();
    }

    @Step
    public void search() {
        click(locators.getUsaBtn());

        try {
            data = Excel.readExcel("TerminosBusqueda.xlsx", "Hoja1");
        } catch (IOException e) {
            System.out.println("Error al cargar datos desde excel");
            e.printStackTrace();
        }

        //Espera hasta que searchBar  esta visible
        waitUntilVisibility(locators.getSearchBarTxt());

        for (int i = 0; i < data.size(); i++) {
            type(locators.getSearchBarTxt(), data.get(i).get("Termino"));
            click(locators.getSearchBtn());

            click(locators.getFirstResultBtn());
            waitUntilVisibility(locators.getCloseSurveyBtn()); //Validamos si aparecio la encuesta
            validate(SeleniumWebDriver.driver.getTitle(), data.get(i).get("Titulo_Producto"));
        }
    }

    public void validate(String text, String text2) {
        WebDriverWait wait = new WebDriverWait(SeleniumWebDriver.driver, 3);
        wait.until(ExpectedConditions.titleContains(text));
        assertEquals(text, text2);
    }

    //Metodo generico para esperar hasta que un elemento este visible en el DOM y darle click
    public void waitUntilVisibility(By element) {
        try {
            WebDriverWait wait = new WebDriverWait(SeleniumWebDriver.driver, 3);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            if (isDisplayed(element)) {
                click(element);
            }
        } catch (Exception e) {
            //exception handling
        }
    }


}

