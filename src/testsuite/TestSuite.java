package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

    public class TestSuite extends Utility {

    String baseUrl = "https://www.amazon.co.uk/";

    @Before
    public void setup() {
        // 1. Open the URL https://www.amazon.co.uk/
        openBrowser(baseUrl);
    }
    @Test
    public void amazon() throws InterruptedException {
       // clickOnElement(By.xpath("//input[@id='nav-search-submit-button']"));
        clickOnElement(By.name("accept"));

        //2. Type "Dell Laptop" in the search box and press enter or click on search Button.
        sendTextToElement(By.xpath("//input[@id='twotabsearchtextbox']"), "Dell Laptop");

        //3. Click on the checkbox brand dell on the left side.
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='nav-search-submit-button']"));

        clickOnElement(By.xpath("//*[@id='p_89/Dell']/span/a/div"));

        List<WebElement> products = driver.findElements(By.cssSelector(".a-size-mini.a-spacing-none.a-color-base.s-line-clamp-2"));
        int count = 1;
        for (WebElement i : products) {
            System.out.println(count + ": " + i.getText());
            count++;
        }
    }
    @After
    public void closeBroswer(){
        closeBrowser();
    }
}


