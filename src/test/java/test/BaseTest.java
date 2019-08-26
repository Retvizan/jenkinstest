package test;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    private WebDriver driver;
    private Capabilities options;

    @Before
    public void setup() throws MalformedURLException {
        String browser = System.getProperty("browser");
        switch (browser) {
            case ("chrome"):
               // WebDriverManager.chromedriver().setup();
                options = new ChromeOptions();
                break;
            case ("firefox"):
                //WebDriverManager.firefoxdriver().version("v0.24.0").setup();
                options = new FirefoxOptions();
                break;
            default:
                //WebDriverManager.iedriver().setup();
                options = new InternetExplorerOptions();
        }

        //System.setProperty("webdriver.chrome.driver", "c:/selenium/chromedriver.exe");

        driver = new RemoteWebDriver(new URL("http://192.168.1.8:4444/wd/hub"), options);
        WebDriverRunner.setWebDriver(driver);
        System.out.println("Opening google");
        open("http://google.com");
        System.out.println("google is opened");

    }

    @After
    public void teardown() {
        close();

    }
}


