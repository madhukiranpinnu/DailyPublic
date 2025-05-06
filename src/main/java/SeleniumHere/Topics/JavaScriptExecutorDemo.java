package SeleniumHere.Topics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptExecutorDemo {
    @Test
    public void click() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
        WebElement element=driver.findElement(By.xpath("//button[.='Submit']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void ScrollToBottom() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void scrollToAxis() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500);");
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void ScrollToElement() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement element=driver.findElement(By.xpath("//button[.='Submit']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void SendKeys() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement element= driver.findElement(By.xpath("//*[@placeholder='First Name']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].value='madhu'",element);
        Thread.sleep(5000);
        driver.quit();
    }
}
