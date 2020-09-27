package aia.regestraion;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Selenium test registrace.
 * <p>
 * 1.3.1.1 - zkusit potvrdit prazdny formular
 * <p>
 * Testováno ověřeni, zda registrace neprobehla uspesne kvuli prazdnym polim ve formulari(Jméno a příjmení, E-mail,
 * 6 číslic čísla karty, souhlasu s obchodnimi podminkami) pro cz verze a (Meno,priezvisko,E-mail,6 číslic čísla karty,
 * Súhlasím so spracovaním osobných udajov) pro sk verze
 */

public class Ts13Tc11 {

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
        return "Firstname is required";
    }

    /**
     * kontroluje jednou, kvuli stejneho textu
     */
    public String getFieldNoticeByLang2() {
        return "Lastname is required";
    }

    /**
     * kontroluje jednou, kvuli stejneho textu
     */
    public String getFieldNoticeByLang3() {
        return "Login is required";
    }

    /**
     * kontroluje jednou, kvuli stejneho textu
     */
    public String getFieldNoticeByLang4() {
        return "Email is required";
    }

    /**
     * kontroluje jednou, kvuli stejneho textu
     */
    public String getFieldNoticeByLang5() {
        return "Password is required";
    }

    /**
     * kontroluje jednou, kvuli stejneho textu
     */
    public String getFieldNoticeByLang6() {
        return "Confirm password is required";
    }

    /**
     * kontroluje jednou, kvuli stejneho textu
     */
    public String getFieldNoticeByLang7() {
        return "Invalid email format";
    }

    @Test
    public void testTs13Tc11() throws Exception {
        System.setProperty(webdriver, chromedriver);
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(actualUrl);

        //kliknuti tlacitka - Prihlaseni
        driver.findElement(By.xpath("//li[6]/a[@class='regButton']")).click();
        //kliknuti tlacitka - Registrace
        driver.findElement(By.xpath("//form/div[@class='form']/input[@class='button2']")).click();
        Thread.sleep(1000);

        //kliknuti tlacitka - Registrovat
        By by = By.xpath("//button[@id='register']");
        driver.findElement(by).click();

        // Overeni, ze vznikla hlaska s chybami u vsech poli
        by = By.xpath("//div[@class='error']/p[1]");
        assertEquals(getFieldNoticeByLang1().toLowerCase(), driver.findElement(by).getText().toLowerCase());
        by = By.xpath("//div[@class='error']/p[2]");
        assertEquals(getFieldNoticeByLang2().toLowerCase(), driver.findElement(by).getText().toLowerCase());
        by = By.xpath("//div[@class='error']/p[3]");
        assertEquals(getFieldNoticeByLang3().toLowerCase(), driver.findElement(by).getText().toLowerCase());
        by = By.xpath("//div[@class='error']/p[4]");
        assertEquals(getFieldNoticeByLang4().toLowerCase(), driver.findElement(by).getText().toLowerCase());
        by = By.xpath("//div[@class='error']/p[5]");
        assertEquals(getFieldNoticeByLang5().toLowerCase(), driver.findElement(by).getText().toLowerCase());
        by = By.xpath("//div[@class='error']/p[6]");
        assertEquals(getFieldNoticeByLang6().toLowerCase(), driver.findElement(by).getText().toLowerCase());
        by = By.xpath("//div[@class='error']/p[7]");
        assertEquals(getFieldNoticeByLang7().toLowerCase(), driver.findElement(by).getText().toLowerCase());

    }

}
