package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By headerPanelLocator = By.xpath("//div[@class=\"userpanel-header\"]");
    private By logoutButtonLocator = By.xpath("//a[@class=\"selenium-button-logout button-logout\"]");
    private By verificationMessageLocator = By.id("okmsg");
    private By settingMenuLocator = By.cssSelector("a.selenium-settings-menu ");
    private By settingsHeaderLocator = By.xpath("//div[@class=\"settingsHeader\"]");

    public String getHeaderPanelText() {
        return getText(headerPanelLocator);
    }

    public void clickHeaderPanel() {
        click(headerPanelLocator);
    }

    public void clickLogoutButton() {
        click(logoutButtonLocator);
    }

    public String getVerificationMessage() {
        return getText(verificationMessageLocator);
    }

    public void logout() {
        clickHeaderPanel();
        clickLogoutButton();
        Assertions.assertEquals("Вие излязохте от акаунта си.", getVerificationMessage());
    }

    public void clickSettingsMenu(){
        click(settingMenuLocator);
    }

    public String getSettingsHeader(){
        return getText(settingsHeaderLocator);
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
