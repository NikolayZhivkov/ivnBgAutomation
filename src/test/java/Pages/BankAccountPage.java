package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankAccountPage extends BasePage {

    private By settingsLinkLocator = By.cssSelector("a.selenium-settings-menu ");
    private By bankAccountHeaderLocator = By.xpath("//div[@class=\"settingsSectionHeader\"]");
    private By addNewBankAccountLocator = By.id("new-bank-account");
    private By bankAccountNameLocator = By.id("bankaccount_name[]");
    private By chooseNewBankLocator = By.id("new-bank-name");
    private By typeNewBankNameFieldLocator = By.cssSelector("input.bank-account-name-input");
    private By ibanFieldLocator = By.xpath("//input[@name=\"iban\"]");
    private By saveButtonLocator = By.cssSelector("input.save-settings-submit-button");
    private By errorMessageLocator = By.id("error");
    private By deleteButtonLocator = By.cssSelector("a.bank-account--delete.selenium-bank-acc-delete");
    private By confirmationDeleteButton = By.xpath("//button[@class=\"modal-confirm__ok-button selenium-modal-ok-btn\"]");
    private By successMessageLocator = By.id("okmsg");
    private By editButtonLocator = By.cssSelector("a.bank-account--edit.selenium-bank-acc-edit");




    public BankAccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickSettings(){
        click(settingsLinkLocator);
    }

    public String getBankAccountHeader(){
        return getText(bankAccountHeaderLocator);
    }

    public void addNewBankAccount(){
        click(addNewBankAccountLocator);
    }
    public void bankAccountName(String BankAccountName){
        typeText(bankAccountNameLocator,BankAccountName);
    }

    public void chooseBank(String bankName){
        bankAccountDropDown(bankName);
    }

    public void chooseNewBank(String newBankName){
        click(chooseNewBankLocator);
        typeText(typeNewBankNameFieldLocator,newBankName);
    }

    public void enterIban(String iban){
        typeText(ibanFieldLocator,iban);
    }

    public void selectCurrency(String currency){
        selectBankCurrency(currency);
    }

    public void clickSaveButton(){
        click(saveButtonLocator);
    }

    public String getErrorMessage(){
        return getText(errorMessageLocator);
    }

    public void deleteBankAccount(){
        click(deleteButtonLocator);
        click(confirmationDeleteButton);
    }

    public String getSuccessMessage(){
        return getText(successMessageLocator);
    }
    public void editBankAccount(){
        click(editButtonLocator);
    }


}
