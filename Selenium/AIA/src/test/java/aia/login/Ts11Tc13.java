package aia.login;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Selenium test prihlaseni.
 *
 * 1.1.1.3 - zkusit se přihlásit bez vyplneni hesla
 *
 * Testováno ověřeni, zda přihlášení neproběhlo a vyplyva hlaska s chybou u pole(heslo) a kontroluje jednou, kvuli stejneho textu
 */

public class Ts11Tc13 {

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
        return "password cannot be less than 6";
    }

    /**
     * String s jmenem
     * @return
     */
    public String getDataUser() {
        return "admin";
    }

    @Test
    public void testTs11Tc13() throws InterruptedException {
        System.setProperty(webdriver, chromedriver);
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(actualUrl);

        //kliknuti tlacitka - Prihlaseni
        driver.findElement(By.xpath("//li[6]/a[@class='regButton']")).click();
        //napsani jmena do pole
        driver.findElement(By.xpath("//form/div[@class='form']/input[@id='log']")).sendKeys(getDataUser());
        //kliknuti tlacitka - Prihlasit se
        driver.findElement(By.xpath("//form/div[@class='form']/button[@class='button']")).click();
        Thread.sleep(500);
        assertEquals(getTextByLanguage().toLowerCase(), driver.findElement(By.xpath("//form/div[@class='form']/p[@class='er'][2]")).getText().toLowerCase());

    }

}
