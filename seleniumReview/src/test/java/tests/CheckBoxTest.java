package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import urls.IUrlParameters;

public class CheckBoxTest extends BaseTest{
    CheckBoxTest(){
        setUp(IUrlParameters.dropDownAndCheckBoxUrl);
    }

    @Test
    void clickCheckBoxTest(){
        System.out.println(this.driver.findElement(By.id("cb_red")).isSelected());
        System.out.println(this.driver.findElement(By.id("cb_green")).isSelected());
        this.driver.findElement(By.cssSelector("[for='cb_green']")).click();
        System.out.println(this.driver.findElement(By.id("cb_green")).isSelected());
    }
}
