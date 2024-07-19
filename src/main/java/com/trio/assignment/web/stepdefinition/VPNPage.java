package com.trio.assignment.web.stepdefinition;

import com.qapitol.sauron.common.configuration.Config;
import com.qapitol.sauron.core.Grid;
import com.qapitol.sauron.report.core.annotations.ReportTestStep;
import com.qapitol.sauron.web.AbstractWebPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class VPNPage extends AbstractWebPage {

    public static final String Input_Connection_Name = "connectionName";
    public static final String Input_Server_Name = "server";
    public static final String Input_Account_Name = "account";
    public static final String Input_Shared_Name = "sharedSecret";
    public static final String Create_Button = "createButton";
    public static final String Profile_Created_Popup = "profileCreatedPopup";
    public static final String Assign_Button = "assignButton";

    public static final String Connection_Name = "ConnectionName";
    public static final String Server_Name = "ServerName";

    public static final String Account_Name = "AccountName";

    public static final String SharedSecret_Name = "SharedSecret";

    public static String ConnectionActualText = "";

    public static String Server_Actual_Name = "ServerName";

    public static String Account_Actual_Name = "AccountName";

    public static String SharedSecret_Actual_Name = "SharedSecret";


    @ReportTestStep("Create a Profile with Required Details")
    public void createProfileWithRequiredDetails() {
        Assert.assertTrue(waitAndCheckIsElementPresent(Input_Connection_Name));
        waitAndSetText(Input_Connection_Name, Config.getConfigProperty(Connection_Name));
        waitAndSetText(Input_Server_Name, Config.getConfigProperty(Server_Name));
        waitAndSetText(Input_Account_Name, Config.getConfigProperty(Account_Name));
        waitAndSetText(Input_Shared_Name, Config.getConfigProperty(SharedSecret_Name));
    }

    @ReportTestStep("Validate the Input Fields on VPN Page")
    public void ValidateTheInputFields() {
        ConnectionActualText = waitAndGetAttribute(Input_Connection_Name, "value");
        Assert.assertEquals(ConnectionActualText, Config.getConfigProperty(Connection_Name));
        Server_Actual_Name = waitAndGetAttribute(Input_Server_Name, "value");
        Assert.assertEquals(Server_Actual_Name, Config.getConfigProperty(Server_Name));
        Account_Actual_Name = waitAndGetAttribute(Input_Account_Name, "value");
        Assert.assertEquals(Account_Actual_Name, Config.getConfigProperty(Account_Name));
        SharedSecret_Actual_Name = waitAndGetAttribute(Input_Shared_Name, "value");
        Assert.assertEquals(SharedSecret_Actual_Name, Config.getConfigProperty(SharedSecret_Name));

    }

    @ReportTestStep("Save a Profile and Click on Assign")
    public void CreateProfileAndClickAssign() throws InterruptedException {
        waitAndClickOn(Create_Button);
        if (waitAndCheckIsElementPresent(Profile_Created_Popup)) {
            waitAndClickOn(Assign_Button);
        }


    }
}
