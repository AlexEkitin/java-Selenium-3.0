package ru.stqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MenuTest {

    private WebDriver wd;
    private WebDriverWait wait;

    int menuQuantity, submenuQuantity;

    @Before
    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait = new WebDriverWait(wd, 0);
    }

    @Test
    public void FirstTest() {
        wd.navigate().to("http://localhost/litecart/admin/");
        wd.findElement(By.name("username")).sendKeys("admin");
        wd.findElement(By.name("password")).sendKeys("admin");
        wd.findElement(By.name("login")).click();

        //list iz punktov menu
        menuQuantity = wd.findElements(By.id("app-")).size();

        for (int i = 0; i < menuQuantity; i++) {
            //delaem list, berem odin punkt i klikaem
            wd.findElements(By.id("app-")).get(i).click();
            //posle klika vse pomenialos, nuzno obnovit list
            //kolichestvo punktov podmenu
            submenuQuantity = wd.findElements(By.id("app-")).get(i).findElements(By.cssSelector("[id^=doc-]")).size();

            if (submenuQuantity != 0) {
                for (int k = 0; k < submenuQuantity; k++) {
                    //viberaem punkt menu i v nem punkt podmenu
                    wd.findElements(By.id("app-")).get(i).findElements(By.cssSelector("[id^=doc-]")).get(k).click();
                    wd.findElement(By.cssSelector("h1"));
                }
            } else {
                wd.findElement(By.cssSelector("h1"));
            }
        }
    }

    private void clickAndCheck(By by, String title) {
        wd.findElement(by).click();
        if (!wd.findElement(By.tagName("h1")).getText().equals(title)) {
            stop();
        }
    }

    @After
    public void stop() {
        wd.quit();
        wd = null;
    }
}
