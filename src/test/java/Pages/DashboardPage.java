package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage 
{
	WebDriver driver;

    // Locators
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/main/div/div/div[1]/div[1]/div[2]/div[1]/div[2]/div/h3")
    WebElement appointmentsCount;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/main/div/div/div[1]/div[1]/div[2]/div[2]/div[2]/div/h3")
    WebElement encountersCount;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/main/div/div/div[1]/div[1]/div[2]/div[3]/div[2]/div")
    WebElement admissionsCount;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/main/div/div/div[1]/div[1]/div[2]/div[4]/div[2]/div/h3")
    WebElement newPatientsCount;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/main/div/div/div[1]/div[1]/div[2]/div[5]/div[2]/div/h3")
    WebElement totalStaffsCount;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/main/div/div/div[1]/div[1]/div[2]/div[6]/div[2]/div/h3")
    WebElement dischargeCount;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/main/div/div/div[2]/div[1]/div/h2")
    WebElement appointmentsSection;

    /*@FindBy(xpath = "//h3[text()='Bed Availability']")
    WebElement bedAvailabilitySection;

    @FindBy(xpath = "//div[contains(text(),'Room Availability')]")
    WebElement roomAvailability;

    @FindBy(xpath = "//div[contains(text(),'Ward Availability')]")
    WebElement wardAvailability;*/

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/header/nav/div/div/div/div/p[1]") 
    WebElement userProfile;

    // Constructor
    public DashboardPage(WebDriver driver) 
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public int getAppointmentsCount() 
    {
        //return appointmentsCount.getText();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(appointmentsCount));
    	return Integer.parseInt(appointmentsCount.getText().trim());
    }

   public int getEncountersCount() 
    {
        //return encountersCount.getText();
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.visibilityOf(encountersCount));
   	   return Integer.parseInt(encountersCount.getText().trim());
    }

    public int getAdmissionsCount() 
    {
        //return admissionsCount.getText();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(admissionsCount));
    	return Integer.parseInt(admissionsCount.getText().trim());
    }

    public int getNewPatientsCount() 
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(newPatientsCount));
    	return Integer.parseInt(newPatientsCount.getText().trim());
    }

    public int getTotalStaffsCount() 
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(totalStaffsCount));
    	return Integer.parseInt(totalStaffsCount.getText().trim());
    }

    public int getDischargeCount() 
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(dischargeCount));
    	return Integer.parseInt(dischargeCount.getText().trim());
    }

    public boolean isAppointmentsSectionVisible() 
    {
        return appointmentsSection.isDisplayed();
    }

    /*public boolean isBedAvailabilitySectionVisible() 
    {
        return bedAvailabilitySection.isDisplayed();
    }

    public String getRoomAvailability() 
    {
        return roomAvailability.getText();
    }

    public String getWardAvailability() 
    {
        return wardAvailability.getText();
    }*/

    public boolean isUserProfileVisible() 
    {
        return userProfile.isDisplayed();
    }
}
