import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class BaseUITest {

    public static WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\larin\\IdeaProjects\\Diplom\\Diplom-3\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://stellarburgers.nomoreparties.site/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}