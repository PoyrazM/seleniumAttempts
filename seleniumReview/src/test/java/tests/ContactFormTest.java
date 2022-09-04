package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import urls.IUrlParameters;

public class ContactFormTest extends BaseTest{
    ContactFormTest(){
        setUp(IUrlParameters.contactFormTestUrl);
    }

    @Test
    void sendKeysToFormTest(){
        this.driver.findElement(By.name("first_name")).sendKeys("Mertcan");
        this.driver.findElement(By.name("last_name")).sendKeys("Tester");
        this.driver.findElement(By.name("email")).sendKeys("mail@mail.com");
        this.driver.findElement(By.name("message")).sendKeys("I am a tester dude ! ");
        this.driver.findElement(By.cssSelector("[type='submit']")).click();
        String expectedTitle = this.driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedTitle , "Thank you for your mail!");
    }

    @Test
    void clickToSubmitButtonJSExe(){
        WebElement submit = this.driver.findElement(By.cssSelector("[type='submit']"));
        WebElement reset = this.driver.findElement(By.cssSelector("[type='reset']"));
        executor().executeScript("arguments[0].click() , arguments[1].click()" , reset , submit);
    }

    @Test
    void byLinkForActionsTest(){
        this.driver.findElement(By.linkText("ACTIONS")).click();
    }

    @Test
    void byLinkForButtonsTest(){
        this.driver.findElement(By.linkText("BUTTONS")).click();
    }
}
