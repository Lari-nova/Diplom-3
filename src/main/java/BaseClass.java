import org.openqa.selenium.WebDriver;

public abstract class BaseClass {

    protected final WebDriver driver;

    public BaseClass(WebDriver driver) {
        this.driver = driver;
    }
}
