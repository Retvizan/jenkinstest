import org.junit.Test;

public class FirstTest extends BaseTest {
    @Test
    public void googleTest() throws InterruptedException {
        driver.open("https://tut.by");
        Thread.sleep(10000);
    }
}
