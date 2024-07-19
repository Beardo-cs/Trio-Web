package com.trio.assignment.web.stepdefinition;

import com.qapitol.sauron.common.configuration.Config;
import com.qapitol.sauron.core.Grid;
import com.qapitol.sauron.report.core.annotations.ReportTestStep;
import com.qapitol.sauron.web.AbstractWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class LoginPage extends AbstractWebPage {

    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String URL = "url";
    public static final String SIGN_IN_BUTTON = "signInButton";


    @ReportTestStep("Launch the web application login page. ")
    public void browserLaunchTrioStageWebsite() {
        Grid.driver().manage().window().maximize();
        Grid.driver().get(Config.getConfigProperty(URL));

    }


    @ReportTestStep("Enter valid credentials and login. ")
    public void loginIntoPage() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(waitAndCheckIsElementPresent(EMAIL));
        Assert.assertTrue(waitAndCheckIsElementPresent(PASSWORD));
        waitAndSetText(EMAIL, Config.getConfigProperty(EMAIL));
        waitAndSetText(PASSWORD, Config.getConfigProperty(PASSWORD));
        WebDriverWait wait = new WebDriverWait(Grid.driver(), Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='keepMeSignIn']")));
        element.click();
        Assert.assertTrue(waitAndCheckIsElementPresent(SIGN_IN_BUTTON));
        clickOnWithoutWait(SIGN_IN_BUTTON);
    }

}
