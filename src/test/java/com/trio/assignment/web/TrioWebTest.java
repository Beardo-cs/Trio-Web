package com.trio.assignment.web;

import com.qapitol.sauron.core.pages.DiService;
import com.qapitol.sauron.report.core.annotations.ReportTest;
import com.trio.assignment.web.stepdefinition.*;
import org.testng.annotations.Test;

import com.qapitol.sauron.common.annotations.SauronTest;

@SauronTest
public class TrioWebTest {

  final LoginPage loginPage = DiService.get(LoginPage.class);

  final HomePage homePage = DiService.get(HomePage.class);

  final VPNPage vpnPage  = DiService.get(VPNPage.class);

  final ConfigurationProfilePage configurationProfilePage  = DiService.get(ConfigurationProfilePage.class);

  final AssignProfilePage assignProfilePage = DiService.get(AssignProfilePage.class);



  @SauronTest
  @Test(priority = 0)
  @ReportTest("Trio Web Application Create and Assign a VPN Profile Scenario")
  public void E2E_TrioStage_Application_Scenario1() throws InterruptedException {
    loginPage.browserLaunchTrioStageWebsite();
    loginPage.loginIntoPage();
    homePage.clickOnTrailPopupContinueButton();
    homePage.clickOnProfileFromTheSidebar();
    homePage.clickOnConfigurationSubMenu();
    homePage.clickOnCreateProfile();
    configurationProfilePage.SelectMACOSFilter();
    configurationProfilePage.SearchVPN();
    configurationProfilePage.CreateProfile();
    vpnPage.createProfileWithRequiredDetails();
    vpnPage.ValidateTheInputFields();
    vpnPage.CreateProfileAndClickAssign();
    assignProfilePage.ClickOnAssignDepartments();
  }

}
