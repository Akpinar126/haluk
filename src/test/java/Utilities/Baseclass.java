package Utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Baseclass extends DriverUtill {

    @BeforeMethod
    public void setup()  {
        DriverUtill.getDriver();
        driver.get(Configuration_reader.getProperties("baseUrl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
    }
//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }

}
