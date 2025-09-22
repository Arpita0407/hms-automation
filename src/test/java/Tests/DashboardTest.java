package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.DashboardPage;
import Pages.LoginPage;


public class DashboardTest 
{
	WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://devhms.scriptalldna.com/login");

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);

        // Login first
        loginPage.login("remote.tester10@gmail.com", "sadna@123");
        Thread.sleep(800);
    }

    @Test
    public void testDashboardElements() {
        Assert.assertTrue(dashboardPage.isAppointmentsSectionVisible(), "Appointments section is missing");
        Assert.assertTrue(dashboardPage.isBedAvailabilitySectionVisible(), "Bed Availability section is missing");
        Assert.assertTrue(dashboardPage.isUserProfileVisible(), "User profile not visible");

        System.out.println("Appointments Count: " + dashboardPage.getAppointmentsCount());
        System.out.println("Encounters Count: " + dashboardPage.getEncountersCount());
        System.out.println("Admissions Count: " + dashboardPage.getAdmissionsCount());
        System.out.println("New Patients Count: " + dashboardPage.getNewPatientsCount());
        System.out.println("Total Staffs: " + dashboardPage.getTotalStaffsCount());
        System.out.println("Discharge Count: " + dashboardPage.getDischargeCount());

        System.out.println("Room Availability: " + dashboardPage.getRoomAvailability());
        System.out.println("Ward Availability: " + dashboardPage.getWardAvailability());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
