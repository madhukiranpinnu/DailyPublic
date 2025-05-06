package SeleniumHere.Topics;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TakeScreeshotDemo {
    WebDriver driver;
    ExtentReports extentReports;
    ExtentTest test;
    @BeforeTest
    public void start(){
        driver=new ChromeDriver();
        ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter("C:/Users/madhu/Workspace/AutomationPlace/Daily/src/main/java/reports/report.html");
         extentReports=new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
    }
    @Test
    public void Test(){
        test= extentReports.createTest("Test 11");
        driver.get("https://www.google.com/");
        test.log(Status.FAIL,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotBase64(driver)).build());

    }
    @AfterTest
    public void last(){
        driver.quit();
        extentReports.flush();
    }
    public String ScreenshotBase64(WebDriver driver){
       return ((TakesScreenshot)driver) .getScreenshotAs(OutputType.BASE64);
    }
}
