package aia.tickets;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;

/**
 * Selenium test nabidky
 *
 * 3.6.1.2 - koupit letenku
 *
 * Testovano zkuseni kupovani letenky
 */

public class Ts36Tc12 {

    String actualUrl;

    String chromedriver;

    String webdriverurl;

    @Before
    public void setUp() {
        actualUrl = "https://wa.toad.cz/~utemiadi/aia.kz";
        chromedriver = "/Users/Adilbek Utemissov/Desktop/chromedriver.exe";
        webdriverurl = "webdriver.chrome.driver";
    }

    public String getTextByLanguage() {
        return "Purchase successful";
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
    public void testTs36Tc12() throws Exception {
        System.setProperty(webdriverurl, chromedriver);
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
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("//nav/ul[@class='main-menu']/li[5]"));
        action.moveToElement(we).perform();

        driver.findElement(By.xpath("//nav/ul[@class='main-menu']/li[5]/ul/li[1]/a")).click();
        Thread.sleep(1000);

        By by = By.xpath("//input[@id='toward']");
        driver.findElement(by).sendKeys("London");
        driver.findElement(By.xpath("//button[@class='button4']")).click();

        driver.findElement(By.xpath("//tbody/tr[2]/th")).click();
        driver.findElement(By.xpath("//button[@class='submit-btn']")).click();

        by = By.xpath("//div[@class='good']/h3");
        assertEquals(getTextByLanguage().toLowerCase(), driver.findElement(by).getText().toLowerCase());
    }
}
