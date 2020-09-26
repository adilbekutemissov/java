package aia.regestraion;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

/**
 * Selenium test registrace.
 *
 * 1.3.2.1 - zkusit se zaregistrovat se spravnymi udaji, potvrdit registrace
 *
 * Testováno ověřeni, zda registrace probehla uspesne
 */

public class Ts13Tc21 {

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
    public String getFieldNoticeByLang() {
        return "Success";
    }

    @Test
    public void testTs13Tc21() throws InterruptedException {
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
        driver.findElement(By.xpath("//input[@id='login']")).sendKeys("test3");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test3@dateio.cz");
        driver.findElement(By.xpath("//input[@id='password1']")).sendKeys("111111");
        driver.findElement(By.xpath("//input[@id='password2']")).sendKeys("111111");

        //kliknuti tlacitka - Registrovat
        By by = By.xpath("//button[@id='register']");
        driver.findElement(by).click();

        // Overeni, ze vznikla hlaska s chybami u vsech poli
        by = By.xpath("//div[@class='success']");
        assertEquals(getFieldNoticeByLang().toLowerCase(), driver.findElement(by).getText().toLowerCase());

    }

}
