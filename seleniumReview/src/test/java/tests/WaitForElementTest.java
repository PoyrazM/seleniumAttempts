package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import urls.IUrlParameters;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class WaitForElementTest extends BaseTest{
    WaitForElementTest(){
        setUp(IUrlParameters.waitTextPageUrl);
    }

    @Test
    void waitForTextTest(){
        waitForLocator(By.id("appears"));
        Assert.assertEquals(this.driver.findElement(By.id("appears")).getText() ,
"This is a new paragraph that appears after 8 seconds.");
    }

    @Test
    void fluentWaitTest(){
        this.fluentWait = new FluentWait<>(this.driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);

        WebElement parameter = this.fluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("appears"));
            }
        });
        Assert.assertEquals(parameter.getText() ,
"This is a new paragraph that appears after 8 seconds.");
    }
}
