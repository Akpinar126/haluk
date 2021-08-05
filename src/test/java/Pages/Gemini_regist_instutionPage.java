package Pages;

import Utilities.Baseclass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Gemini_regist_instutionPage extends Baseclass {

    public Gemini_regist_instutionPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='company.legalName']")
    private WebElement companyName;
    @FindBy(id = "companyTypeDropdown")
    private WebElement companyType;
    @FindBy(id = "countryDropdown")
    private WebElement countrys;
    @FindBy(id = "stateDropdown")
    private WebElement state;
    @FindBy(name = "personal.legalName.firstName")
    private WebElement fName;
    @FindBy(xpath = "//input[@name='personal.legalName.middleName']")
    private WebElement middleName;
    @FindBy(xpath = "//input[@name='personal.legalName.lastName']")
    private WebElement lName;
    @FindBy(xpath = "//input[@name='personal.email']")
    private WebElement email;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit;
    @FindBy(xpath = "//div[@class=' css-bqgaat-singleValue']")
    private WebElement us;
    @FindBy(xpath="//div[@class='AlertBody']")
    private WebElement alertBody;

    WebDriverWait wait = new WebDriverWait(driver, 5);
    public void positiveTest() {
        companyName.sendKeys("GEMINI");
        companyType.sendKeys("Trust");
        companyType.sendKeys(Keys.ARROW_DOWN);
        companyType.sendKeys(Keys.ENTER);
        try {
            countrys.sendKeys("Italy");
            countrys.sendKeys(Keys.ARROW_DOWN);
            countrys.sendKeys(Keys.ENTER);
            if (us.isDisplayed()) {
                state.sendKeys("NY");
                state.sendKeys(Keys.ARROW_DOWN);
                state.sendKeys(Keys.ENTER);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        fName.sendKeys("HALUK");
        lName.sendKeys("AKPINAR");
        middleName.sendKeys("N/A");

        email.sendKeys("haluk@gemini.com");//manually we will enter our input

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();

    }

    public void negatifTest() {
        companyName.sendKeys("KIRKLAND");
        companyType.sendKeys("Operating Company");
        companyType.sendKeys(Keys.ARROW_DOWN);
        companyType.sendKeys(Keys.ENTER);
        try {
            countrys.sendKeys("United State");
            countrys.sendKeys(Keys.ARROW_DOWN);
            countrys.sendKeys(Keys.ENTER);
            if (us.isDisplayed()) {
                state.sendKeys("NY");
                state.sendKeys(Keys.ARROW_DOWN);
                state.sendKeys(Keys.ENTER);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        fName.sendKeys("james");
        lName.sendKeys("");
        middleName.sendKeys("");
        email.sendKeys("james@gemini.com");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();
        Actions scrollUp=new Actions(driver);
        scrollUp.sendKeys(Keys.PAGE_UP).build().perform();
        wait.until(ExpectedConditions.visibilityOf(alertBody));
        String actuall=alertBody.getText();
        System.out.println("actuall = " + actuall);
        Assert.assertTrue(
                actuall.contains("Legal Business Name is required.") || actuall.contains("Company type is required.")
                        || actuall.contains("First name is required.") || actuall.contains("Last name is required.")
                        || actuall.contains("Please enter a valid email address.")|| actuall.contains("Company state is required.")
                        ||actuall.contains("Please specify a valid email domain."));

        System.out.println("NEGATIVE TEST CASE IS PASSED = "+"please read the Alert body  "+actuall);

    }

}

