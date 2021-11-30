package pages;

import org.openqa.selenium.By;

public class BestBuyPageObjects {

    private By usaBtn = By.xpath("(//a[@class='us-link'])[3]");
    private By searchBarTxt = By.xpath("//input[@id='gh-search-input']");
    private By searchBtn = By.xpath("//button[@class='header-search-button']");
    private By clearSearchBarBtn = By.xpath("//button[@id='header-clear-search-icon']");
    private By firstResultBtn = By.xpath("(//h4[@class='sku-header'])[1]/a");
    private By closeSurveyBtn = By.xpath("//button[@id='survey_invite_no']");

    private By closeModalBtn = By.xpath("//button[@class='c-close-icon c-modal-close-icon']");


    public By getUsaBtn() {
        return usaBtn;
    }

    public By getSearchBarTxt() {
        return searchBarTxt;
    }

    public By getSearchBtn() {
        return searchBtn;
    }

    public By getFirstResultBtn() {
        return firstResultBtn;
    }

    public By getClearSearchBarBtn() {
        return clearSearchBarBtn;
    }

    public By getCloseSurveyBtn() {
        return closeSurveyBtn;
    }

    public By getCloseModalBtn() {
        return closeModalBtn;
    }
}
