package test;

import org.junit.Test;
import test.BaseTest;

import static com.codeborne.selenide.Selenide.open;

public class FirstTest extends BaseTest {
    @Test
    public void googleTest()  {
        open("https://tut.by");
    }
}
