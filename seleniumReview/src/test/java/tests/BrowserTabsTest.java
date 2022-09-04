package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import urls.IUrlParameters;

import java.util.ArrayList;
import java.util.List;

public class BrowserTabsTest extends BaseTest{
    BrowserTabsTest(){
        setUp(IUrlParameters.browserTabsPageUrl);
    }

    @Test
    void newTabTest(){
        for (int i = 0 ; i < 3 ; i++) {
            this.driver.findElement(By.cssSelector("[type='submit']")).click();
        }

        List< String > window = new ArrayList<>(this.driver.getWindowHandles());
        System.out.println("There are " + window.size() + " tabs opened");

        for (String tab : window){
            windowHandles(tab);
        }

        windowHandles(window.get(0));
    }
}
