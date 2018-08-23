package com.branch.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest {

    public static Properties properties;
    public static WebDriver driver;

    public BaseTest()
    {
        try
        {
            properties=new Properties();
            FileInputStream fileInputStream=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\branch\\qa\\config\\global.properties");
            properties.load(fileInputStream);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void initializeDriver()
    {

        String driverFileExe=BaseTest.getCurrentPlatformDriver();
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\"+driverFileExe);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("googleUrl"));
    }

    public static String getCurrentPlatformDriver() {
        String currentPlatform = System.getProperty("os.name").toLowerCase();
        System.out.println("currentPlatform "+currentPlatform);
        String currentPlatformDriver = null;
        if(currentPlatform.contains("win"))
                currentPlatformDriver = "chromedriver.exe";
         else if(currentPlatform.contains("mac"))
                currentPlatformDriver = "chromedriver_mac.exe";
         else
            currentPlatformDriver = "chromedriver_linux.exe";
         return currentPlatformDriver;
    }
}