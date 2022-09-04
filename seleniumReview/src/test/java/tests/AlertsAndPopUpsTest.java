package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import urls.IUrlParameters;

import java.util.Iterator;
import java.util.Set;

public class AlertsAndPopUpsTest extends BaseTest{
    AlertsAndPopUpsTest(){
        setUp(IUrlParameters.alertsAndPopUpsUrl);
    }

    @Test
    void alertsTest(){
        this.driver.findElement(By.cssSelector("[onclick='alertTrigger()']")).click();
        alert().accept();
    }

    @Test
    void popupsTest() {
        this.driver.findElement(By.cssSelector("[onclick='popup()']")).click();
        String mainWindow = driver.getWindowHandle();

        Set < String > handles = this.driver.getWindowHandles();
        Iterator < String > iterate = handles.iterator();

        while (iterate.hasNext()){
            String child = iterate.next();

            if (! mainWindow.equalsIgnoreCase(child)){
                windowHandles(child).close();
            }
        }
        windowHandles(mainWindow);
        Assert.assertEquals(this.driver.getTitle() , "Pop Ups");
    }
}
