package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import urls.IUrlParameters;

public class DropDownTest extends BaseTest{
    DropDownTest(){
        setUp(IUrlParameters.dropDownAndCheckBoxUrl);
    }

    @Test
    void dropDownWithValueTest(){
        selectForElement(driver.findElement(By.id("cars"))).selectByValue("jeep");
    }

    @Test
    void dropDownWithTextTest(){
        selectForElement(driver.findElement(By.id("cars"))).selectByVisibleText("BMW");
    }
}
