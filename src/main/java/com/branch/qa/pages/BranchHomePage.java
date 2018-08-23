package com.branch.qa.pages;

import com.branch.qa.base.BaseTest;
import com.branch.qa.util.TestUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BranchHomePage extends BaseTest{

    TestUtils testUtils;

    @FindBy(css="#cookiebanner")
    private WebElement accept;

    @FindBy(linkText = "Team")
    private WebElement teamLink;

    @FindBy(linkText = "Support")
    private WebElement support;

    public BranchHomePage()
    {
        PageFactory.initElements(driver,this);
        testUtils=new TestUtils();
    }

    public void acceptCondition()
    {
        testUtils.explicitWaitForElementToBeClickable(accept);
        accept.click();
    }

    public void clickOnTeam()
    {
        teamLink.click();
    }

    public void scrollToBottomOfHomePage()
    {
        testUtils.scrollTillBottom();
    }

}