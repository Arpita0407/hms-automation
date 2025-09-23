package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
        Thread.sleep(3000);

        // Login first
        loginPage.login("remote.tester10@gmail.com", "sadna@123");
        Thread.sleep(1500);
    }

    @Test
    public void testDashboardElements()
    {
    	SoftAssert softAssert = new SoftAssert();
    	    
    	//Count Appointments 
        int count = dashboardPage.getAppointmentsCount();
        softAssert.assertTrue(count >= 0, "Appointments count should be visible and >= 0");
        System.out.println("Appointment count: " + count);    
   
        //Count Encounters
        int count1 = dashboardPage.getEncountersCount();
        softAssert.assertTrue(count1 >= 0, "Encounters count should be visible and >= 0");
        System.out.println("Encounter count: " + count1);    
    
        //Count Admission
        int count2 = dashboardPage.getAdmissionsCount();
        softAssert.assertTrue(count2 >= 0, "Admission count should be visible and >= 0");
        System.out.println("Admission count: " + count2);    
        
        //Count New Patient
        int count3 = dashboardPage.getNewPatientsCount();
        softAssert.assertTrue(count3 >= 0, "New Patient count should be visible and >= 0");
        System.out.println("New Patient count: " + count3);   
        
        //Count Total Staff
        int count4 = dashboardPage.getTotalStaffsCount();
        softAssert.assertTrue(count4 >= 0, "Total Staff count should be visible and >= 0");
        System.out.println("Total Staff count: " + count4);   
        
        //Count Discharge Patient
        int count5 = dashboardPage.getDischargeCount();
        softAssert.assertTrue(count5 >= 0, "Discharge Patient count should be visible and >= 0");
        System.out.println("Discharge Patient count: " + count5); 
        
        boolean text = dashboardPage.isAppointmentsSectionVisible();
        System.out.println("Appointments Section Text: " + text);

        // Optional: validate text
        softAssert.assertEquals(text, "Appointments", "Appointments section text should match");
        
        boolean text1 = dashboardPage.isUserProfileVisible();
        System.out.println("User Profile Text: " + text1);

        // Optional: validate text
        softAssert.assertEquals(text1, "Mayank Shah", "User Profile text should match");
        
        
        softAssert.assertAll();
        
        
    }
    
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
