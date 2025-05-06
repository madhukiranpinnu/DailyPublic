package SeleniumHere.Exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class StaleElementReferenceExceptionDemo {
    @Test
    public void AjaxCalls() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement element=driver.findElement(By.xpath("//*[.='Remove']"));
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        element.click();
        Thread.sleep(5000);
        checkbox.click();
    }
    @Test
    public void PageRefresh(){
      WebDriver driver=new ChromeDriver();
      driver.get("https://www.google.com/");
      WebElement element=driver.findElement(By.name("q"));
      element.click();
      driver.navigate().refresh();
//      element=driver.findElement(By.name("q"));
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(50));
        webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOfElementLocated(By.name("q"))));
        element.click();
    }
    @Test
    public void PageRedimension() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.w3schools.com/howto/howto_js_topnav_responsive.asp");
        WebElement element=driver.findElement(By.xpath("//a[.='Home']"));
        driver.manage().window().setSize(new Dimension(357,667));
        Thread.sleep(5000);
        element.click();
    }
}
