package Pages;

import Utilities.Baseclass;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Gemini_LoginPage extends Baseclass {

    public Gemini_LoginPage() {


        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='e5i1odf0 css-10iczv1 e5i1odf0']")
    public WebElement createNewAccount;

    public void setCreateNewAccount() {
        createNewAccount.click();
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();

    }


}
