package aia.login;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

/**
 * Selenium test prihlaseni.
 *
 * 1.1.4.1 - zkusit se přihlásit s nespravnym jmenem a s nespravnym heslem
 *
 * Testováno ověřeni, zda přihlášení neproběhlo a vyplyva hlaska s chybou o "Spatne zadane jmena nebo hesla" u cz verze a "nesprávne zadané meno alebo heslo" u sk verze
 */

public class Ts11Tc41 {

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
        return "Incorrect login or password";
    }

    /**
     * String s nespravnym jmenem
     * @return
     */
    public String getDataUser() {
        return "test";
    }

    /**
     * String s nespravnym heslem
     * @return
     */
    public String getDataPass() {
        return "password12345";
    }

    @Test
    public void testTs11Tc41() throws InterruptedException {
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
        Thread.sleep(500);
        assertEquals(getTextByLanguage().toLowerCase(), driver.findElement(By.xpath("//div[@class='error']/p")).getText().toLowerCase());
    }

}
