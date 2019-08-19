import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;

public class BaseTest {
    public SelenideDriver driver;

    @Before
    public void setup() {
        driver = WebDriverRunner.getSelenideDriver();
        driver.open("http://google.com");

    }

    @After
    public void teardown() {
        driver.close();
    }
}


