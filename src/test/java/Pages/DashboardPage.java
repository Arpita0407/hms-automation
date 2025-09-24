package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;

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
    
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/main/div/div/div[2]/div[2]/div[2]/div[1]/div")
    WebElement btnexpand;
    
    @FindBy(xpath = "//table[contains(@class,'min-w-full')]//tbody/tr")
    List<WebElement> bedRows;
    
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/main/div/div/div[2]/div[2]/div[2]/div[2]/div[1]")
    WebElement btnexpand2;
    
    @FindBy(xpath = "//table[contains(@class,'min-w-full max-w-fit rounded-lg')]//tbody/tr") 
    List<WebElement> bedRows1;
    
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

    public String isAppointmentsSectionVisible() 
    {
        return appointmentsSection.getText();
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

    public String isUserProfileVisible() 
    {
        return userProfile.getText();
    }
    
    public void expandRooms()
    {
    	btnexpand.click();
    }
    
    
    public List<Map<String, String>> getBedData() 
    {
    	List<Map<String, String>> tableData = new ArrayList<>();
       
        System.out.println("Row count found: " + bedRows.size());

        for (WebElement row : bedRows) 
        {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() == 3) 
            { 
	            Map<String, String> rowData = new HashMap<>();
	            rowData.put("RoomType", cells.get(0).getText());
	            rowData.put("Total", cells.get(1).getText());
	            rowData.put("Available", cells.get(2).getText());
	            tableData.add(rowData);
            }
            else
            {
            	System.out.println("Skipping row (unexpected structure): " + row.getAttribute("outerHTML"));
            }
        }
  
        return tableData;
    }
    
    public void expandRooms2()
    {
    	btnexpand2.click();
    }
    
    public List<Map<String, String>> getBedData2() 
    {
    	List<Map<String, String>> tableData = new ArrayList<>();
       
        System.out.println("Row count found: " + bedRows1.size());

        for (WebElement row : bedRows1) 
        {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() == 3) 
            { 
	            Map<String, String> rowData = new HashMap<>();
	            rowData.put("Ward Type", cells.get(0).getText());
	            rowData.put("Total", cells.get(1).getText());
	            rowData.put("Available", cells.get(2).getText());
	            tableData.add(rowData);
            }
            else
            {
            	System.out.println("Skipping row (unexpected structure): " + row.getAttribute("outerHTML"));
            }
        }
  
        return tableData;
    }
}
