package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import urls.IUrlParameters;

public class ClickTest extends BaseTest{

    ClickTest(){
       setUp(IUrlParameters.clickTestUrl);
    }

    @Test
    void clickTest(){
        this.driver.findElement(By.id("btn_one")).click();
    }

    @Test
    void disabledButtonTest(){
        System.out.println(this.driver.findElement(By.id("btn_four")).isEnabled());
        System.out.println(this.driver.findElement(By.id("btn_two")).isEnabled());
    }
}
