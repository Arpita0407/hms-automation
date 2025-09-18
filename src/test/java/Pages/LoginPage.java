package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) 
    {
        this.driver = driver;
    }

    // Locators
    By emailOrPhoneField = By.name("email");   // ✅ works with your HTML
    By passwordField = By.name("password");    // (inspect & confirm the actual attribute)
    By loginButton = By.xpath("//button[text()='Login']"); // adjust text if different
    //By loginButton       = By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/form/button");
    By forgotPasswordLink= By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/form/div/div/div[2]/div[2]/span");

    // Actions
    public void enterEmailOrPhone(String emailOrPhone) 
    {
        driver.findElement(emailOrPhoneField).sendKeys(emailOrPhone);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void clickForgotPassword() {
        driver.findElement(forgotPasswordLink).click();
    }

    public void login(String emailOrPhone, String password) throws InterruptedException {
        enterEmailOrPhone(emailOrPhone);
        enterPassword(password);
        Thread.sleep(500);
        clickLogin();
    }
}