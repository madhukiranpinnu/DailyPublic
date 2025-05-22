package SeleniumHere.Topics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class Calenders {
    @Test
    public void CalenderSelection() throws InterruptedException {
        Calendar calendar=Calendar.getInstance();
        int today=calendar.get(Calendar.DAY_OF_MONTH);
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(
                        By.id("first_date_picker")))
                .click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[.='"+today+"']")).click();
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void CalenderSecondSelection() throws InterruptedException {
        Calendar calendar=Calendar.getInstance();
        int today=30;
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
        By ele=By.id("second_date_picker");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                       ele ));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(ele));
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(ele)).click().build().perform();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@class!=' ui-datepicker-other-month ']/a[.='"+today+"']")).click();
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void Future() throws ParseException, InterruptedException {
        String datString="12/01/2026";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        Date date=simpleDateFormat.parse(datString);
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        int MonthUSER=calendar.get(Calendar.MONTH);
        int YEARUSER= calendar.get(Calendar.YEAR);
        int dayUer=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(MonthUSER+""+YEARUSER+""+dayUer);
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
        By ele=By.id("second_date_picker");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ele));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(ele));
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(ele)).click().build().perform();
        Thread.sleep(5000);
        String month=driver.findElement(By.className("ui-datepicker-month")).getText();
        String year=driver.findElement(By.className("ui-datepicker-year")).getText();
        System.out.println(month+""+year);
        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("MMMyyyy");
        Date UIdate=simpleDateFormat1.parse(month+year);
        Calendar calendar1=Calendar.getInstance();
        calendar1.setTime(UIdate);
        int UIMonth=calendar1.get(Calendar.MONTH);
        int UIYear=calendar1.get(Calendar.YEAR);
        System.out.println(UIMonth);
        WebElement next;
        while ( UIMonth<MonthUSER || UIYear<YEARUSER){
            next= driver.findElement(By.xpath("//span[.='Next']"));
            next.click();
            month=driver.findElement(By.className("ui-datepicker-month")).getText();
            year=driver.findElement(By.className("ui-datepicker-year")).getText();
            simpleDateFormat1=new SimpleDateFormat("MMMyyyy");
            UIdate=simpleDateFormat1.parse(month+year);
            calendar1=Calendar.getInstance();
            calendar1.setTime(UIdate);
            UIMonth=calendar1.get(Calendar.MONTH);
            UIYear=calendar1.get(Calendar.YEAR);
        }
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@class!=' ui-datepicker-other-month ']/a[.='"+dayUer+"']")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}
