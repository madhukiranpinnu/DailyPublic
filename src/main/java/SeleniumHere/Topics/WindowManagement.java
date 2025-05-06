package SeleniumHere.Topics;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowManagement {
    @Test
    public void windowManagement() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        Point point=new Point(0,0);
        driver.manage().window().setPosition(point);
        Thread.sleep(5000);
        driver.manage().window().maximize();
        driver.manage().window().minimize();
        driver.manage().window().fullscreen();
        driver.quit();
    }
}
