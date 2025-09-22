package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class DashboardPage 
{
	WebDriver driver;

    // Locators
    @FindBy(xpath = "//div[contains(text(),'Appointments')]/following-sibling::div")
    WebElement appointmentsCount;

    @FindBy(xpath = "//div[contains(text(),'Encounters')]/following-sibling::div")
    WebElement encountersCount;

    @FindBy(xpath = "//div[contains(text(),'Admission')]/following-sibling::div")
    WebElement admissionsCount;

    @FindBy(xpath = "//div[contains(text(),'New Patients')]/following-sibling::div")
    WebElement newPatientsCount;

    @FindBy(xpath = "//div[contains(text(),'Total Staffs')]/following-sibling::div")
    WebElement totalStaffsCount;

    @FindBy(xpath = "//div[contains(text(),'Discharge')]/following-sibling::div")
    WebElement dischargeCount;

    @FindBy(xpath = "//h3[text()='Appointments']")
    WebElement appointmentsSection;

    @FindBy(xpath = "//h3[text()='Bed Availability']")
    WebElement bedAvailabilitySection;

    @FindBy(xpath = "//span[contains(text(),'Room')]")
    WebElement roomAvailability;

    @FindBy(xpath = "//span[contains(text(),'Ward')]")
    WebElement wardAvailability;

    @FindBy(xpath = "//span[contains(text(),'Mayank Shah')]") // user profile section (dynamic)
    WebElement userProfile;

    // Constructor
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public String getAppointmentsCount() {
        return appointmentsCount.getText();
    }

    public String getEncountersCount() {
        return encountersCount.getText();
    }

    public String getAdmissionsCount() {
        return admissionsCount.getText();
    }

    public String getNewPatientsCount() {
        return newPatientsCount.getText();
    }

    public String getTotalStaffsCount() {
        return totalStaffsCount.getText();
    }

    public String getDischargeCount() {
        return dischargeCount.getText();
    }

    public boolean isAppointmentsSectionVisible() {
        return appointmentsSection.isDisplayed();
    }

    public boolean isBedAvailabilitySectionVisible() {
        return bedAvailabilitySection.isDisplayed();
    }

    public String getRoomAvailability() {
        return roomAvailability.getText();
    }

    public String getWardAvailability() {
        return wardAvailability.getText();
    }

    public boolean isUserProfileVisible() {
        return userProfile.isDisplayed();
    }
}
