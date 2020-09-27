package aia.login;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.*;

/**
 * Selenium test prihlaseni.
 *
 * 1.1.5.1 - zkusit se přihlásit se spravnym jmenem a se spravnym heslem
 *
 * Testováno ověřeni, zda přihlášení proběhlo uspesne a presmerovalo uzivatele na spravnou stranku"
 */

public class Ts11Tc51 {

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
            return "Log Out";
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
    public void testTs11Tc51() throws InterruptedException {
        System.setProperty(webdriverurl, chromedriver);
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(actualUrl);

        //overeni, ze pri aktivace nevznikne pop-up s potvrzenim aktivace, jak u prvni nabidky
        try {
            //hleda se tuto polozku
            By by = By.xpath("//li[2]/a[@class='regButton']");
            WebElement element = driver.findElement(by);
            assertNotEquals(getTextByLanguage().toLowerCase(), element.getText().toLowerCase());
        } catch (Exception e) {
            assertTrue(true);
        }
        //kliknuti tlacitka - Prihlaseni
        driver.findElement(By.xpath("//li[6]/a[@class='regButton']")).click();
        //napsani jmena do pole
        driver.findElement(By.xpath("//form/div[@class='form']/input[@id='log']")).sendKeys(getDataUser());
        driver.findElement(By.xpath("//form/div[@class='form']/input[@id='password']")).sendKeys(getDataPass());
        //kliknuti tlacitka - Prihlasit se
        driver.findElement(By.xpath("/" +
                "" +
                "/form/div[@class='form']/button[@class='button']")).click();
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("//nav/ul[@class='main-menu']/li[7]"));
        action.moveToElement(we).perform();
        assertEquals(getTextByLanguage().toLowerCase(), driver.findElement(By.xpath("//ul[@class='logo']/li[2]/a[@class='regButton']")).getText().toLowerCase());
    }

}
