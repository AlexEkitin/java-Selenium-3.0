package ru.stqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private WebDriver wd;
    private WebDriverWait wait;

    @Before
    public void start(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(wd, 10);
    }

    @Test
    public void FirstTest(){
        wd.navigate().to("http://localhost/litecart/admin/");
        wd.findElement(By.name("username")).sendKeys("admin");
        wd.findElement(By.name("password")).sendKeys("admin");
        wd.findElement(By.name("login")).click();

        clickAndCheck(By.cssSelector("span.name"), "Template");
        clickAndCheck(By.cssSelector("#doc-logotype > a > span.name"), "Logotype");
        clickAndCheck(By.xpath("(//li[@id='app-']/a/span[2])[2]"), "Catalog");
        clickAndCheck(By.cssSelector("#doc-product_groups > a > span.name"), "Product Groups");
        clickAndCheck(By.cssSelector("#doc-option_groups > a > span.name"), "Option Groups");
        clickAndCheck(By.cssSelector("#doc-manufacturers > a > span.name"), "Manufacturers");
        clickAndCheck(By.cssSelector("#doc-suppliers > a > span.name"), "Suppliers");
        clickAndCheck(By.cssSelector("#doc-delivery_statuses > a > span.name"), "Delivery Statuses");
        clickAndCheck(By.cssSelector("#doc-sold_out_statuses > a > span.name"), "Sold Out Statuses");
        clickAndCheck(By.cssSelector("#doc-quantity_units > a > span.name"), "Quantity Units");
        clickAndCheck(By.cssSelector("#doc-csv > a > span.name"), "CSV Import/Export");

        wd.findElement(By.xpath("(//li[@id='app-']/a/span[2])[3]")).click();
        wd.findElement(By.xpath("(//li[@id='app-']/a/span[2])[4]")).click();
        wd.findElement(By.xpath("(//li[@id='app-']/a/span[2])[5]")).click();
        wd.findElement(By.cssSelector("#doc-csv > a > span.name")).click();
        wd.findElement(By.cssSelector("#doc-newsletter > a > span.name")).click();
        wd.findElement(By.xpath("(//li[@id='app-']/a/span[2])[6]")).click();
        wd.findElement(By.xpath("(//li[@id='app-']/a/span[2])[7]")).click();
        wd.findElement(By.cssSelector("#doc-storage_encoding > a > span.name")).click();
        wd.findElement(By.xpath("(//li[@id='app-']/a/span[2])[8]")).click();
        wd.findElement(By.cssSelector("#doc-customer > a > span.name")).click();
        wd.findElement(By.cssSelector("#doc-shipping > a > span.name")).click();
        wd.findElement(By.cssSelector("#doc-payment > a > span.name")).click();
        wd.findElement(By.cssSelector("#doc-order_total > a > span.name")).click();
        wd.findElement(By.cssSelector("#doc-order_success > a > span.name")).click();
        wd.findElement(By.cssSelector("#doc-order_action > a > span.name")).click();
        wd.findElement(By.xpath("(//li[@id='app-']/a/span[2])[9]")).click();
        wd.findElement(By.cssSelector("#doc-order_statuses > a > span.name")).click();
        wd.findElement(By.xpath("(//li[@id='app-']/a/span[2])[10]")).click();
        wd.findElement(By.xpath("(//li[@id='app-']/a/span[2])[11]")).click();
        wd.findElement(By.cssSelector("#doc-most_sold_products > a > span.name")).click();
        wd.findElement(By.cssSelector("#doc-most_shopping_customers > a > span.name")).click();
        wd.findElement(By.xpath("(//li[@id='app-']/a/span[2])[12]")).click();
        wd.findElement(By.cssSelector("#doc-defaults > a > span.name")).click();
        wd.findElement(By.cssSelector("#doc-general > a > span.name")).click();
        wd.findElement(By.cssSelector("#doc-listings > a > span.name")).click();
        wd.findElement(By.cssSelector("#doc-images > a > span.name")).click();
        wd.findElement(By.cssSelector("#doc-checkout > a > span.name")).click();
        wd.findElement(By.cssSelector("#doc-advanced > a > span.name")).click();
        wd.findElement(By.cssSelector("#doc-security > a > span.name")).click();
        wd.findElement(By.xpath("(//li[@id='app-']/a/span[2])[13]")).click();
        wd.findElement(By.xpath("(//li[@id='app-']/a/span[2])[14]")).click();
        wd.findElement(By.cssSelector("#doc-tax_rates > a > span.name")).click();
        wd.findElement(By.xpath("(//li[@id='app-']/a/span[2])[15]")).click();
        wd.findElement(By.cssSelector("#doc-scan > a > span.name")).click();
        wd.findElement(By.cssSelector("#doc-csv > a > span.name")).click();
        wd.findElement(By.xpath("(//li[@id='app-']/a/span[2])[16]")).click();
        wd.findElement(By.xpath("(//li[@id='app-']/a/span[2])[17]")).click();


    }

    private void clickAndCheck(By by, String title) {
        wd.findElement(by).click();
        if (! wd.findElement(By.tagName("h1")).getText().equals(title)){
            stop();
        }
    }

    @After
    public void stop(){
        wd.quit();
        wd = null;
    }
}
