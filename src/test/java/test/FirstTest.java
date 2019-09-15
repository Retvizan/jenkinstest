package test;

import com.codeborne.selenide.Credentials;
import org.junit.Assert;
import org.junit.Test;
import test.BaseTest;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class FirstTest extends BaseTest {
    @Test
    public void googleTest() throws InterruptedException {
        System.out.println("Opening google");
        open("http://google.com");
        System.out.println("google is opened");
        Thread.sleep(5000);
        open("https://tut.by");
        Assert.assertTrue("Not true", isTutVisible());
        System.out.println("tut.by is opened");
    }

    private boolean isTutVisible(){
        return $x("//a[@class='header-logo'][contains(@title,'TUT.BY')]").isDisplayed();
    }
}
