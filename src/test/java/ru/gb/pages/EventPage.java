package ru.gb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EventPage extends BasePage{

    public EventPage(WebDriver webDriver) {
        super(webDriver);
    }

    public EventPage addToCart(){
    webDriver.findElement(By.xpath(".//a[@class='form__button  js-added-to-cart']")).click();
    return this;
    }

    public EventPage checkBooking(){
        new WebDriverWait(webDriver,3).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//a[@class='form__button form__button_disabled']")));
        new WebDriverWait(webDriver,3).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//a[@id='jsbasket-reserv']")));
        return this;

    }




}
