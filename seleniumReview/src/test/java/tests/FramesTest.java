package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import urls.IUrlParameters;

public class FramesTest extends BaseTest{
    FramesTest(){
        setUp(IUrlParameters.iFramesPageUrl);
    }

    @Test
    void iFramesTest(){
        switchToFor().frame(0);
        this.driver.findElement(By.cssSelector(".toggle")).click();
        switchToFor().parentFrame();
        this.driver.findElement(By.cssSelector(".toggle")).click();
    }

    @Test
    void youtubeVideoFrameTest(){
        executor().executeScript("window.scrollBy(0,200)");
        switchToFor().frame(1);
        this.driver.findElement(By.cssSelector("[aria-label='Oynat']")).click();
    }
}
