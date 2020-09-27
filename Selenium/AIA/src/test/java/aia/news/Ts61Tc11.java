package aia.news;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.*;

public class Ts61Tc11 {

    String actualUrl;

    String chromedriver;

    String webdriver;

    @Before
    public void setUp() {
        actualUrl = "https://wa.toad.cz/~utemiadi/aia.kz";
        chromedriver = "/Users/Adilbek Utemissov/Desktop/chromedriver.exe";
        webdriver = "webdriver.chrome.driver";
    }

        public String getTextByLanguage() {
        return "Comment";
    }

        /**
         * String s spravnym jmenem
         * @return
         */
        public String getDataUser() {
        return "admin";
    }

        /**
         * String s spravnym heslem
         * @return
         */
        public String getDataPass() {
        return "password";
    }

        @Test
        public void testTs61Tc11() throws Exception {
            System.setProperty(webdriver, chromedriver);
            ChromeDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(actualUrl);

            //kliknuti tlacitka - Prihlaseni
            driver.findElement(By.xpath("//li[6]/a[@class='regButton']")).click();
            //napsani jmena do pole
            driver.findElement(By.xpath("//form/div[@class='form']/input[@id='log']")).sendKeys(getDataUser());
            driver.findElement(By.xpath("//form/div[@class='form']/input[@id='password']")).sendKeys(getDataPass());
            //kliknuti tlacitka - Prihlasit se
            driver.findElement(By.xpath("//form/div[@class='form']/button[@class='button']")).click();
            Thread.sleep(1000);

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0," + 1400 + ")", "");
            Thread.sleep(1000);

            //kliknuti novinu
            driver.findElement(By.xpath("//article/div[@class='new'][1]/a/div[@class='a-new']/h3")).click();
            Thread.sleep(1000);

            jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0," + 1000 + ")", "");

            assertEquals(getTextByLanguage().toLowerCase(), driver.findElement(By.xpath("//div[@class='form-group'][2]/label[@id='comment_label']")).getText().toLowerCase());

        }
}
