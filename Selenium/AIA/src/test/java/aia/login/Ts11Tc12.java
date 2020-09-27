package aia.login;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

/**
 * Selenium test prihlaseni.
 *
 * 1.1.1.2 - zkusit se přihlásit bez vyplneni jmena
 *
 * Testováno ověřeni, zda přihlášení neproběhlo a vyplyva hlaska s chybou u pole(jmeno) a kontroluje jednou, kvuli stejneho textu
 */

public class Ts11Tc12 {

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
        return "login can't be blank";
    }

    public String getDataPass() {
        return "password";
    }

    @Test
    public void Ts11Tc12() throws InterruptedException {
        System.setProperty(webdriver, chromedriver);
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(actualUrl);

        //kliknuti tlacitka - Prihlaseni
        driver.findElement(By.xpath("//li[6]/a[@class='regButton']")).click();
        //napsani hesla do pole
        driver.findElement(By.xpath("//form/div[@class='form']/input[@id='password']")).sendKeys(getDataPass());
        //kliknuti tlacitka - Prihlasit se
        driver.findElement(By.xpath("//form/div[@class='form']/button[@class='button']")).click();
        Thread.sleep(500);
        assertEquals(getTextByLanguage().toLowerCase(), driver.findElement(By.xpath("//form/div[@class='form']/p[@class='er'][1]")).getText().toLowerCase());
    }
}

