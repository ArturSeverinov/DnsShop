package ru.dnsShop;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseForDnsShop {

    ChromeDriver driver;

    @Before
    public void prepare() {
        System.setProperty("webdriver.chrome.driver", "S:/Java/Chrome webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @After
    public void close() {
        driver.quit();
    }
}
