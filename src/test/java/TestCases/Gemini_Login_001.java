package TestCases;


import Pages.Gemini_BsnAcntPage;
import Pages.Gemini_LoginPage;
import Pages.Gemini_regist_instutionPage;
import Pages.Thanks_Page;
import Utilities.Baseclass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Gemini_Login_001 extends Baseclass {
    @Test
    public void happyPathTesting() throws InterruptedException {
        Gemini_LoginPage gemini_loginPage=new Gemini_LoginPage();
        Gemini_BsnAcntPage gemini_bsnAcntPage=new Gemini_BsnAcntPage();
        Gemini_regist_instutionPage geminiInstitution_registrationPage =new Gemini_regist_instutionPage();
        Thanks_Page thanks=new Thanks_Page();
        gemini_loginPage.setCreateNewAccount();
        gemini_bsnAcntPage.setCreateBusinesAccaunt();
        String actual=driver.getCurrentUrl();
        System.out.println(actual);
        String expected="https://exchange.sandbox.gemini.com/register/institution";
        Assert.assertEquals(actual,expected,"WE ARE NOT IN THE EXPECTED PAGE RIGHT NOW ");
        System.out.println("now we are in the register/institution page");
        geminiInstitution_registrationPage.positiveTest();
        thanks.AccauntVerification();


    }

    @Test
    public void negativeTesting() throws InterruptedException {
        Gemini_LoginPage gemini_loginPage=new Gemini_LoginPage();
        Gemini_BsnAcntPage gemini_bsnAcntPage=new Gemini_BsnAcntPage();
        Gemini_regist_instutionPage geminiInstitution_registrationPage =new Gemini_regist_instutionPage();
        gemini_loginPage.setCreateNewAccount();
        gemini_bsnAcntPage.setCreateBusinesAccaunt();
        String actual=driver.getCurrentUrl();
        String expected="https://exchange.sandbox.gemini.com/register/institution";
        Assert.assertEquals(actual,expected,"WE ARE NOT IN THE EXPECTED PAGE RIGHT NOW ");
        System.out.println("now we are in the register/institution page");
        geminiInstitution_registrationPage.negatifTest();

    }
}



