package aia.regestraion;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Selenium test registrace.
 *
 * 1.3.1.6 - zkusit vyplnit vse, pole s cislem karty nechat prazdnou, potvrdit registrace
 *
 * Testováno ověřeni, zda registrace neprobehla uspesne a vyplyva hlaska s chybou u pole "cislo karty" a kontroluje jednou, kvuli stejneho textu
 */

public class Ts13Tc16 {

    String actualUrl;

    String chromedriver;

    String webdriver;

    @Before
    public void setUp() {
        actualUrl = "https://wa.toad.cz/~utemiadi/aia.kz";
        chromedriver = "/Users/Adilbek Utemissov/Desktop/chromedriver.exe";
        webdriver = "webdriver.chrome.driver";
    }

    /**
     * kontroluje jednou, kvuli stejneho textu
     */
    public String getFieldNoticeByLang1() {
        return "Password is required";
    }

    /**
     * kontroluje jednou, kvuli stejneho textu
     */
    public String getFieldNoticeByLang2() {
        return "The two passwords do not match";
    }

    @Test
    public void testTs13Tc16() throws Exception {
        System.setProperty(webdriver, chromedriver);
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(actualUrl);

        //kliknuti tlacitka - Prihlaseni
        driver.findElement(By.xpath("//li[6]/a[@class='regButton']")).click();
        //kliknuti tlacitka - Registrace
        driver.findElement(By.xpath("//form/div[@class='form']/input[@class='button2']")).click();
        Thread.sleep(1000);

        //napsani do poli dat
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("a");
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("b");
        driver.findElement(By.xpath("//input[@id='login']")).sendKeys("selenium");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("selenium@dateio.cz");
        driver.findElement(By.xpath("//input[@id='password2']")).sendKeys("111111");

        //kliknuti tlacitka - Registrovat
        By by = By.xpath("//button[@id='register']");
        driver.findElement(by).click();

        // Overeni, ze vznikla hlaska s chybami u vsech poli
        by = By.xpath("//div[@class='error']/p[1]");
        assertEquals(getFieldNoticeByLang1().toLowerCase(), driver.findElement(by).getText().toLowerCase());
        by = By.xpath("//div[@class='error']/p[2]");
        assertEquals(getFieldNoticeByLang2().toLowerCase(), driver.findElement(by).getText().toLowerCase());
    }

}
