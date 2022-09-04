package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import urls.IUrlParameters;

import java.util.List;

public class RadioButtonTest extends BaseTest{
    RadioButtonTest(){
        setUp(IUrlParameters.dropDownAndCheckBoxUrl);
    }

    @Test
    void radioButtonTest(){
        List<WebElement> radioButtons = this.driver.findElements(By.cssSelector("label[for^='demo']"));
        for (int i = 0 ; i < radioButtons.stream().count() ; i++){
            if (i == 2)
            { break ; }
            radioButtons.get(i).click();
        }

        /*
        driver.findElement(By.cssSelector("[for='demo-priority-low']")).click();
        driver.findElement(By.cssSelector("[for='demo-priority-normal']")).click();
        driver.findElement(By.cssSelector("[for='demo-priority-high']")).click();
        */
    }

}
