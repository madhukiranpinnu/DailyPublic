package SeleniumHere.Topics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicTables {
    @Test
    public void Tables(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
        List<WebElement> rows=driver.findElements(By.xpath("//table[@id='contactList']/tbody/tr"));
        System.out.println(rows.size());
        driver.quit();
    }
    @Test
    public void TablesCells(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
        List<WebElement> rows=driver.findElements(By.xpath("//table[@id='contactList']/tbody/tr/td"));
        System.out.println(rows.size());
        driver.quit();
    }
    @Test
    public void TablesSpecificRowCells(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
        List<WebElement> rows=driver.findElements(By.xpath("//table[@id='contactList']/tbody/tr[2]/td"));
        System.out.println(rows.size());
        driver.quit();
    }
    @Test
    public void TablesSpecificRowSpecificcCells(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
        WebElement row=driver.findElement(By.xpath("//table[@id='contactList']/tbody/tr[2]/td[2]"));
        System.out.println(row.getText());
        driver.quit();
    }
    @Test
    public void ToCheckTextPresent(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
        WebElement row=driver.findElement(By.xpath("//table[@id='contactList']/tbody/tr/td[.='Roland Mendel']"));
        System.out.println(row.isDisplayed());
        driver.quit();
    }
    @Test
    public void TogetColoumnCount(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
        List<WebElement> coloumns=driver.findElements(By.xpath("//table[@id='contactList']/tbody/tr[1]/th"));
        System.out.println(coloumns.size());
        driver.quit();
    }
}
