package SeleniumHere.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

public class RelativeLocatersDemo {
    @Test
    public void BelowDemo(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
        WebElement element= driver.findElement(RelativeLocator.with(By.id("rightClickBtn")).below(By.id("doubleClickBtn")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
        element.click();
        driver.quit();
    }
    @Test
    public void AboveDemo(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
        WebElement element=driver.findElement(RelativeLocator.with(By.id("doubleClickBtn")).above(By.id("rightClickBtn")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
        element.click();
        driver.quit();
    }
    @Test
    public void toLeftOFDemo(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        WebElement element=driver.findElement(RelativeLocator.with(By.id("impressiveRadio")).toRightOf(By.id("yesRadio")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);
        driver.quit();
    }
    @Test
    public void toRightOFDemo(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        WebElement element=driver.findElement(RelativeLocator.with(By.id("yesRadio")).toLeftOf(By.id("impressiveRadio")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);
        driver.quit();
    }
}
