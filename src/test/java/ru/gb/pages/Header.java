package ru.gb.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header extends BaseView{

    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Клик на кнопку вход")
    public LoginPage clickLoginButton(){

        webDriver.findElement(By.xpath(".//span[contains(text(),'Вход')]")).click();
        return new LoginPage(webDriver);

    }

    @Step("Клик на кнопку выход")
    public MainPage logout() {

        webDriver.findElement(By.cssSelector(".new-user-panel__avatar_mobile-no")).click();
        webDriver.findElement(By.linkText("Выход")).click();
        return new MainPage(webDriver);

    }

    @Step("Проверить вход в профиль")
    public MainPage checkLogin(){

        new WebDriverWait(webDriver,3).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//span[contains(@class, 'new-user-panel__name_with-shadow')]")));
        return new MainPage(webDriver);

    }

    @Step("Проверить выход из профиля")
    public MainPage checkLogout() {

        new WebDriverWait(webDriver, 3).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//span[contains(text(),'Вход')]")));
        return new MainPage(webDriver);
    }

    @Step("Кликнуть на РЕЦЕПТЫ в меню")
    public AllRecipesPage chooseMenu(){

        webDriver.findElement(By.xpath(".//span[@id='js-new-header__top-nav']")).click();
        By menuLocator = By.id("mCSB_1_container");
        WebElement menu = webDriver.findElement(menuLocator);
        menu.findElement(By.xpath(".//a[contains(text(),'РЕЦЕПТЫ')]")).click();
        return new AllRecipesPage(webDriver);

    }

    @Step("Ввести и отправить поисковый запрос")
    public SearchPage search(String searchRequest){
        webDriver.findElement(By.xpath(".//input[@id='js-search-input']")).sendKeys(searchRequest);
        webDriver.findElement(By.xpath(".//input[contains(@class,'new-header__search-submit')]")).click();
        return new SearchPage(webDriver);
    }



}
