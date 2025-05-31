package RestAssured.Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Day5Oauth2Version {
    @Test
    public void GetCode() throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://accounts.google.com/v3/signin/identifier?opparams=%253Fauth_url%253Dhttps%25253A%25252F%25252Faccounts.google.com%25252Fo%25252Foauth2%25252Fv2%25252Fauth&dsh=S-1641519301%3A1748390111439429&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&o2v=2&redirect_uri=https%3A%2F%2Frahulshettyacademy.com%2FgetCourse.php&response_type=code&scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&service=lso&flowName=GeneralOAuthFlow&continue=https%3A%2F%2Faccounts.google.com%2Fsignin%2Foauth%2Fconsent%3Fauthuser%3Dunknown%26part%3DAJi8hAMcIbr7jhfC6uX9ZeLy7YtmZ_FrgDGnupvGfmfSd8TuUCj917UsLyVqV6mOsHPuApVwtHqzV2UxQiUvjLRo_h9t5v1x7CQcEiZmmtpL5PvxUYitrZFUxWH1bl85o8D-HKuxofBOmUfTWogFB-M3osHnGrslkJphI31uH6IV_zpgVDQmLyMdERetNHqpBvrVy_Cw38ZfmlnE5sEz9wabL7-OWYl29U4Zcqc-YX4_d3qsFIqEIzOsLT-yeHcosxCqzOqANvidAfpMssm5zBqwskFzku_eDG7l-wHoEqP3NrIsund0m1Q82oUCV1LHt_besSqvNYs13tXqQJF1r6g4bqS_zoUpCBZHSUgAjbsJw-0L2Zl0apbJUmmTl_tGQagytH5g57EeRS8Yiig5Sev4NFCBSfnrmbG3MWZd9Tv5CVJXNxiFr_gWq2O3IJW668DuQ46fq2hSPBhQ_wRpYZxvVao4X45X2Q%26flowName%3DGeneralOAuthFlow%26as%3DS-1641519301%253A1748390111439429%26client_id%3D692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com%23&app_domain=https%3A%2F%2Frahulshettyacademy.com&rart=ANgoxcdSlTkqg-k4Dx18ejx7dlx0sgXl9E1WhpZQHAt1Cw7-5VqBHLv15cWou2sH080qCbZ3FSBl9e_1GeaiXnUNt8H9OW8Cu8crnMOiMOEqGU5EY7yfQGw");
        driver.findElement(By.name("identifier")).sendKeys("madhukiran918@gmail.com");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[.='Next']")).click();
        Thread.sleep(5000);
        driver.findElement(By.name("Passwd")).sendKeys("Madhu@9939");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[.='Next']")).click();
        System.out.println(driver.getCurrentUrl());
    }
}
