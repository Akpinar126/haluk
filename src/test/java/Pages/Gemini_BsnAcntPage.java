package Pages;

import Utilities.Baseclass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Gemini_BsnAcntPage extends Baseclass {

    public Gemini_BsnAcntPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath ="//a[@class='e5i1odf0 css-1ndrma8 e5i1odf0']")
    private WebElement createBusinesAccaunt;
    @FindBy(xpath ="//a[@class='e5i1odf0 css-16pq41m e5i1odf0']")
    private WebElement popup;
    WebDriverWait wait=new WebDriverWait(driver,5);

    public void setCreateBusinesAccaunt(){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(popup));
            popup.click();}
        catch (Exception e) {
            e.printStackTrace();
        }
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(createBusinesAccaunt));
        createBusinesAccaunt.click();
    }
}

