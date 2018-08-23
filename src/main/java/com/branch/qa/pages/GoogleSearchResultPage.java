package com.branch.qa.pages;

import com.branch.qa.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResultPage extends BaseTest{

    @FindBy(css="a[href='https://branch.io/']")
    private WebElement branchLink;

    public GoogleSearchResultPage()
    {
        PageFactory.initElements(driver,this);
    }

    public String getGoogleResultTitle()
    {
        return driver.getTitle();
    }
    public void navigateToBranchWebsite()
    {
        if(branchLink.isDisplayed())
        {
            branchLink.click();
        }
    }
}