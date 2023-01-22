package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    private final By logInButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By emailField = By.xpath("//input[@name='name']");
    private final By passwordField = By.xpath("//input[@name='Пароль']");
    private final By loginButton = By.xpath("//button[text()='Войти']");
    private final By register = By.xpath("//a[text()='Зарегистрироваться']");
    private final By logInThroughRegistration = By.xpath("//a[text()='Войти']");
    private final By recoverPassword = By.xpath("//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnLogInButton(){
        driver.findElement(logInButton).click();
    }

    public void setEmailInField(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPasswordInField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickOnLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void clickOnRegister(){
        driver.findElement(register).click();
    }

    public void clickOnLogInThroughRegistration(){
        driver.findElement(logInThroughRegistration).click();
    }

    public void clickOnRecoverPassword(){
        driver.findElement(recoverPassword).click();
    }
}
