package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import urls.IUrlParameters;
import java.util.List;

public class AccordionTest extends BaseTest{
    AccordionTest(){
        setUp(IUrlParameters.accordionPageUrl);
    }

    @Test
    void accordionTest(){
        List<WebElement> accordions = this.driver.findElements(By.cssSelector("div.accordion-header"));
        for(int i = 0; i < accordions.stream().count() ; i++){
            accordions.get(i).click();
            accordions.get(i).click();
        }
    }
}
