package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class BaseTest {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    TaskMethods taskMethods;

    @BeforeClass
    public void setup() {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions());
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
            wait = new WebDriverWait(driver, 30);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @AfterClass()
    public void AfterClass() {
        driver.quit();
    }

    private ChromeOptions chromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-legacy-window");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--aggressive-cache-discard");
        chromeOptions.addArguments("--disable-cache");
        chromeOptions.addArguments("--disable-application-cache");
        chromeOptions.addArguments("--disable-offline-load-stale-cache");
        chromeOptions.addArguments("--disk-cache-size=0");
        chromeOptions.addArguments("--dns-prefetch-disable");
        chromeOptions.addArguments("--no-proxy-server");
        chromeOptions.addArguments("--log-level=3");
        chromeOptions.addArguments("--silent");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--disable-translate");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("enable-automation");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-browser-side-navigation");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("disable-features=NetworkService");
        chromeOptions.addArguments("enable-features=NetworkServiceInProcess");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.setProxy(null);
        return chromeOptions;
    }


}
