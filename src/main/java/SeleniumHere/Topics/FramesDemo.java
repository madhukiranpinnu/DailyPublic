package SeleniumHere.Topics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FramesDemo {
    @Test
    public void Frames1(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");
        driver.switchTo().frame("iframe1");
        System.out.println(driver.findElement(By.xpath("//*[.='What is Selenium?']")).isDisplayed());
        driver.switchTo().defaultContent();
        driver.switchTo().frame("iframe2");
        System.out.println(driver.findElement(By.xpath("//*[.='Index Page']")).isDisplayed());
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.xpath("//*[.='Page One']")).isDisplayed());
        driver.quit();
    }
    @Test
    public void Frames2(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/nestedframes");
        driver.switchTo().frame(0);
        driver.switchTo().frame(1);
        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        driver.quit();
    }
}
