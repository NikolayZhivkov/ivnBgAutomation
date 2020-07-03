import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected WebDriver driver;
    @BeforeAll
    public static void beforeAll(){
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    public void beforeEach(){

        driver = new ChromeDriver();
        driver.navigate().to("https://nzhivkov.inv.bg/login");
        driver.manage().window().maximize();



    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }

    protected void wait(int waitInSeconds){
        try {
            Thread.sleep(waitInSeconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
