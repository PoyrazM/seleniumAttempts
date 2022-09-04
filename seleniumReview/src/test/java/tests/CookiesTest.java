package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import urls.IUrlParameters;

public class CookiesTest extends BaseTest{
    CookiesTest(){
        setUp(IUrlParameters.testStorePageUrl);
    }

    @Test
    void cookiesHandlesTest(){
        this.driver.findElement(By.cssSelector("[title] .hidden-sm-down")).click();
        this.driver.findElement(By.name("email")).sendKeys("demo@mail.com");
        this.driver.findElement(By.name("password")).sendKeys("123456");
        this.driver.findElement(By.id("submit-login")).click();
        this.driver.findElement(By.linkText("CLOTHES")).click();
        this.driver.findElement(By.cssSelector("[alt='Hummingbird printed t-shirt']")).click();
        this.driver.findElement(By.cssSelector(".add-to-cart")).click();
        this.driver.findElement(By.cssSelector(".btn-secondary")).click();

        this.driver.manage().deleteAllCookies();

    }
}
