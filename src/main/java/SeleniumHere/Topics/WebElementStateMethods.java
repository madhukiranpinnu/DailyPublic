package SeleniumHere.Topics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebElementStateMethods {
    @Test
    public void isEnabledDemo(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement element=driver.findElement(By.xpath("//button[.='Submit']"));
        System.out.println(element.isEnabled());
        driver.quit();
    }
    @Test
    public void isDisplayedDemo(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement element=driver.findElement(By.xpath("//*[.='Student Registration Form']"));
        System.out.println(element.isDisplayed());
        driver.quit();
    }
    @Test
    public void isSelectedDemo(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");
        WebElement element=driver.findElement(By.id("checkbox1"));
        element.click();
        System.out.println(element.isSelected());
        element.click();
        System.out.println(element.isSelected());
        driver.quit();
    }
}
