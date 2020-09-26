package aia.tickets;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.*;

/**
 * Selenium test vyhledavani
 *
 * 3.3.1.1 - Vyhledavani nabídky podle nazvu
 *
 * Testuje jestli hleda všechne nabidky s vyhledavanym nazvem
 */

public class Ts33Tc11 {

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
        return "912";
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
    public void testTs33Tc11() throws Exception {
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
        driver.findElement(by).sendKeys("Mallorka");
        driver.findElement(By.xpath("//button[@class='button4']")).click();
        by = By.xpath("//tbody/tr[2]/td[1]");
        assertEquals(getTextByLanguage().toLowerCase(), driver.findElement(by).getText().toLowerCase());
    }

}