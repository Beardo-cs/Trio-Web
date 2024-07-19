package com.trio.assignment.web.stepdefinition;

import com.qapitol.sauron.common.configuration.Config;
import com.qapitol.sauron.report.core.annotations.ReportTestStep;
import com.qapitol.sauron.web.AbstractWebPage;
import org.testng.Assert;

public class ConfigurationProfilePage extends AbstractWebPage {

    public static final String MacOS = "macOS";
    public static final String VPN_Suggestion = "VPN";
    public static final String Profile_Name = "profileName";
    public static final String Confirm_BUTTON = "confirmButton";
    public static final String Input_Profile_Name = "ProfileName";


    @ReportTestStep("Filter the profiles for MacOS.")
    public void SelectMACOSFilter() {
        Assert.assertTrue(waitAndCheckIsElementPresent(MacOS));
        waitAndClickOn(MacOS);


    }

    @ReportTestStep("Search for the VPN")
    public void SearchVPN() {
        waitAndClickOn(VPN_Suggestion);
    }

    @ReportTestStep("Create a new VPN profile with a unique name.")
    public void CreateProfile() {
        waitAndSetText(Profile_Name, Config.getConfigProperty(Input_Profile_Name));
        waitAndClickOn(Confirm_BUTTON);

    }
}
