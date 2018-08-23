package com.branch.qa.pages;

import com.branch.qa.base.BaseTest;
import com.branch.qa.util.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.TreeMap;

public class BranchTeamPage extends BaseTest {

    private TestUtils utils;

    @FindBy(xpath="//ul[@class='team-categories']/li")
    private List<WebElement> teamCategories;

    public BranchTeamPage()
    {
        PageFactory.initElements(driver,this);
        utils=new TestUtils();
    }

    public String getTeamPageTitle()
    {
        return driver.getTitle();
    }

    public void scrollByAxis()
    {
        utils.scrollByAxis(500);
    }

    private TreeMap<String,String> getEmployeeDetails(String nameCss, String departmentCss)
    {
        TreeMap<String,String> empDetails= new TreeMap<String, String>();
        List<WebElement> empNames= driver.findElements(By.cssSelector(nameCss));
        List<WebElement> departmentNames=driver.findElements(By.cssSelector(departmentCss));
        for(int e=0;e < empNames.size(); e++)
        {
            empDetails.put(empNames.get(e).getText(),departmentNames.get(e).getText());
        }
        return empDetails;
    }

    public TreeMap<String,String> getAllEmployeeDetails()
    {
        TreeMap<String,String> allEmpDetails= new TreeMap<String, String>();
        allEmpDetails=getEmployeeDetails(".category-all h2",".category-all h4");
        return  allEmpDetails;
    }


    public TreeMap<String,String> getOtherEmployeeDetails() {
        TreeMap<String, String> otherEmpDetails = new TreeMap<String, String>();
        int departmentCount = teamCategories.size();
        for (int p = 2; p <= departmentCount; p++) {
            WebElement categories=driver.findElement(By.cssSelector(".team-categories li:nth-of-type(" + p + ")"));
            categories.click();
            TreeMap<String, String> tempEmpDetails = getEmployeeDetails(".category-" + categories.getText().toLowerCase().replaceAll(" ","-") + " h2", ".category-" + categories.getText().toLowerCase().replaceAll(" ","-") + " h4");
            otherEmpDetails.putAll(tempEmpDetails);
        }
        return otherEmpDetails;
    }
}