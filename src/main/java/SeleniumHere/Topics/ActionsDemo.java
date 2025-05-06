package SeleniumHere.Topics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsDemo {
    @Test
    public void MoveEleemnt() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");
        WebElement element=driver.findElement(By.id("blogsmenu"));
        Actions actions=new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void DoubleClick() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");
        WebElement element=driver.findElement(By.xpath("//button[contains(.,' Double click Here')]"));
        Actions actions=new Actions(driver);
        actions.doubleClick(element).perform();
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void RightClick() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");
        WebElement element=driver.findElement(By.xpath("//button[contains(.,' Double click Here')]"));
        Actions actions=new Actions(driver);
        actions.contextClick(element).perform();
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void DragAndDrop() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        WebElement iframe= driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(iframe);
        WebElement drag= driver.findElement(By.id("draggable"));
        WebElement drop=driver.findElement(By.id("droppable"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void DragAndDropalternative() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        WebElement iframe= driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(iframe);
        WebElement drag= driver.findElement(By.id("draggable"));
        WebElement drop=driver.findElement(By.id("droppable"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(drag).moveToElement(drop).release().build().perform();
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void KeyBoardActions() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");
        WebElement textField=driver.findElement(By.id("ta1"));
        Actions actions=new Actions(driver);
        actions.click(textField).sendKeys("Madhukiran").build().perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").build().perform();
        actions.keyDown(Keys.DELETE).perform();
        Thread.sleep(5000);
        driver.quit();
    }
}
