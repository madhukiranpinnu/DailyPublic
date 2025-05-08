package SeleniumHere.Exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NoSuchElementDemo {
    @Test
    public void TimingIssueDemo(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/dynamic-properties");
        driver.findElement(By.id("visibleAfter")).click();
        driver.quit();
    }
    @Test
    public void IncorrectLocater(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("alert1")).click();
        driver.quit();
    }
}
