package SeleniumHere.Topics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDemo {
    @Test
    public void Test1(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");
        WebElement dropdown= driver.findElement(By.xpath("//*[@id='drop1']"));
        Select select=new Select(dropdown);
        List<WebElement> options=select.getOptions();
        for (WebElement element:options){
            System.out.println(element.getText());
        }
        select.selectByIndex(0);
        select.selectByValue("def");
        select.selectByVisibleText("doc 2");
        System.out.println(select.getFirstSelectedOption().getText());
        driver.quit();
    }
    @Test
    public void Test2() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");
        WebElement element=driver.findElement(By.id("multiselect1"));
        Select select=new Select(element);
        select.selectByIndex(0);
        select.selectByValue("swiftx");
        select.selectByVisibleText("Hyundai");
        System.out.println(select.getFirstSelectedOption().getText());
        List<WebElement> elements=select.getAllSelectedOptions();
        for (WebElement element1:elements){
            System.out.println(element1.getText());
        }
        select.deSelectByContainsVisibleText("Hyundai");
        select.deselectByIndex(0);
        select.deselectByValue("swiftx");
        select.selectByIndex(0);
        select.selectByValue("swiftx");
        select.selectByVisibleText("Hyundai");
        select.deselectAll();
        driver.quit();
    }
}
