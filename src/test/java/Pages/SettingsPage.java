package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage extends BasePage {

    private By bankAccountLinkLocator = By.cssSelector("a.settingsMenuEntry.selenium-bank-accounts-settings");


    public void clickBankAccount(){
        click(bankAccountLinkLocator);

    }


    public SettingsPage(WebDriver driver) {
        super(driver);
    }
}
