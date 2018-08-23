package com.branch.qa.pages;

import com.branch.qa.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage extends BaseTest{


    @FindBy(name="q")
    private WebElement searchBox;

    public GoogleHomePage()
    {
        PageFactory.initElements(driver,this);
    }

    public String getGoogleTitle()
    {
        return driver.getTitle();
    }

    public void searchWithInput(String inputString)
    {
        searchBox.sendKeys(inputString);
        searchBox.submit();
    }
}