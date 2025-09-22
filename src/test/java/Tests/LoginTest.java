package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.LoginPage;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        // Setup ChromeDriver first
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://devhms.scriptalldna.com/login");
        Thread.sleep(500);
        // Initialize LoginPage object
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() throws InterruptedException 
    {
    	//System.out.println(driver.getPageSource());
        loginPage.login("remote.tester10@gmail.com", "sadna@123");
        Thread.sleep(800);
    }

  /*  @AfterMethod
    public void tearDown() 
    {
        if (driver != null) {
            driver.quit();
        }
    } */
}