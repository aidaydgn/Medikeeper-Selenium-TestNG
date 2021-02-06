package com.medikeeper.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

/*
I store all the web elements and methods related to Request A Demo Page in this .java class.
 */

public class RequestADemoPage extends BasePage {
    Faker faker = new Faker();

    @FindBy(name = "input_1")
    private WebElement firstNameBox;

    @FindBy(name = "input_7")
    private WebElement lastNameBox;

    @FindBy(name = "input_2")
    private WebElement companyBox;

    @FindBy(name = "input_3")
    private WebElement companyTypeList;

    @FindBy(name = "input_4")
    private WebElement numberOfUsersBox;

    @FindBy(name = "input_9")
    private WebElement phoneBox;

    @FindBy(name = "input_5")
    private WebElement emailBox;

    @FindBy(name = "input_12")
    private WebElement cellBox;

    @FindBy(name = "input_10")
    private WebElement areasOfInterestBox;

    @FindBy(xpath = "//*[@id=\"rc-anchor-container\"]/div[3]/div[1]/div/div")
    private WebElement reCaptcha;

    @FindBy(id = "gform_submit_button_5")
    private WebElement submitButton;


    @FindBy(xpath = "//div[contains(text(), 'The reCAPTCHA was invalid. Go back and try it again.')]")
    private List<WebElement> captchaErrorMessage;

    @FindBy(xpath = "//div[contains(text(), 'There was a problem with your submission. Errors have been highlighted below.')]")
    private List<WebElement> submissionErrorMessage;


    public void enterDemoRequestForm() throws InterruptedException {
        firstNameBox.sendKeys(faker.name().firstName());
        lastNameBox.sendKeys(faker.name().lastName());
        companyBox.sendKeys(faker.company().name());
        Select selectCompanyType = new Select(companyTypeList);
        selectCompanyType.selectByIndex(faker.number().numberBetween(1, selectCompanyType.getOptions().size()));
        Select selectNumberOfUsers = new Select(numberOfUsersBox);
        selectNumberOfUsers.selectByIndex(faker.number().numberBetween(1, selectNumberOfUsers.getOptions().size()));
        emailBox.sendKeys(faker.internet().emailAddress());
        phoneBox.sendKeys(faker.phoneNumber().phoneNumber());
        cellBox.sendKeys(faker.phoneNumber().cellPhone());
        areasOfInterestBox.sendKeys(faker.medical().symptoms());

    }

    /**
     * public void captchaRobotChallenge() {
     * <p>
     * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
     * WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark")));
     * <p>
     * Actions action = new Actions(Driver.getDriver());
     * action.click(element).perform();
     * Driver.getDriver().switchTo().defaultContent();
     * <p>
     * }
     */

    public String getCaptchaErrorMessage() throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(captchaErrorMessage.get(0)));
        return element.getText();
    }


    public void clickSubmitButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).submit();
    }

    public String getSubmissionErrorMessage() {
        WebElement element2 = wait.until(ExpectedConditions.visibilityOf(submissionErrorMessage.get(0)));
        return element2.getText();

    }

    public void enterFormWithMissingField() {

        firstNameBox.sendKeys(faker.name().firstName());
        lastNameBox.sendKeys(faker.name().lastName());
        Select selectCompanyType = new Select(companyTypeList);
        selectCompanyType.selectByIndex(faker.number().numberBetween(1, selectCompanyType.getOptions().size()));
        Select selectNumberOfUsers = new Select(numberOfUsersBox);
        selectNumberOfUsers.selectByIndex(faker.number().numberBetween(1, selectNumberOfUsers.getOptions().size()));
        emailBox.sendKeys(faker.internet().emailAddress());
        phoneBox.sendKeys(faker.phoneNumber().phoneNumber());
        cellBox.sendKeys(faker.phoneNumber().cellPhone());
        areasOfInterestBox.sendKeys(faker.medical().symptoms());

    }


}
