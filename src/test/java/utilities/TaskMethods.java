package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.*;

public class TaskMethods extends BasePage {

    public TaskMethods(WebDriver driver) {
        super(driver);
    }


    public void navigateToSiteUrl() {
        sleep(1);
        navigateToURL(configuration.getProperty("site_url"));
        String checkUrl = driver.getCurrentUrl();
        Assert.assertEquals(checkUrl, configuration.getProperty("site_url"));
    }

    protected void login() {
        navigateToURL(configuration.getProperty("site_url"));
        clickElementByXpath("//*[@id=\"btnMyAccount\"]");
        clickElementByXpath("/html/body/header/nav/div[2]/div[1]/div/div/div[2]/div[3]/div/div[1]/ul/li[1]/a");
        fillInTheBlankById("email", configuration.getProperty("user_name"));
        fillInTheBlankById("pass", configuration.getProperty("password"));
        clickElementById("login-button");
        String userName = driver.findElement(By.xpath("//*[@id=\"email\"]")).getText();
        Assert.assertEquals(userName, configuration.getProperty("user_name"));
    }
}
