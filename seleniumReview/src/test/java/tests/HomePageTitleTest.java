package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import urls.IUrlParameters;

public class HomePageTitleTest extends BaseTest{
    HomePageTitleTest(){
        setUp(IUrlParameters.homePageUrl);
    }

    @Test
    void pageTitleTest(){
        Assert.assertEquals
                (this.driver.getTitle() , "Homepage");
    }

    @Test
    void h1TitleTest(){
        Assert.assertEquals(this.driver.findElement
                (By.cssSelector("h1")).getText() , "Testing Arena");
    }
}
