package DriverMethods;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waits {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1000, 500));
        driver.manage().window().setPosition(new Point(8, 30) );
        driver.manage().timeouts().pageLoadTimeout(3,TimeUnit.SECONDS);
        driver.navigate().to("https://www.egraficy.pl/");

        wait = new WebDriverWait(driver, 10);

    }

    @AfterEach
    public void closeAndQuit() {
        driver.close();
        driver.quit();
    }

    @Test
    public void waitExample(){
       // WebElement animation = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("//*[@id=\"top-menu\"]/li[3]/a")));
       // wait.until(ExpectedConditions.stalenessOf(animation));
        wait.until (ExpectedConditions.elementToBeClickable(By.cssSelector(
                "ul[class=\"nav\"]>li[class=\"menu-item menu-item-type-custom menu-item-object-custom menu-item-111\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='logo']"))).click();

        By counter = By.xpath("//*[@id=\"telefon\"]/div[2]/div/div/p/a");
        wait.until(ExpectedConditions.textToBe(counter, "503 40 40 89"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}