package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By emailFieldLocator = By.id("loginusername");
    private By passwordFieldLocator = By.id("loginpassword");
    private By loginButtonLocator = By.id("loginsubmit");
    private By errorMessageLocator = By.id("error");
    private By successMessageLocator = By.id("okmsg");
    private By userPanelHeader = By.cssSelector("div.userpanel-header");

    public void enterEmail(String email) {
        typeText(emailFieldLocator, email);
    }

    public void enterPassword(String password) {
        typeText(passwordFieldLocator, password);
    }

    public void clickLoginButton() {
        click(loginButtonLocator);
    }

    public String getErrorMessage() {
        return getText(errorMessageLocator);
    }

    public String successMessage() {
        return getText(successMessageLocator);
    }

    public String getSuccessLoginMessage() {
        return getText(userPanelHeader);
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
        Assertions.assertEquals("nizhivkov@gmail.com", getSuccessLoginMessage());

    }

    public void defaultLogin() {
        login("nizhivkov@gmail.com", "123456");
        clickLoginButton();
        Assertions.assertEquals("nizhivkov@gmail.com", getSuccessLoginMessage());
    }



    public LoginPage(WebDriver driver) {
        super(driver);
    }

}
