package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.List;

public class SeleniumWebDriver {

    public static WebDriver driver;

    public static void chrome(String url){
        ChromeOptions options = new ChromeOptions();
        List<String> arguments =  Arrays.asList("--start-maximized","--ignore-certificate-errors","--disable-infobars");
        options.addArguments(arguments);

        driver = new ChromeDriver(options);
        driver.get(url);
    }
}
