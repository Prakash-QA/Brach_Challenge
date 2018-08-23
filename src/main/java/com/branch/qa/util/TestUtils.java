package com.branch.qa.util;

import com.branch.qa.base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtils extends BaseTest{

    private WebDriverWait wait;
    private JavascriptExecutor javascriptExecutor;

   public TestUtils()
   {
       wait=new WebDriverWait(driver,50);
       javascriptExecutor= (JavascriptExecutor) driver;
   }

    public void explicitWaitForElementToBeClickable(WebElement element)
    {

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollTillElement(WebElement webElement)
    {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",webElement);
    }

    public void scrollTillBottom()
    {
        javascriptExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public void scrollByAxis(long Yaxis)
    {
        javascriptExecutor.executeScript("window.scrollBy(0,"+Yaxis+")");
    }
}