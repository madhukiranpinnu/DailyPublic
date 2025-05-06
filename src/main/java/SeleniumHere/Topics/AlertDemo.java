package SeleniumHere.Topics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertDemo {
    @Test
    public void SimpleAlertDemo(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");
        driver.findElement(By.id("alert1")).click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
        driver.quit();
    }
    @Test
    public void ConfirmationAlertDemo(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");
        driver.findElement(By.id("confirm")).click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
        driver.quit();
    }
    @Test
    public void ConfirmationAlertDemoDismiss(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");
        driver.findElement(By.id("confirm")).click();
        Alert alert=driver.switchTo().alert();
        alert.dismiss();
        driver.quit();
    }
    @Test
    public void PromptAlertt(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");
        driver.findElement(By.id("prompt")).click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Madhukiran");
        System.out.println(alert.getText());
    }
}
