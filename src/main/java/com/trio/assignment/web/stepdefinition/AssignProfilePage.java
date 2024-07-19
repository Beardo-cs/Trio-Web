package com.trio.assignment.web.stepdefinition;


import com.qapitol.sauron.report.core.annotations.ReportTestStep;
import com.qapitol.sauron.web.AbstractWebPage;
import org.testng.Assert;

public class AssignProfilePage extends AbstractWebPage {

    public static final String Assign_Departments = "AssignDepartments";

    @ReportTestStep("On Profile Assignment Page, Click on Profile Assignment")
    public void ClickOnAssignDepartments() {
        Assert.assertTrue(waitAndCheckIsElementPresent(Assign_Departments));
        waitAndClickOn(Assign_Departments);
    }

}
