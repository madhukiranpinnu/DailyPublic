package SeleniumHere.Exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ElementClickInterceptedExceptionDemo {
    @Test
    public void modalpopups(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/modal-dialogs");
        driver.findElement(By.id("showLargeModal")).click();
        driver.findElement(By.xpath("//button[.='Close']")).click();
        driver.findElement(By.id("showSmallModal")).click();
        driver.quit();
    }
    @Test
    public void alertsUnhandledAlert(){
       WebDriver driver=new ChromeDriver();
       driver.get("https://demo.automationtesting.in/Alerts.html");
       driver.findElement(By.xpath("//*[@id='OKTab']/button")).click();
       driver.switchTo().alert().accept();
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(30));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.='Widgets']")));
       driver.findElement(By.xpath("//a[.='Widgets']")).click();
    }
}
