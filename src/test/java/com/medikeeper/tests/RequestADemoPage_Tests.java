package com.medikeeper.tests;
import com.medikeeper.pages.HomePage;
import com.medikeeper.pages.RequestADemoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RequestADemoPage_Tests extends TestBase {

    HomePage homePage = new HomePage();
    RequestADemoPage requestADemoPage = new RequestADemoPage();

    @Test (description = "User should not be able to submit demo request ")
    public void testScenario_1() throws InterruptedException {
        homePage.clickOnRequestADemoButton();
        requestADemoPage.enterDemoRequestForm();
        requestADemoPage.clickSubmitButton();
        String actualResult = requestADemoPage.getCaptchaErrorMessage();
        String expectedResult = "The reCAPTCHA was invalid. Go back and try it again.";
        Assert.assertEquals(expectedResult, actualResult);
    }


    @Test (description = "User should see \"There was a problem with your submission. Errors have been highlighted below.\"")
    public void testScenario_2() throws InterruptedException {
        homePage.clickOnRequestADemoButton();
        requestADemoPage.enterFormWithMissingField();
        requestADemoPage.clickSubmitButton();
        String actualResult = requestADemoPage.getSubmissionErrorMessage();
        String expectedResult = "There was a problem with your submission. Errors have been highlighted below.";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test (description = "User should see \"Thank you for requesting a demo! We’ll be in touch with you shortly to schedule it.")
    public void testScenario_3 () throws InterruptedException {
        homePage.clickOnRequestADemoButton();
        requestADemoPage.enterDemoRequestForm();
        requestADemoPage.clickSubmitButton();
        String actualResult = requestADemoPage.getCaptchaErrorMessage();
        String expectedResult = "Thank you for requesting a demo! We’ll be in touch with you shortly to schedule it.";
        Assert.assertEquals(expectedResult, actualResult);
    }

}
