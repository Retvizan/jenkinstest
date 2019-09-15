package test;

import com.codeborne.selenide.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.codehaus.plexus.logging.LoggerManager;
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
import java.sql.SQLOutput;
import java.util.logging.Logger;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    private WebDriver driver;
    private Capabilities options;


    @Before
    public void setup() throws MalformedURLException {
        Configuration.driverManagerEnabled = true;

        String browser = System.getProperty("browser");
        System.out.println("browser is: " + browser);
        switch (browser) {
            case ("chrome"):
                WebDriverManager.chromedriver().setup();
                options = new ChromeOptions();
                break;
            case ("firefox"):
                WebDriverManager.firefoxdriver().version("v0.24.0").setup();
                options = new FirefoxOptions();
                break;
            default:
                WebDriverManager.edgedriver().setup();
                options = new EdgeOptions();
        }

        driver = new RemoteWebDriver(new URL("http://192.168.1.8:4444/wd/hub"), options);
        WebDriverRunner.setWebDriver(driver);
    }

    @After
    public void teardown() {
        System.out.println("Closing browser");
        driver.quit();

    }
}


