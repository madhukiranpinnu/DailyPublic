package SeleniumHere.Topics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitsDemo {
    @Test
    public void Implicit(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebElement element=driver.findElement(By.xpath("//*[normalize-space()='This text is displayed after 10 seconds of wait.']"));
        element.click();
    }
    @Test
    public void Explicit(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");
        WebDriverWait webDriverWait=new WebDriverWait(driver,Duration.ofSeconds(15));
        By element=By.xpath("//*[normalize-space()='This text is displayed after 10 seconds of wait.']");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(element));
        System.out.println(driver.findElement(element).getText());
        driver.quit();
    }
    public void Fluent(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");
    }
}
