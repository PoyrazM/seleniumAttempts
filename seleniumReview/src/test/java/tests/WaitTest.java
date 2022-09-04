package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import urls.IUrlParameters;

public class WaitTest extends BaseTest{
    WaitTest(){
        setUp(IUrlParameters.loaderPageUrl);
    }

    @Test
    void loaderTest(){
        this.driver.findElement(By.id("loaderBtn")).click();
        Assert.assertEquals(this.driver.findElement(By.id("p_wording")).getText() , "And you have clicked the button!");
    }
}
