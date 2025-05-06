package SeleniumHere.Topics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.*;

public class WindowsHandleDemo {
    @Test
    public void WindowHandle(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        String parent=driver.getWindowHandle();
        driver.findElement(By.id("tabButton")).click();
        Set<String> windows=driver.getWindowHandles();
        for (String window:windows){
            if(!window.equals(parent)){
                driver.switchTo().window(window);
                System.out.println(driver.getCurrentUrl());
            }
        }
        driver.switchTo().window(parent);
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }
    @Test
    public void Multiple(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        String parent=driver.getWindowHandle();
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",driver.findElement(By.id("windowButton")));
        driver.findElement(By.id("tabButton")).click();
        List<String> windows=new LinkedList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(2));
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }
}
