/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test.com;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Daivat Pandya
 */
public class IndeedTest {

    private WebDriver driver;
    private String baseUrl;

    public IndeedTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testIndeedSearch() throws Exception {
        System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        driver.get("https://www.indeed.com/");
        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("java");
        driver.findElement(By.name("l")).click();
        driver.findElement(By.name("l")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(By.name("l")).sendKeys("Chicago, IL");
        driver.findElement(By.xpath("//*[@id=\"jobsearch\"]/button")).click();
        driver.findElement(By.id("jobsearch")).submit();
        driver.findElement(By.xpath("//*[@id=\"popover-x\"]/button")).click();
        driver.findElement(By.id("jobsInLocation")).click();
        assertEquals("java jobs in Chicago, IL", driver.findElement(By.id("jobsInLocation")).getText());
    }

}
