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

public class HomePage extends AbstractWebPage {

    public static final String Hamburger_ICON = "hamburgerIcon";
    public static final String Profile_Menu = "profiles";
    public static final String Configuration_Profiles = "configurationProfiles";
    public static final String No_Profiles = "noProfiles";
    public static final String NoProfiles_CreateNew = "NoProfilesCreateNew";
    public static final String Create_NewProfiles = "createNew";
    public static final String TrailPopup = "TrailPopUP";
    public static final String ContinueFreeTrail = "ContinueTrail";




    public static final String SIGN_IN_BUTTON = "signInBtn";



    @ReportTestStep("Click on Continue on Free Trail Popup")
    public void clickOnTrailPopupContinueButton(){
        if(waitAndCheckIsElementPresent(10,Profile_Menu)){
            waitAndClickOn(ContinueFreeTrail);
        }


    }
    @ReportTestStep("Navigate to Profile from the sidebar.")
    public void clickOnProfileFromTheSidebar() {
            waitAndClickOn(Profile_Menu);

    }

    @ReportTestStep("Click on \"Configuration\" sub-menu.")
    public void clickOnConfigurationSubMenu() {
        waitAndClickOn(Configuration_Profiles);
    }


    @ReportTestStep("Click on \"Create New Profile\".")
    public void clickOnCreateProfile() {
        if (isElementPresent(No_Profiles)) {
            waitAndClickOn(NoProfiles_CreateNew);
        } else {
            waitAndClickOn(Create_NewProfiles);


        }
    }


}
