package ru.gb.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Войти с учетными данными в профиль")
    public MainPage login(String login, String password){

        webDriver.findElement(By.name("Login")).sendKeys(login);
        webDriver.findElement(By.name("Password")).sendKeys(password);
        webDriver.findElement(By.xpath(".//input[@value='ВОЙТИ']")).click();
        return new MainPage(webDriver);

    }

    @Step("Проверить текст ошибки входа")
    public LoginPage checkError(){
        new WebDriverWait(webDriver,3).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@class='validation-summary-errors text-danger']")));
        return this;
    }

}
