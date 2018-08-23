package com.branch.qa.testcases;

import com.branch.qa.base.BaseTest;
import com.branch.qa.pages.BranchHomePage;
import com.branch.qa.pages.BranchTeamPage;
import com.branch.qa.pages.GoogleHomePage;
import com.branch.qa.pages.GoogleSearchResultPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BranchTestCases extends BaseTest{

    GoogleHomePage googleHomePage;
    GoogleSearchResultPage searchResultPage;
    BranchHomePage branchHomePage;
    BranchTeamPage branchTeamPage;
    SoftAssert softAssert;

    public BranchTestCases()
    {
        super();
    }

    @BeforeMethod
    public void initialize()
    {
        initializeDriver();
        googleHomePage= new GoogleHomePage();
        searchResultPage= new GoogleSearchResultPage();
        branchHomePage=new BranchHomePage();
        branchTeamPage=new BranchTeamPage();
        softAssert= new SoftAssert();

    }


    @Test(priority = 1, description = "Verify that number of employees, employee names, employee designations match between All tab and sum of other tabs")
    public void checkEmployeeDetails()
    {
        String googleTitle=googleHomePage.getGoogleTitle();
        softAssert.assertEquals(googleTitle,"Google","Google Home Page title does not match");
        googleHomePage.searchWithInput(properties.getProperty("googleSearchInput"));
        String resultPageTitle=searchResultPage.getGoogleResultTitle();
        softAssert.assertEquals(resultPageTitle,properties.getProperty("googleSearchInput")+" - Google Search", "Google Search results page title does not match");
        searchResultPage.navigateToBranchWebsite();
        branchHomePage.acceptCondition();
        branchHomePage.scrollToBottomOfHomePage();
        branchHomePage.clickOnTeam();
        String teamPageTitle=branchTeamPage.getTeamPageTitle();
        softAssert.assertEquals(teamPageTitle,"Team | Branch","Branch Team page title does not match");
        branchTeamPage.scrollByAxis();
        softAssert.assertEquals(branchTeamPage.getAllEmployeeDetails(),branchTeamPage.getOtherEmployeeDetails(),"Either Total employee count, total employee names or total employee departs don't match with all other tabs");
        softAssert.assertAll();
    }


   @AfterMethod
    public void closeBrowser()
    {
        driver.quit();
    }


}