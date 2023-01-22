package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {

    private final WebDriver driver;
    private final By personalAccount = By.xpath("//p[text()='Личный Кабинет']");
    private final By logOutButton = By.xpath("//button[text()='Выход']");
    private final By informAboutPersonalAccount = By.xpath("//p[text()='В этом разделе вы можете изменить свои персональные данные']");

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnPersonalAccount(){
        driver.findElement(personalAccount).click();
    }

    public void clickOnLogOutButton(){
        driver.findElement(logOutButton).click();
    }
}