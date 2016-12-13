package ru.stqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class StickerTest {

    private WebDriver wd;

    @Before
    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    @Test
    public void FirstTest() {
        wd.navigate().to("http://localhost/litecart/");

        List<WebElement> products = wd.findElements(By.className("product"));
        for (WebElement product : products) {
            if (product.findElements(By.cssSelector("li.product .sticker")).size() != 1)
            {
                stop();
            }
        }
    }

    @After
    public void stop() {
        wd.quit();
        wd = null;
    }
}
