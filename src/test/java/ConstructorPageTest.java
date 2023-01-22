import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.ConstructorPage;

public class ConstructorPageTest extends BaseUITest {

    private ConstructorPage constructorPage;

    @Before
    public void setup() {
        driver.get("http://stellarburgers.nomoreparties.site/");
        constructorPage = new ConstructorPage(driver);
    }

    @Test
    public void checkingSauceSections() {
        constructorPage.clickOnSauce();
        Assert.assertEquals("Соусы", constructorPage.getText());
    }

    @Test
    public void checkingFillingSections() {
        constructorPage.clickOnFilling();
        Assert.assertEquals("Начинки", constructorPage.getText());
    }

    @Test
    public void checkingBunSections() {
        constructorPage.clickOnBun();
        Assert.assertEquals("Булки", constructorPage.getText());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
