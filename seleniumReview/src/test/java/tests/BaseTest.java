package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.AfterTest;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    Select select;
    WebDriverWait wait;

    Wait< WebDriver > fluentWait;

    JavascriptExecutor executor(){
        return (JavascriptExecutor) this.driver;
    }

     WebElement waitForLocator(By locator){
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    WebDriver.TargetLocator switchToFor(){
         return this.driver.switchTo();
    }

    WebDriver windowHandles(String reqWindow){
        return this.driver.switchTo().window(reqWindow);
    }
    Alert alert(){
       return this.driver.switchTo().alert();
    }

    Select selectForElement(WebElement element){
        return this.select = new Select(element);
    }


    void setUp(String url){
        List < String > optionsList = new ArrayList<>();
        optionsList.add("--start-maximized");
        optionsList.add("--incognito");

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(optionsList);
        this.driver = new ChromeDriver(options);
        this.driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
        this.wait = new WebDriverWait(this.driver , Duration.ofSeconds(15));
        this.driver.get(url);
    }

    @AfterTest
    void tearDown(){
        this.driver.quit();
    }
}
