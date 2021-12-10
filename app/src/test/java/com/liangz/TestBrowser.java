package com.liangz;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestBrowser extends BaseTest {
    @Test
    public void testOne() throws InterruptedException {
        driver.get("https://saucelabs.com/test/guinea-pig");
        WebElement div =  driver.findElementByXPath("//div[@id='i_am_an_id']");
        Assert.assertEquals("I am a div", div.getText());
        System.out.println("Sleep for command timeout");
        Thread.sleep(70000);
        driver.findElementByXPath("//input[@id='unchecked_checkbox']").click();
        System.out.println("Finish Test One");
    }
}
