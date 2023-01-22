package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorPage {

    private final WebDriver driver;
    private final By constructor = By.xpath("//p[text()='Конструктор']");
    private final By logo = By.className("AppHeader_header__logo__2D0X2");
    private final By ingredients = By.className("BurgerIngredients_ingredients__list__2A-mT");
    private final By activeTab = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class='text text_type_main-default']");
    private final By sauceTab = By.xpath("//span[text()='Соусы']");

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnConstructor() {
        driver.findElement(constructor).click();
    }

    public void clickOnLogo() {
        driver.findElement(logo).click();
    }

    public void clickOnBun() {
        driver.findElements(ingredients).get(0).click();
    }

    public void clickOnSauce() {
        driver.findElement(sauceTab).click();
    }

    public void clickOnFilling() {
        driver.findElements(ingredients).get(2).click();
    }

    public String getText() {
        return driver.findElement(activeTab).getText();
    }
}
