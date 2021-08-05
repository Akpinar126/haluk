package Pages;

import Utilities.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Thanks_Page extends Baseclass {
    public Thanks_Page(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//h3[.='Thanks for Registering!']")
    private WebElement thanks;  //i use this as a booleon in try catch block
    WebDriverWait wait=new WebDriverWait(driver,5);
    public void AccauntVerification() {
        wait.until(ExpectedConditions.visibilityOf(thanks));
        String actual = thanks.getText();
        String expected = "Thanks for Registering!";
        Assert.assertEquals(actual,expected,"Business Account verification failed");
        System.out.println("HAPPY PATH TEST IS PASSED "+actual);
    }
}
